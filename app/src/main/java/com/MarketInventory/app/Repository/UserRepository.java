package com.MarketInventory.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MarketInventory.app.Model.Usuario;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
	public Optional<Usuario> findByUsername(String username);
}
