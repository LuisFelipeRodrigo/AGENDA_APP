package aplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aplication.model.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(value = "SELECT * FROM usuario", nativeQuery = true)
	List<Usuario> findAllCat();

	@Query(value = "SELECT * FROM usuario where id = ?", nativeQuery = true)
	Usuario findPorId(Integer idusuario);
	
	@Query(value= "select * from usuario where telefone = ?", nativeQuery = true)
	Usuario findPorTelefone(String telefone);

	Optional<Usuario> findByCpf(String cpf);
	
	public Optional<Usuario> findByEmail(String email);
}
