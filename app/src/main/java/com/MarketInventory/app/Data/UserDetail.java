package com.MarketInventory.app.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.MarketInventory.app.Model.Usuario;

public class UserDetail implements UserDetails {

    private final Optional<Usuario> _user;

    public UserDetail(Optional<Usuario> _user) {
        this._user = _user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return _user.orElse(new Usuario()).getPassword();
    }

    @Override
    public String getUsername() {
        return _user.orElse(new Usuario()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
