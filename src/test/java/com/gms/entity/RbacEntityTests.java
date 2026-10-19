package com.gms.entity;

import com.gms.entity.enums.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RbacEntityTests {

    @Test
    @DisplayName("Should successfully link and synchronize Role and Permission")
    void testRolePermissionAssociation() {
        Role adminRole = new Role(RoleType.ROLE_ADMIN, "System Administrator");
        Permission userRead = new Permission("USER_READ", "Permission to view users");

        adminRole.addPermission(userRead);

        assertTrue(adminRole.getPermissions().contains(userRead));
        assertTrue(userRead.getRoles().contains(adminRole));

        adminRole.removePermission(userRead);

        assertFalse(adminRole.getPermissions().contains(userRead));
        assertFalse(userRead.getRoles().contains(adminRole));
    }

    @Test
    @DisplayName("Should successfully link and synchronize User and Role")
    void testUserRoleAssociation() {
        User user = new User("johndoe", "john@example.com", "secureHash");
        Role memberRole = new Role(RoleType.ROLE_MEMBER, "Standard Member");

        user.addRole(memberRole);

        assertTrue(user.getRoles().contains(memberRole));
        assertTrue(memberRole.getUsers().contains(user));

        user.removeRole(memberRole);

        assertFalse(user.getRoles().contains(memberRole));
        assertFalse(memberRole.getUsers().contains(user));
    }
}
