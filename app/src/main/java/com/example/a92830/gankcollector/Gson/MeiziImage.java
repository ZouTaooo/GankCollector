package com.example.a92830.gankcollector.Gson;

import java.util.List;

/**
 * Created by 92830 on 2017/7/11.
 */

public class MeiziImage {

    /**
     * error : false
     * results : [{"_id":"59641954421aa90c9203d362","createdAt":"2017-07-11T08:18:28.124Z","desc":"佐佐木希","publishedAt":"2017-07-11T13:46:33.911Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg","used":true,"who":"代码家"},{"_id":"5962c411421aa90ca209c425","createdAt":"2017-07-10T08:02:25.353Z","desc":"7-10","publishedAt":"2017-07-10T12:48:49.297Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg","used":true,"who":"daimajia"},{"_id":"595ed766421aa90ca209c407","createdAt":"2017-07-07T08:35:50.172Z","desc":"7-7","publishedAt":"2017-07-07T12:14:57.685Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhb0t7ob2mj20u011itd9.jpg","used":true,"who":"daimajia"},{"_id":"595d82f6421aa90ca3bb6aaa","createdAt":"2017-07-06T08:23:18.945Z","desc":"07-06","publishedAt":"2017-07-06T11:57:03.770Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034gy1fh9utulf4kj20u011itbo.jpg","used":true,"who":"代码家"},{"_id":"595c2f23421aa90ca209c3f0","createdAt":"2017-07-05T08:13:23.237Z","desc":"2017-07-5","publishedAt":"2017-07-05T11:15:30.556Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fh8ox6bmjlj20u00u0mz7.jpg","used":true,"who":"daimajia"},{"_id":"595ad246421aa90ca3bb6a91","createdAt":"2017-07-04T07:24:54.820Z","desc":"7-4","publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fh7hwi9lhzj20u011hqa9.jpg","used":true,"who":"daimajia"},{"_id":"5941db7b421aa92c794633cd","createdAt":"2017-06-15T08:57:31.47Z","desc":"6-15","publishedAt":"2017-06-15T13:55:57.947Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fgllsthvu1j20u011in1p.jpg","used":true,"who":"代码家"},{"_id":"593f1ff7421aa92c73b64803","createdAt":"2017-06-13T07:12:55.795Z","desc":"6-13","publishedAt":"2017-06-14T11:34:54.556Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fgj7jho031j20u011itci.jpg","used":true,"who":"daimajia"},{"_id":"593dde44421aa92c73b647f5","createdAt":"2017-06-12T08:20:20.475Z","desc":"6-12","publishedAt":"2017-06-12T11:11:11.25Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fgi3vd6irmj20u011i439.jpg","used":true,"who":"代码家"},{"_id":"5939fcb1421aa92c7be61bd5","createdAt":"2017-06-09T09:41:05.305Z","desc":"6-9","publishedAt":"2017-06-09T12:50:03.131Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg","used":true,"who":"dmj"}]
     */

    public List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59641954421aa90c9203d362
         * createdAt : 2017-07-11T08:18:28.124Z
         * desc : 佐佐木希
         * publishedAt : 2017-07-11T13:46:33.911Z
         * source : chrome
         * type : 福利
         * url : https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg
         * used : true
         * who : 代码家
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
