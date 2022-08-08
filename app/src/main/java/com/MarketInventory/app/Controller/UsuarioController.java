package com.MarketInventory.app.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarketInventory.app.Model.Usuario;
import com.MarketInventory.app.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	private final UserRepository _repository;
	
	public UsuarioController(UserRepository repository) {
		this._repository = repository;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(_repository.findAll());
	}

	@PostMapping("/post")
	ResponseEntity<Usuario> create(@RequestBody Usuario dto){
		return ResponseEntity.ok(_repository.save(dto));
	}
}
