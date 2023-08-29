package aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aplication.dto.UsuarioDTO;
import aplication.model.Usuario;
import aplication.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value = "/{idusuario}", method = RequestMethod.GET)
	public ResponseEntity<?> findPorId(@PathVariable Integer idusuario) {
		Usuario usuario = service.findPorId(idusuario);
		return ResponseEntity.ok().body(usuario);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addusuario(@RequestBody Usuario usu) {
		Usuario usuario = service.addUsuario(usu);
		return ResponseEntity.ok().body(usuario);

	}
	@RequestMapping(value = "/{idusuario}", method = RequestMethod.DELETE)
	public void deleteUsu(@PathVariable Integer idusuario) {
		service.deleteUsu(idusuario);

	}
	@RequestMapping(value = "/{idusuario}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUsuario(@PathVariable Integer idusuario, @RequestBody UsuarioDTO usu) {
		usu.setId(idusuario);
		Usuario usuario = service.updateUsuario(usu);
		return ResponseEntity.ok().body(usuario);
	}
}
