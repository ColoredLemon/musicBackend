package com.musicBackend.musicBackend.models;

import javax.persistence.*;

@Entity
@Table
public class Permission {
    @Id
    @SequenceGenerator(
            name = "permission_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permission_sequence"
    )

    private Long id;
    private int roleID;
    private String perModule;
    private String perName;

    public Permission(int roleID, String perModule, String perName) {
        this.roleID = roleID;
        this.perModule = perModule;
        this.perName = perName;
    }

    public Permission(Long id, int roleID, String perModule, String perName) {
        this.id = id;
        this.roleID = roleID;
        this.perModule = perModule;
        this.perName = perName;
    }

    public Permission() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getPerModule() {
        return perModule;
    }

    public void setPerModule(String perModule) {
        this.perModule = perModule;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", roleID=" + roleID +
                ", perModule='" + perModule + '\'' +
                ", perName='" + perName + '\'' +
                '}';
    }
}
