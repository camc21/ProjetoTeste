package br.com.carlos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.carlos.model.Login;
import br.com.carlos.model.Permission;
import feign.Param;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	@Query("select l from Login l where l.userName = :userName")
	Login findByUserName(@Param("userName") String userName);
	
	@Query("select"
			+ " new br.com.carlos.model.Permission(p.description)"
			+ " from Login l"
			+ " inner join l.permissions p"
			+ " where l.idLogin = :idLogin")
	List<Permission> findRolesByIdLogin(@Param("idLogin") Long idLogin);
	
//	@Query("SELECT"
//			+ " new br.com.carlos.dto.LoginDTO(l.idLogin, l.userName, l.password, p.description)"
//			+ "	FROM Login l"
//			+ " inner join l.permissions p"
//			+ " WHERE l.idLogin = :idLogin")
//	LoginDTO findByUserNameDTO(@Param("idLogin") Long idLogin);
	
	@Query("SELECT"
			+ " new br.com.carlos.model.Login(l.idLogin, l.userName, l.password, p.description)"
			+ "	FROM Login l"
			+ " inner join l.permissions p"
			+ " WHERE l.idLogin = :idLogin")
	Login findByUserNameDTO(@Param("idLogin") Long idLogin);

}
