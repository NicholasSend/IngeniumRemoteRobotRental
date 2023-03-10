package com.ingenium.double3rental;

import com.ingenium.double3rental.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Sysc4907ProjectApplicationTests {

    @Autowired
    HomepageController homepageController;

    @Autowired
    LoginController loginController;

    @Autowired
    SignupController signupController;

    @Test
    void contextLoads() {
        assertThat(homepageController).isNotNull();
        assertThat(loginController).isNotNull();
        assertThat(signupController).isNotNull();
    }

}
