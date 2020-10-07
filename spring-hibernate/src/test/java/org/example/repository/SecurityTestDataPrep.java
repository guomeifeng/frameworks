package org.example.repository;

import org.example.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;



/*
 * Created by kelly on 6/10/2020.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTestDataPrep {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleResourceRepository roleResourceRepository;

    @Test
    void save(){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword(encoder.encode("123"));
//        userRepository.save(user);
//
//        Resource resource = new Resource();
//        resource.setName("list all product");
//        resource.setCategoryId(1l);
//        resource.setUrl("/product/list");
//        resourceRepository.save(resource);
//
//        FmRole fmRole = new FmRole();
//        fmRole.setName("inventory management");
//        fmRole.setDescription("desciption of");
//        roleRepository.save(fmRole);

//        FmRoleResourceRelation fmRoleResourceRelation = new FmRoleResourceRelation();
//        fmRoleResourceRelation.setResourceId(1l);
//        fmRoleResourceRelation.setRoleId(1l);
//        roleResourceRepository.save(fmRoleResourceRelation);
//
//        FmAdminRoleRelation fmAdminRoleRelation = new FmAdminRoleRelation();
//        fmAdminRoleRelation.setUserId(2l);
//        fmAdminRoleRelation.setRoleId(1l);
//        userRoleRepository.save(fmAdminRoleRelation);

    }
}
