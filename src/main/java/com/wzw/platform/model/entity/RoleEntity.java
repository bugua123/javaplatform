package com.wzw.platform.model.entity;

public class RoleEntity {
        /**
         * id
         */
        private int id;
        /**
         * 角色
         */
        private String role;
        /**
         * 角色名称
         */
        private String name;
        /**
         * 权限
         */
        private String modules;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
         * 描述
         */
        private String describe;

    }
