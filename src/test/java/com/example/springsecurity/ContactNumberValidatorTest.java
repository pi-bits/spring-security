package com.example.springsecurity;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.util.Set;

public class ContactNumberValidatorTest {
//    ContactNumberValidator contactNumberValidator;
Validator validator;
    @Test
    void shouldValidate() {
        User user = new User();
         validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(
                        new ResourceBundleMessageInterpolator(
                                new PlatformResourceBundleLocator("messages")))
                .buildValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<User>> constraintViolations = validateValue(User.class, "phone", "123456", validator);
        constraintViolations.size();
        Annotation annotation = constraintViolations.iterator().next().getConstraintDescriptor().getAnnotation();
        annotation.toString();
    }

    public  <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value,Validator validator,
                                                                Class<?>... groups ) {

        return validator.validateValue(beanType, propertyName, value);
    }

    public  <T> Set<ConstraintViolation<T>> validateObject(T beanType , Validator validator,Class<?>... groups) {
        return validator.validate(beanType,groups);
    }
}