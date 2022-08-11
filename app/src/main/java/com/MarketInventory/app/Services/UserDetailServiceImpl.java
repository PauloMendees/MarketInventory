package com.MarketInventory.app.Services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.MarketInventory.app.Data.UserDetail;
import com.MarketInventory.app.Model.Usuario;
import com.MarketInventory.app.Repository.UserRepository;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository _repository;

    public UserDetailServiceImpl(UserRepository _repository) {
        this._repository = _repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = _repository.findByUsername(username);

        if(user.isEmpty()) throw new UsernameNotFoundException("Usuário não encontrado.");
        return new UserDetail(user);
    }
    
}
