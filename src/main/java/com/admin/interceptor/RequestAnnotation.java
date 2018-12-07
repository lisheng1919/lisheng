package com.admin.interceptor;

import java.lang.annotation.*;

/**
 * @author lisheng
 * @version RequestAnnotation, v0.1 2018/11/29 10:00
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestAnnotation {
    String key();
    String value();
}
