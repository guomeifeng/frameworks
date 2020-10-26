package org.example.repository;

import org.example.entity.FmRole;
import org.example.entity.FmRoleResourceRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by kelly on 30/09/2020.
 */
@Repository
public interface RoleResourceRepository extends JpaRepository<FmRoleResourceRelation, Long>{
    List<Long> getResourcesByRoleIds(List<Long> roleIds);

//    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
//    public List<User> findUsersByName(String username);

}
