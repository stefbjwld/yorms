package yorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yorms.pojo.user.GroupM;


public interface GroupMRepository extends JpaRepository<GroupM, Long> {

	GroupM findById(long id);

    void deleteById(Long id);
}