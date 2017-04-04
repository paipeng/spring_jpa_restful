package com.paipeng.spring_jpa_restful.annotation;

import java.lang.annotation.*;

/**
 * Created by paipeng on 25/03/2017.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface UserAnnotation {
    public enum Role {
        ADMIN,
        USER
    }
    Role[] roles() default {};
}
