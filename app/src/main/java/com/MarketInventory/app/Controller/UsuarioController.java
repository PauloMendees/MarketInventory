package com.MarketInventory.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarketInventory.app.Model.Usuario;
import com.MarketInventory.app.Model.dto.LoginDto;
import com.MarketInventory.app.Providers.Validators.PasswordValidator;
import com.MarketInventory.app.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	private final UserRepository _repository;
	private final PasswordEncoder _encoder;
	
	public UsuarioController(UserRepository repository, PasswordEncoder encoder) {
		this._repository = repository;
		this._encoder = encoder;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(_repository.findAll());
	}

	@PostMapping("/post")
	ResponseEntity<Object> create(@RequestBody Usuario dto){
		try {
			PasswordValidator validator = new PasswordValidator();
			if(validator.compare(dto.getPassword(), dto.getConfirmPassword()) && validator.lenght(dto.getPassword())){
				dto.setPassword(_encoder.encode(dto.getPassword()));
				dto.setConfirmPassword(_encoder.encode(dto.getConfirmPassword()));
				return ResponseEntity.ok(_repository.save(dto));
			}
			return ResponseEntity.status(406).body("Senhas não conferem ou não possui 8 dígitos.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro interno.");
		}
	}

	@PostMapping("/login")
	ResponseEntity<Object> login(@RequestBody LoginDto dto){
		try {
			Optional<Usuario> user = _repository.findByUsername(dto.getUsername());
			if(user.isEmpty()) return ResponseEntity.status(401).body("Usuário ou senha inválidos.");

			boolean valid = _encoder.matches(dto.getPassword(), user.get().getPassword());
			if(valid) return ResponseEntity.ok(user);
			return ResponseEntity.status(401).body("Usuário ou senha inválidos.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro interno.");
		}
	}
}
