package aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplication.model.Permissao;
import aplication.model.Usuario;
import aplication.repository.UsuarioRepository;

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

	public static Usuario addUsuario(String nome, String cpf, String senha, Permissao permissao) {
		return new Usuario(null, nome, cpf, senha, permissao);
	}
}
