package com.example.springsecurity;

import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
@SpringBootTest
public class ContactNumberValidatorIntegrationTest {
    private LocalValidatorFactoryBean localValidatorFactory;

    @Autowired
    private Validator validator;




    @Test
    public void shouldValidate() {

        final User user = new User();
        user.setPhone("A long name with\t a Tab character");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        Assertions.assertTrue( constraintViolations.size() == 4);
    }
}