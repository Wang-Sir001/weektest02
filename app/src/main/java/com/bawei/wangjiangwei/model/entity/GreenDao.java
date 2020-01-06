package com.bawei.wangjiangwei.model.entity;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class GreenDao {
    @Id(autoincrement = true)
    private Long id;
    private String json;
    private String key;
    @Generated(hash = 1787847454)
    public GreenDao(Long id, String json, String key) {
        this.id = id;
        this.json = json;
        this.key = key;
    }
    @Generated(hash = 766040118)
    public GreenDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }

}
