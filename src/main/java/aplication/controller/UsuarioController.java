package aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aplication.dto.UsuarioDTO;
import aplication.model.Usuario;
import aplication.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping("/{idusuario}")
	public ResponseEntity<?> findPorId(@PathVariable Integer idusuario) {
		Usuario usuario = service.findPorId(idusuario);
		return ResponseEntity.ok().body(usuario);
	}
	@PostMapping
	public ResponseEntity<?> addusuario(@RequestBody Usuario usu) {
		Usuario usuario = service.addUsuario(usu);
		return ResponseEntity.ok().body(usuario);

	}
	@DeleteMapping("/{idusuario}")
	public void deleteUsu(@PathVariable Integer idusuario) {
		service.deleteUsu(idusuario);

	}
	@PutMapping("/{idusuario}")
	public ResponseEntity<?> updateUsuario(@PathVariable Integer idusuario, @RequestBody UsuarioDTO usu) {
		usu.setId(idusuario);
		Usuario usuario = service.updateUsuario(usu);
		return ResponseEntity.ok().body(usuario);
	}
}
