package yorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yorms.pojo.user.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findById(long id);

    void deleteById(Long id);
}