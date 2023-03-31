package com.example.dapm_quan_ly_thu_cung_nhom_27.bean;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    private String roleId;
    private String roleName;
    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL)
    private TaiKhoan taiKhoan;

    public Role() {
    }

    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
