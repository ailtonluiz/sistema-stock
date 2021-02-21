package com.ailtonluiz.sgs;

import com.ailtonluiz.sgs.model.Status;
import com.ailtonluiz.sgs.model.User;
import com.ailtonluiz.sgs.repository.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SgsApplicationTests {

    @Autowired
    private Users users;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Test
    void createUserTest() {
        User user = new User();

        user.setName("Ailton");
        user.setPassword(passwordEncoder.encode("123"));
        user.setStatus(Status.ACTIVE);

       User ret =  users.save(user);


        Assert.assertTrue(ret.getPassword().equalsIgnoreCase(ret.getPassword()));



    }

}
