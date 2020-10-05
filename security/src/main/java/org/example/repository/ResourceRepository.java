package org.example.repository;

import org.example.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by kelly on 5/10/2020.
 */

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query(value = "select * from resource r where r.name=?1", nativeQuery = true)
    public List<Resource> findUsersByName(String name);
}
