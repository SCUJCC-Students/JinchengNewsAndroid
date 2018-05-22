/*
 author 郑维一

 File：News.java
 Description：News Class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

public class News {
    private String title;       //标题
    private String content;     //内容
    private String author;      //作者
    private String views;       //浏览量

    /**
     * 新闻标题
     * @return 返回标题字符串
     */
    public String getTitle() {
        return title;
    }
    public void setTitle(String title ) {
        this.title = title;
    }

    /**
     * 新闻作者
     * @return 返回作者字符串
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author ) {
        this.author = author;
    }

    /**
     * 新闻浏览量
     * @return 返回新闻浏览量
     */
    public String getViews() {
        return views;
    }
    public void setViews(String views ) {
        this.views = views;
    }

    /**
     * 新闻内容
     * @return 返回内容字符串
     */
    public String getContent() {
        return content;
    }
    public void setContent(String content ) {
        this.content = content;
    }
}
