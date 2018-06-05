/*
 author 郑维一

 File：Category.java
 Description：News Class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.object;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Category {
    @Id
    private Long id;        //类别ID
    private String name;    //类名

    @Generated(hash = 1003047676)
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
