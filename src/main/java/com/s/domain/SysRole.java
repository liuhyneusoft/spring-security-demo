package com.s.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liuhaiyang on 2017/5/25.
 */

@Entity
@Table(name="s_role")
public class SysRole {
    @Id
    @GeneratedValue
    private int id;
    private SysUser SUser;//角色对应的用户实体

    private String name;//角色名称

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SysUser getSUser() {
        return SUser;
    }
    public void setSUser(SysUser sUser) {
        SUser = sUser;
    }


}
