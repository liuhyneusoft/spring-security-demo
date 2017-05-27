package com.s.domain;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="s_user")
public class SysUser implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name; //用户名
    private String email;//用户邮箱
    private String password;//用户密码

    private Date dob;//时间
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)//级联保存、更新、删除、刷新;延迟加载
    @JoinColumn(name="uid")
    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser() {
    }

    public SysUser(String name, String email, String password, Date dob, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.SysRoles = SysRoles;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<SysRole> getSysRoles() {
        return this.SysRoles;
    }

    public void setSRoles(Set<SysRole> SysRoles) {
        this.SysRoles = SysRoles;
    }

}
