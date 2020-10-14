package org.example.repository;

import org.example.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUsersByName() {
        List<User> userList = userRepository.findUsersByName("enjoy");
        assert(userList!=null && userList.size()>0);
    }

    @Test
    @Rollback
    void save(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user1 = new User();
        user1.setUsername("enjoy3");
        user1.setPassword(encoder.encode("12345"));
        userRepository.save(user1);

    }
}