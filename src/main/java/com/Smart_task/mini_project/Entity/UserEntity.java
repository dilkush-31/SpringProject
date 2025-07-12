package com.Smart_task.mini_project.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Smart-database")
public  class UserEntity implements UserDetails {


    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

    private List<String> roles = new ArrayList<>();


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;  // Using email for login
    }

    @Override public String getPassword() { return password; }

    @Override public boolean isAccountNonExpired()     { return true; }

    @Override public boolean isAccountNonLocked()      { return true; }

    @Override public boolean isCredentialsNonExpired() { return true; }

    @Override public boolean isEnabled()               { return true; }

}
