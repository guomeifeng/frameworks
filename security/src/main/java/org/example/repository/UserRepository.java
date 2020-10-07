package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by kelly on 30/09/2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
    public List<User> findUsersByName(String username);

}
