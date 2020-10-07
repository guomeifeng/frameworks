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

    @Query(value = "SELECT\n" +
            "    ur.id,\n" +
            "    ur.date_created,\n" +
            "    ur.url_name,\n" +
            "    ur.url,\n" +
            "    ur.description,\n" +
            "    ur.category_id\n" +
            "    FROM\n" +
            "    fm_user_role_relation ar\n" +
            "    LEFT JOIN role r ON ar.role_id = r.id\n" +
            "    LEFT JOIN fm_role_resource_relation rrr ON r.id = rrr.role_id\n" +
            "    LEFT JOIN resource ur ON ur.id = rrr.resource_id\n" +
            "            WHERE\n" +
            "    ar.user_id = ?1\n" +
            "    AND ur.id IS NOT NULL\n" +
            "    GROUP BY\n" +
            "    ur.id" , nativeQuery = true)

    public List<Resource> getResourceListByUserId(Long userId);
}
