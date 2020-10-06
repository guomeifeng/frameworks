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
            "    ur.id id,\n" +
            "    ur.create_time createTime,\n" +
            "    ur.`name` `name`,\n" +
            "    ur.url url,\n" +
            "    ur.description description,\n" +
            "    ur.category_id categoryId\n" +
            "    FROM\n" +
            "    ums_admin_role_relation ar\n" +
            "    LEFT JOIN ums_role r ON ar.role_id = r.id\n" +
            "    LEFT JOIN ums_role_resource_relation rrr ON r.id = rrr.role_id\n" +
            "    LEFT JOIN ums_resource ur ON ur.id = rrr.resource_id\n" +
            "            WHERE\n" +
            "    ar.admin_id = #{adminId}\n" +
            "    AND ur.id IS NOT NULL\n" +
            "    GROUP BY\n" +
            "    ur.id" , nativeQuery = true)

    public List<Resource> getResourceList(String adminId);
}
