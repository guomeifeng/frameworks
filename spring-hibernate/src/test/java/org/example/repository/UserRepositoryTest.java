package org.example.repository;

import org.example.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
    void save(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername("enjoy");
        user.setPassword(encoder.encode("123"));
        userRepository.save(user);
    }
}