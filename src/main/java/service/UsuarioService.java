package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Permissao;
import model.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

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
		usu.setNome(usuario.getNome());
		return usuarioRepository.save(usu);
	}

	public Usuario addUsuario(Usuario usuario) {
		Usuario usu = new Usuario(usuario);
		return usuarioRepository.save(usu);
	}
}
