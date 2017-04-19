package com.example.admin_jyb.myapplication.Show.Bean;

import java.util.List;

/**
 * Created by Admin-JYB on 2016/9/27.
 */

public class ZhiHu {

    /**
     * date : 20170419
     * stories : [{"title":"LOL 和 DOTA 2 到底哪个更复杂？","ga_prefix":"041916","images":["https://pic4.zhimg.com/v2-99c7db359890b00110ec4297a2c84d23.jpg"],"multipic":true,"type":0,"id":9365989},{"images":["https://pic4.zhimg.com/v2-e6687d90b957436ff55d38566568752b.jpg"],"type":0,"id":9354748,"ga_prefix":"041915","title":"柜子一推变桌子、大床折叠能上墙的「变形家具」，真正用起来可能会累哭"},{"images":["https://pic1.zhimg.com/v2-385e44c66651808fb2325473cb1074d4.jpg"],"type":0,"id":9367742,"ga_prefix":"041914","title":"怎么这群男生看个足球节目就哭得稀里哗啦？"},{"images":["https://pic2.zhimg.com/v2-9e2c45b66b4fdecb2acfd5fd478ae655.jpg"],"type":0,"id":9366963,"ga_prefix":"041913","title":"到底选哪一张照片当头像呢，这事最好问个陌生人"},{"images":["https://pic4.zhimg.com/v2-e5f5dfea78f493ca91d28406ffbb8be3.jpg"],"type":0,"id":9366731,"ga_prefix":"041912","title":"大误 · 保护文物，从我做起！"},{"images":["https://pic2.zhimg.com/v2-fee4fe1c0c5c1b285e27da57bb3bafa1.jpg"],"type":0,"id":9366134,"ga_prefix":"041910","title":"走进航站楼的那一刻，我们就掉入了这个精心设计的系统"},{"images":["https://pic4.zhimg.com/v2-43868e95a5447a64ad3eb09f22c61e2b.jpg"],"type":0,"id":9366622,"ga_prefix":"041909","title":"借腹生子： 不为人知且乱象丛生的地下代孕市场"},{"images":["https://pic2.zhimg.com/v2-d42cc7d9604bbb5bcea9920e72919c39.jpg"],"type":0,"id":9366884,"ga_prefix":"041908","title":"每个人选一个数，谁大谁就赢，这游戏还不简单？"},{"images":["https://pic2.zhimg.com/v2-095527594e5bc39abdbeca6fe89af371.jpg"],"type":0,"id":9367712,"ga_prefix":"041907","title":"最早明天，中国首个货运飞船「天舟一号」就要发射"},{"images":["https://pic3.zhimg.com/v2-fa55d4a3fd825f2dcab1ff81dfcfd48a.jpg"],"type":0,"id":9366814,"ga_prefix":"041907","title":"对于中国乒乓球来说，日本是很值得尊重的对手"},{"images":["https://pic2.zhimg.com/v2-c967c350ba4a6442449275cba68d0cc5.jpg"],"type":0,"id":9367103,"ga_prefix":"041907","title":"做了「看时爽死、出门即忘」的准备，速 8 依然让人失望"},{"images":["https://pic1.zhimg.com/v2-8f19cbf82414ccd35c94fbacf6dee468.jpg"],"type":0,"id":9366645,"ga_prefix":"041906","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-63740b573f8ed42be05cb935944883a9.jpg","type":0,"id":9354748,"ga_prefix":"041915","title":"柜子一推变桌子、大床折叠能上墙的「变形家具」，真正用起来可能会累哭"},{"image":"https://pic2.zhimg.com/v2-78421626cadc2959e3484ba8f04c4859.jpg","type":0,"id":9367712,"ga_prefix":"041907","title":"最早明天，中国首个货运飞船「天舟一号」就要发射"},{"image":"https://pic1.zhimg.com/v2-647f8ff01179b922d0948dc9a44dd868.jpg","type":0,"id":9367103,"ga_prefix":"041907","title":"做了「看时爽死、出门即忘」的准备，速 8 依然让人失望"},{"image":"https://pic3.zhimg.com/v2-26021e74b7b90a2c507ba9eda8dfe1aa.jpg","type":0,"id":9366622,"ga_prefix":"041909","title":"借腹生子： 不为人知且乱象丛生的地下代孕市场"},{"image":"https://pic4.zhimg.com/v2-c895d16e8e3de78d360f1d96ebc96c2b.jpg","type":0,"id":9366155,"ga_prefix":"041815","title":"「乐视挪用易到 13 亿资金」曝出之前，矛盾已经埋了很久"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : LOL 和 DOTA 2 到底哪个更复杂？
         * ga_prefix : 041916
         * images : ["https://pic4.zhimg.com/v2-99c7db359890b00110ec4297a2c84d23.jpg"]
         * multipic : true
         * type : 0
         * id : 9365989
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-63740b573f8ed42be05cb935944883a9.jpg
         * type : 0
         * id : 9354748
         * ga_prefix : 041915
         * title : 柜子一推变桌子、大床折叠能上墙的「变形家具」，真正用起来可能会累哭
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
