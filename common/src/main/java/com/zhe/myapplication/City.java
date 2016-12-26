package com.zhe.myapplication;

import java.util.List;

/**
 * Created by zhe on 2016/12/23.
 */

public class City {


    /**
     * continentId : 0
     * continentName : 国家地区
     * countryList : [{"cityList":[{"cityId":"100000","cityName":"纽约","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"New York","id":1,"picUrl":"http://oss.yaok.com/city/niuyue.jpg","pinyin":"niu yue ","sort":0,"status":1,"timeZone":"GMT-5","updateTime":0},{"cityId":"100001","cityName":"洛杉矶","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Los Angeles","id":2,"picUrl":"http://oss.yaok.com/city/luoshanji.jpg","pinyin":"luo shan ji ","sort":1,"status":1,"timeZone":"GMT-8","updateTime":0},{"cityId":"100003","cityName":"拉斯维加斯","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Las Vegas","id":4,"picUrl":"http://oss.yaok.com/city/lasiweijiasi.jpg","pinyin":"la si wei jia si ","sort":3,"status":1,"timeZone":"GMT-8","updateTime":0},{"cityId":"100004","cityName":"夏威夷","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Hawaii","id":5,"picUrl":"http://oss.yaok.com/city/xiaweiyi.jpg","pinyin":"xia wei yi ","sort":4,"status":1,"timeZone":"GMT-10","updateTime":0},{"cityId":"100005","cityName":"迈阿密","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Miami","id":6,"picUrl":"http://oss.yaok.com/city/maiami.jpg","pinyin":"mai a mi ","sort":5,"status":1,"timeZone":"GMT-5","updateTime":0}],"countryId":"100000","countryName":"美国","createTime":0,"deleteFlag":0,"enName":"United States of America","sort":87,"status":1,"updateTime":0},{"cityList":[{"cityId":"101001","cityName":"伦敦","countryId":"101000","createTime":0,"deleteFlag":0,"enName":"London","id":7,"picUrl":"http://oss.yaok.com/city/lundun_close.jpg","pinyin":"lun dun ","sort":100000,"status":1,"timeZone":"GMT","updateTime":0}],"countryIcon":"./imgs/countryIcon/england_icon.png","countryId":"101000","countryName":"英国","createTime":0,"deleteFlag":0,"enName":"United Kindom","sort":100,"status":1,"updateTime":0},{"cityList":[{"cityId":"102001","cityName":"巴黎","countryId":"102000","createTime":0,"deleteFlag":0,"enName":"Paris","id":8,"picUrl":"http://oss.yaok.com/city/bali.jpg","pinyin":"ba li ","sort":200,"status":1,"timeZone":"GMT+1","updateTime":0}],"countryId":"102000","countryName":"法国","createTime":0,"deleteFlag":0,"enName":"France","sort":99,"status":1,"updateTime":0},{"cityList":[{"cityId":"103001","cityName":"罗马","countryId":"103000","createTime":0,"deleteFlag":0,"enName":"Rome","id":9,"picUrl":"http://oss.yaok.com/city/luoma.jpg","pinyin":"luo ma ","sort":300,"status":1,"timeZone":"GMT+2","updateTime":0},{"cityId":"103002","cityName":"佛罗伦萨","countryId":"103000","createTime":0,"deleteFlag":0,"enName":"Florence","id":10,"picUrl":"http://oss.yaok.com/city/foluolunsa.jpg","pinyin":"fo luo lun sa ","sort":301,"status":1,"timeZone":"GMT+1","updateTime":0},{"cityId":"103003","cityName":"米兰","countryId":"103000","createTime":0,"deleteFlag":0,"enName":"Milan","id":11,"picUrl":"http://oss.yaok.com/city/milan.jpg","pinyin":"mi lan ","sort":302,"status":0,"timeZone":"GMT+1","updateTime":0},{"cityId":"103004","cityName":"威尼斯","countryId":"103000","createTime":0,"deleteFlag":0,"enName":"Venice","id":12,"picUrl":"http://oss.yaok.com/city/weinisi.jpg","pinyin":"wei ni si ","sort":303,"status":1,"timeZone":"GMT+1","updateTime":0}],"countryIcon":"./imgs/countryIcon/italy_icon.png","countryId":"103000","countryName":"意大利","createTime":0,"deleteFlag":0,"enName":"Italy","sort":98,"status":0,"updateTime":0},{"cityList":[{"cityId":"104001","cityName":"柏林","countryId":"104000","createTime":0,"deleteFlag":0,"enName":"Berlin","id":13,"picUrl":"http://oss.yaok.com/city/bolin.jpg","pinyin":"bo lin ","sort":400,"status":1,"timeZone":"GMT+1","updateTime":0},{"cityId":"104003","cityName":"慕尼黑","countryId":"104000","createTime":0,"deleteFlag":0,"enName":"Munich","id":15,"picUrl":"http://oss.yaok.com/city/munihei.jpg","pinyin":"mu ni hei ","sort":402,"status":1,"timeZone":"GMT+1","updateTime":0},{"cityId":"104004","cityName":"法兰克福","countryId":"104000","createTime":0,"deleteFlag":0,"enName":"Frankfurt","id":16,"picUrl":"http://oss.yaok.com/city/falankefu.jpg","pinyin":"fa lan ke fu ","sort":403,"status":1,"timeZone":"GMT+1","updateTime":0}],"countryId":"104000","countryName":"德国","createTime":0,"deleteFlag":0,"enName":"Germany","sort":89,"status":1,"updateTime":0},{"cityList":[{"cityId":"105001","cityName":"苏黎世","countryId":"105000","createTime":0,"deleteFlag":0,"enName":"Zurich","id":17,"picUrl":"http://oss.yaok.com/city/sulishi.jpg","pinyin":"su li shi ","sort":500,"status":1,"timeZone":"GMT+1","updateTime":0},{"cityId":"105002","cityName":"日内瓦","countryId":"105000","createTime":0,"deleteFlag":0,"enName":"Geneva","id":18,"picUrl":"http://oss.yaok.com/city/rineiwa.jpg","pinyin":"ri nei wa ","sort":501,"status":1,"timeZone":"GMT+1","updateTime":0},{"cityId":"105004","cityName":"圣莫里茨","countryId":"105000","createTime":0,"deleteFlag":0,"enName":"St. Moritz","id":20,"picUrl":"http://oss.yaok.com/city/shengmolici.jpg","pinyin":"sheng mo li ci ","sort":503,"status":1,"timeZone":"GMT+1","updateTime":0}],"countryIcon":"./imgs/countryIcon/italy_icon.png","countryId":"105000","countryName":"瑞士","createTime":0,"deleteFlag":0,"enName":"Switzerland","sort":97,"status":1,"updateTime":0},{"cityList":[{"cityId":"106001","cityName":"东京","countryId":"106000","createTime":0,"deleteFlag":0,"enName":"Tokyo","id":21,"picUrl":"http://oss.yaok.com/city/dongjing.jpg","pinyin":"dong jing ","sort":600,"status":1,"timeZone":"GMT+9","updateTime":0},{"cityId":"106002","cityName":"大阪","countryId":"106000","createTime":0,"deleteFlag":0,"enName":"Osaka","id":22,"picUrl":"http://oss.yaok.com/city/daban.jpg","pinyin":"da ban ","sort":601,"status":1,"timeZone":"GMT+9","updateTime":0},{"cityId":"106003","cityName":"神户","countryId":"106000","createTime":0,"deleteFlag":0,"enName":"Kobe","id":23,"picUrl":"http://oss.yaok.com/city/shenhu.jpg","pinyin":"shen hu ","sort":602,"status":1,"timeZone":"GMT+9","updateTime":0},{"cityId":"106004","cityName":"京都","countryId":"106000","createTime":0,"deleteFlag":0,"enName":"Kyoto","id":24,"picUrl":"http://oss.yaok.com/city/jingdu.jpg","pinyin":"jing dou ","sort":603,"status":1,"timeZone":"GMT+9","updateTime":0}],"countryId":"106000","countryName":"日本","createTime":0,"deleteFlag":0,"enName":"Japan","sort":95,"status":1,"updateTime":0},{"cityList":[{"cityId":"107001","cityName":"温哥华","countryId":"107000","createTime":0,"deleteFlag":0,"enName":"Vancouver","id":25,"picUrl":"http://oss.yaok.com/city/wengehua.jpg","pinyin":"wen ge hua ","sort":700,"status":1,"timeZone":"GMT-8","updateTime":0},{"cityId":"107002","cityName":"多伦多","countryId":"107000","createTime":0,"deleteFlag":0,"enName":"Toronto","id":26,"picUrl":"http://oss.yaok.com/city/duolunduo.jpg","pinyin":"duo lun duo ","sort":701,"status":1,"timeZone":"GMT-5","updateTime":0}],"countryId":"107000","countryName":"加拿大","createTime":0,"deleteFlag":0,"enName":"Canada","sort":86,"status":1,"updateTime":0},{"cityList":[{"cityId":"108001","cityName":"悉尼","countryId":"108000","createTime":0,"deleteFlag":0,"enName":"Sydney","id":27,"picUrl":"http://oss.yaok.com/city/xini.jpg","pinyin":"xi ni ","sort":800,"status":1,"timeZone":"GMT+10","updateTime":0},{"cityId":"108002","cityName":"墨尔本","countryId":"108000","createTime":0,"deleteFlag":0,"enName":"Melbourne","id":28,"picUrl":"http://oss.yaok.com/city/moerben.jpg","pinyin":"mo er ben ","sort":801,"status":0,"timeZone":"GMT+10","updateTime":0}],"countryId":"108000","countryName":"澳大利亚","createTime":0,"deleteFlag":0,"enName":"Australia","sort":84,"status":1,"updateTime":0},{"cityList":[{"cityId":"113001","cityName":"马德里","countryId":"113000","createTime":0,"deleteFlag":0,"enName":"Madrid","id":33,"picUrl":"http://oss.yaok.com/city/madeli.jpg","pinyin":"ma de li ","sort":1300,"status":0,"timeZone":"GMT+1","updateTime":0},{"cityId":"113002","cityName":"巴塞罗那","countryId":"113000","createTime":0,"deleteFlag":0,"enName":"Barcelona","id":34,"picUrl":"http://oss.yaok.com/city/basailuona.jpg","pinyin":"ba sai luo nei ","sort":1301,"status":0,"timeZone":"GMT+1","updateTime":0}],"countryId":"113000","countryName":"西班牙","createTime":0,"deleteFlag":0,"enName":"Spain","sort":88,"status":1,"updateTime":0},{"cityList":[{"cityId":"116001","cityName":"新加坡","countryId":"116000","createTime":0,"deleteFlag":0,"enName":"Singapore","id":37,"picUrl":"http://oss.yaok.com/city/xinjiapo.jpg","pinyin":"xin jia po ","sort":6001,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"116000","countryName":"新加坡","createTime":0,"deleteFlag":0,"enName":"Singapore","sort":92,"status":1,"updateTime":0},{"cityList":[{"cityId":"117001","cityName":"吉隆坡","countryId":"117000","createTime":0,"deleteFlag":0,"enName":"Kuala Lumpur","id":38,"picUrl":"http://oss.yaok.com/city/jilongpo.jpg","pinyin":"ji long po ","sort":7001,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"117000","countryName":"马来西亚","createTime":0,"deleteFlag":0,"enName":"Malaysia","sort":91,"status":1,"updateTime":0},{"cityList":[{"cityId":"118001","cityName":"阿布扎比","countryId":"118000","createTime":0,"deleteFlag":0,"enName":" Abu Dhabi","id":39,"picUrl":"http://oss.yaok.com/city/abuzhabi.jpg","pinyin":"a bu zha bi ","sort":8001,"status":1,"timeZone":"GMT+4","updateTime":0},{"cityId":"118002","cityName":"迪拜","countryId":"118000","createTime":0,"deleteFlag":0,"enName":"Dubai","id":40,"picUrl":"http://oss.yaok.com/city/dibai.jpg","pinyin":"di bai ","sort":8002,"status":1,"timeZone":"GMT+4","updateTime":0}],"countryId":"118000","countryName":"阿联酋","createTime":0,"deleteFlag":0,"enName":" United Arab Emirates","sort":85,"status":1,"updateTime":0},{"cityList":[{"cityId":"119001","cityName":"首尔","countryId":"119000","createTime":0,"deleteFlag":0,"enName":"Seoul","id":41,"picUrl":"http://oss.yaok.com/city/shouer.jpg","pinyin":"shou er ","sort":9001,"status":1,"timeZone":"GMT+9","updateTime":0},{"cityId":"119002","cityName":"济州岛","countryId":"119000","createTime":0,"deleteFlag":0,"enName":"Jeju Island","id":42,"picUrl":"http://oss.yaok.com/city/jizhoudao.jpg","pinyin":"ji zhou dao ","sort":9002,"status":1,"timeZone":"GMT+9","updateTime":0}],"countryIcon":"./imgs/countryIcon/korea_icon.png","countryId":"119000","countryName":"韩国","createTime":0,"deleteFlag":0,"enName":"Korea","sort":96,"status":1,"updateTime":0},{"cityList":[{"cityId":"120001","cityName":"北京","countryId":"120000","createTime":0,"deleteFlag":0,"enName":"Beijing","id":43,"picUrl":"http://oss.yaok.com/city/beijing.jpg","pinyin":"bei jing ","sort":20001,"status":1,"timeZone":"GMT+8","updateTime":0},{"cityId":"120002","cityName":"上海","countryId":"120000","createTime":0,"deleteFlag":0,"enName":"Shanghai","id":44,"picUrl":"http://oss.yaok.com/city/shanghai.jpg","pinyin":"shang hai ","sort":20002,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"120000","countryName":"中国","createTime":0,"deleteFlag":0,"enName":"China","sort":20,"status":1,"updateTime":0},{"cityList":[{"cityId":"120003","cityName":"香港","countryId":"121000","createTime":0,"deleteFlag":0,"enName":"Hong Kong","id":45,"picUrl":"http://oss.yaok.com/city/xianggang.jpg","pinyin":"xiang gang ","sort":20003,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"121000","countryName":"中国香港","createTime":0,"deleteFlag":0,"enName":"Hong Kong (China)","sort":95,"status":1,"updateTime":0},{"cityList":[{"cityId":"120004","cityName":"澳门","countryId":"122000","createTime":0,"deleteFlag":0,"enName":"Macau","id":46,"picUrl":"http://oss.yaok.com/city/aomen.jpg","pinyin":"ao men ","sort":20004,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"122000","countryName":"中国澳门","createTime":0,"deleteFlag":0,"enName":"Macau (China)","sort":94,"status":1,"updateTime":0},{"cityList":[{"cityId":"120005","cityName":"台北","countryId":"123000","createTime":0,"deleteFlag":0,"enName":"Taipei","id":47,"picUrl":"http://oss.yaok.com/city/taibei.jpg","pinyin":"tai bei ","sort":20005,"status":1,"timeZone":"GMT+8","updateTime":0}],"countryId":"123000","countryName":"中国台湾","createTime":0,"deleteFlag":0,"enName":"Taiwan (China)","sort":93,"status":1,"updateTime":0},{"cityList":[{"cityId":"124001","cityName":"曼谷","countryId":"124000","createTime":0,"deleteFlag":0,"enName":"Bankok","id":48,"picUrl":"http://oss.yaok.com/city/mangu.jpg","pinyin":"man gu ","sort":24000,"status":1,"timeZone":"GMT+7","updateTime":0}],"countryId":"124000","countryName":"泰国","createTime":0,"deleteFlag":0,"enName":"Thailand","sort":91,"status":1,"updateTime":0},{"cityList":[{"cityId":"125001","cityName":"雅加达","countryId":"125000","createTime":0,"deleteFlag":0,"enName":" Jakarta","id":49,"picUrl":"http://oss.yaok.com/city/yajiada.jpg","pinyin":"ya jia da ","sort":25000,"status":1,"timeZone":"GMT+7","updateTime":0}],"countryId":"125000","countryName":"印度尼西亚","createTime":0,"deleteFlag":0,"enName":"Indonesia","sort":90,"status":1,"updateTime":0}]
     */

    private String continentId;
    private String continentName;
    private List<CountryListBean> countryList;

    public void setContinentId(String continentId) {
        this.continentId = continentId;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public void setCountryList(List<CountryListBean> countryList) {
        this.countryList = countryList;
    }

    public String getContinentId() {
        return continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<CountryListBean> getCountryList() {
        return countryList;
    }

    public static class CountryListBean {
        /**
         * cityList : [{"cityId":"100000","cityName":"纽约","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"New York","id":1,"picUrl":"http://oss.yaok.com/city/niuyue.jpg","pinyin":"niu yue ","sort":0,"status":1,"timeZone":"GMT-5","updateTime":0},{"cityId":"100001","cityName":"洛杉矶","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Los Angeles","id":2,"picUrl":"http://oss.yaok.com/city/luoshanji.jpg","pinyin":"luo shan ji ","sort":1,"status":1,"timeZone":"GMT-8","updateTime":0},{"cityId":"100003","cityName":"拉斯维加斯","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Las Vegas","id":4,"picUrl":"http://oss.yaok.com/city/lasiweijiasi.jpg","pinyin":"la si wei jia si ","sort":3,"status":1,"timeZone":"GMT-8","updateTime":0},{"cityId":"100004","cityName":"夏威夷","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Hawaii","id":5,"picUrl":"http://oss.yaok.com/city/xiaweiyi.jpg","pinyin":"xia wei yi ","sort":4,"status":1,"timeZone":"GMT-10","updateTime":0},{"cityId":"100005","cityName":"迈阿密","countryId":"100000","createTime":0,"deleteFlag":0,"enName":"Miami","id":6,"picUrl":"http://oss.yaok.com/city/maiami.jpg","pinyin":"mai a mi ","sort":5,"status":1,"timeZone":"GMT-5","updateTime":0}]
         * countryId : 100000
         * countryName : 美国
         * createTime : 0
         * deleteFlag : 0
         * enName : United States of America
         * sort : 87
         * status : 1
         * updateTime : 0
         */

        private String countryId;
        private String countryName;
        private int createTime;
        private int deleteFlag;
        private String enName;
        private int sort;
        private int status;
        private int updateTime;
        private List<CityListBean> cityList;

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public void setDeleteFlag(int deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public void setCityList(List<CityListBean> cityList) {
            this.cityList = cityList;
        }

        public String getCountryId() {
            return countryId;
        }

        public String getCountryName() {
            return countryName;
        }

        public int getCreateTime() {
            return createTime;
        }

        public int getDeleteFlag() {
            return deleteFlag;
        }

        public String getEnName() {
            return enName;
        }

        public int getSort() {
            return sort;
        }

        public int getStatus() {
            return status;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public List<CityListBean> getCityList() {
            return cityList;
        }

        public static class CityListBean {
            /**
             * cityId : 100000
             * cityName : 纽约
             * countryId : 100000
             * createTime : 0
             * deleteFlag : 0
             * enName : New York
             * id : 1
             * picUrl : http://oss.yaok.com/city/niuyue.jpg
             * pinyin : niu yue
             * sort : 0
             * status : 1
             * timeZone : GMT-5
             * updateTime : 0
             */

            private String cityId;
            private String cityName;
            private String countryId;
            private int createTime;
            private int deleteFlag;
            private String enName;
            private int id;
            private String picUrl;
            private String pinyin;
            private int sort;
            private int status;
            private String timeZone;
            private int updateTime;

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }

            public void setDeleteFlag(int deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public void setEnName(String enName) {
                this.enName = enName;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setTimeZone(String timeZone) {
                this.timeZone = timeZone;
            }

            public void setUpdateTime(int updateTime) {
                this.updateTime = updateTime;
            }

            public String getCityId() {
                return cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public String getCountryId() {
                return countryId;
            }

            public int getCreateTime() {
                return createTime;
            }

            public int getDeleteFlag() {
                return deleteFlag;
            }

            public String getEnName() {
                return enName;
            }

            public int getId() {
                return id;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public String getPinyin() {
                return pinyin;
            }

            public int getSort() {
                return sort;
            }

            public int getStatus() {
                return status;
            }

            public String getTimeZone() {
                return timeZone;
            }

            public int getUpdateTime() {
                return updateTime;
            }
        }
    }
}
