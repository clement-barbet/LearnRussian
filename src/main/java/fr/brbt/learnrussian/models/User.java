package fr.brbt.learnrussian.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(nullable = false, name = "id")
    private Integer id;
    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="active")
    private Integer active;

    @Column(name="roles")
    private String roles = "";
    @Column(name="permissions")
    private String permissions = "";

    public User(Integer id, String username, String password, int active, String roles, String permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = 1;
        this.roles = roles;
        this.permissions = permissions;
    }

    protected User() {

    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getPermissionList() {
        return getPermissions() != null ? Arrays.asList(getPermissions().split(",")) : new ArrayList<>();
    }

    public List<String> getRoleList() {
        return getRoles() != null ? Arrays.asList(getRoles().split(",")) : new ArrayList<>();
    }
}
