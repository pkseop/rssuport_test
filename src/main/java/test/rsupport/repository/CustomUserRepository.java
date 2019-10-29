package test.rsupport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import test.rsupport.entity.CustomUser;

@RepositoryRestResource
public interface CustomUserRepository extends JpaRepository<CustomUser, Integer>{
	
	Optional<CustomUser> findByUsername(String username);

}
