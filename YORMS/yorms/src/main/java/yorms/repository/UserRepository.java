package yorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yorms.pojo.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    
    public User findByUserName(String username);

    void deleteById(Long id);
}