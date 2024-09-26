package com.user.microservice.domain.util;

import java.util.List;

public enum Role {

    ADMIN(List.of(Permission.REGISTER_AUX)),
    AUX_BODEGA(List.of());

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
