package com.test.dynamic.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018-03-12.
 */
@Entity
public class Stu {
    @Id
    private long id;
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 436860835)
    public Stu(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 501767467)
    public Stu() {
    }
}
