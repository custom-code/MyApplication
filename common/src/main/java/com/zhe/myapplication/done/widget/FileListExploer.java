package com.zhe.myapplication.done.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zhe.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FileListExploer {
    private Dialog dialog = null;
    public static final String IMAGE = ".jpeg; .jpg; .png; .bmp;";
    public static final String VIDEO = ".mp4; .wmv;";
    public static final String AUDIO = ".mp3; .wav;";

    public FileListExploer(Context context, String title, String type) {
        createDialog(context, title, type).show();
    }

    private Dialog createDialog(Context context, String title, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(new FileSelectView(context, type));
        dialog = builder.create();
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setTitle(title);
        return dialog;
    }

    private class FileSelectView extends ListView implements OnItemClickListener {
        private final String sRoot = "/";
        private final String sParent = "..";
        private final String sFolder = ".";
        private final String sEmpty = "";
        private final String sOnErrorMsg = "No rights to access!";
        private String path = sRoot;
        private List<Map<String, Object>> list = null;
        private Map<String, Integer> map = null;
        private String types;

        public FileSelectView(Context context, String type) {
            super(context);
            this.types = type;
            this.map = createImageMap();
            this.setOnItemClickListener(this);
            refreshFileList();
        }

        /**
         * 显示图标
         *
         * @return
         */
        private Map<String, Integer> createImageMap() {
            Map<String, Integer> images = new HashMap<>();
            images.put(sRoot, R.drawable.check_file_root); // 根目录图标
            images.put(sParent, R.drawable.check_file_folder_up); // 返回上一层的图标
            images.put(sFolder, R.drawable.check_file_folder); // 文件夹图标
            images.put(sEmpty, R.drawable.check_file_root);
            return images;
        }

        /**
         * 截取文件名的后缀
         *
         * @param filename
         * @return
         */
        private String getSuffix(String filename) {
            int dix = filename.lastIndexOf('.');
            if (dix < 0) {
                return "";
            } else {
                return filename.substring(dix + 1);
            }
        }

        /**
         * 获取图片id，用于设置预览图
         *
         * @param s
         * @return
         */
        private int getImageId(String s) {
            if (map == null) {
                return 0;
            } else if (map.containsKey(s)) {
                return map.get(s);
            } else if (map.containsKey(sEmpty)) {
                return map.get(sEmpty);
            } else {
                return 0;
            }
        }

        /**
         * 刷新文件列表
         *
         * @return
         */
        private int refreshFileList() {
            // 刷新文件列表
            File[] files = null;
            try {
                files = new File(path).listFiles();
            } catch (Exception e) {
                files = null;
            }
            if (files == null) {
                // 访问出错
                Toast.makeText(getContext(), sOnErrorMsg, Toast.LENGTH_SHORT).show();
                return -1;
            }
            if (list != null) {
                list.clear();
            } else {
                list = new ArrayList<>(files.length);
            }

            // 用来先保存文件夹和文件夹的两个列表
            ArrayList<Map<String, Object>> lfolders = new ArrayList<>();
            ArrayList<Map<String, Object>> lfiles = new ArrayList<>();

            if (!this.path.equals(sRoot)) {
                // 添加根目录 和 上一层目录
                Map<String, Object> map = new HashMap<>();
                map.put("name", sRoot);
                map.put("path", sRoot);
                map.put("img", getImageId(sRoot));
                list.add(map);

                map = new HashMap<>();
                map.put("name", sParent);
                map.put("path", path);
                map.put("img", getImageId(sParent));
                list.add(map);
            }

            for (File file : files) {
                if (file.isDirectory() && file.listFiles() != null) {
                    // 添加文件夹
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", file.getName());
                    map.put("path", file.getPath());
                    map.put("img", getImageId(sFolder));
                    lfolders.add(map);
                } else if (file.isFile()) {
                    // 添加文件
                    String sf = getSuffix(file.getName()).toLowerCase();
                    if ((types == null || "".equals(types) || (sf.length() > 0 && types
                            .contains("." + sf + ";"))) && !"".equals(sf)) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", file.getName());
                        map.put("path", file.getPath());
                        map.put("img", getImageId(sf));
                        lfiles.add(map);
                    }
                }
            }

            list.addAll(lfolders); // 先添加文件夹，确保文件夹显示在上面
            list.addAll(lfiles); // 再添加文件

            SimpleAdapter adapter = new SimpleAdapter(getContext(), list, R.layout.item_file_list,
                    new String[]{"img", "name", "path"},
                    new int[]{R.id.item_img, R.id.item_name, R.id.item_path});
            this.setAdapter(adapter);
            return files.length;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            // 条目选择
            String pt = (String) list.get(position).get("path");
            String fn = (String) list.get(position).get("name");
            if (fn.equals(sRoot) || fn.equals(sParent)) {
                // 如果是更目录或者上一层
                File fl = new File(pt);
                String ppt = fl.getParent();
                if (ppt != null) {
                    // 返回上一层
                    path = ppt;
                } else {
                    // 返回更目录
                    path = sRoot;
                }
            } else {
                File fl = new File(pt);
                if (fl.isFile()) {
                    // 设置回调的返回值
                    Bundle bundle = new Bundle();
                    bundle.putString("path", pt);
                    bundle.putString("name", fn);
                    callback(bundle);
                    dialog.dismiss();
                    return;
                } else if (fl.isDirectory()) {
                    // 如果是文件夹
                    // 那么进入选中的文件夹
                    path = pt;
                }
            }
            this.refreshFileList();
        }
    }

    public abstract void callback(Bundle bundle);
}