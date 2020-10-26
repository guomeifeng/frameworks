package org.example.repository;

import org.example.entity.FmUserRoleRelation;
import org.example.entity.FmRole;
import org.example.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by kelly on 30/09/2020.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<FmUserRoleRelation, Long>{


    List<Long> getUserIdList(Long roleId);
}
