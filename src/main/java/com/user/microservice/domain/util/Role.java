package com.user.microservice.domain.util;

import java.util.List;

public enum Role {

    ADMIN(List.of(Permission.REGISTER_AUX, Permission.ADD_CATEGORY, Permission.ADD_BRAND, Permission.ADD_ARTICLE)),
    AUX_BODEGA(List.of(Permission.ADD_SUPPLY)),
    CUSTOMER(List.of());


    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
