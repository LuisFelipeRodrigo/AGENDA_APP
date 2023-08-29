package aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aplication.model.Permissao;
import aplication.model.Usuario;
import aplication.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private final PasswordEncoder encoder;
	

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}
	public List<Usuario> findAll() {
		List<Usuario> list = usuarioRepository.findAllCat();
		return list;
	}
	public Usuario findPorId(Integer idusuario) {
		Usuario cat = usuarioRepository.findPorId(idusuario);
		return cat;
	}
	public void deleteUsu(Integer idusuario) {
		usuarioRepository.deleteById(idusuario);

	}
	public Usuario updateUsuario(Usuario usuario) {
	    Usuario usu = findPorId(usuario.getId());

	    if (usu != null) {
	        usu.setNome(usuario.getNome());
	        usu.setEmail(usuario.getEmail());
	        usu.setCpf(usuario.getCpf());
	        usu.setSenha(usuario.getSenha());
	        usu.setPermissao(usuario.getPermissao());

	        return usuarioRepository.save(usu);
	    } else {
	        throw new RuntimeException("Usuário não encontrado");
	    }
	}
	public Usuario addUsuario(Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
}
