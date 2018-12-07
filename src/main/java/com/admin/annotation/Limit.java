package com.admin.annotation;
import java.lang.annotation.*;

/**
 * @author lisheng
 * @version Limit, v0.1 2018/8/30 11:32 限流
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limit {

    String name() default "";

    String key() default "";

    String prefix() default "";

    int period();

    int count();

    LimitType limitType() default LimitType.CUSTOMER;

}