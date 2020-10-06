package org.example.repository;

import org.example.entity.FmAdminRoleRelation;
import org.example.entity.FmRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by kelly on 30/09/2020.
 */
@Repository
public interface AdminRoleRepository extends JpaRepository<FmAdminRoleRelation, Long>{

//    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
//    public List<User> findUsersByName(String username);

}
