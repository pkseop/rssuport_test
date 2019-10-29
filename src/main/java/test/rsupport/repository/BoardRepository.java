package test.rsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import test.rsupport.entity.Board;

@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
