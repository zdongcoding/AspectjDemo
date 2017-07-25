package com.github.zdongcoding.aspectjdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zoudong on 2017/7/25.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.LOCAL_VARIABLE,ElementType.TYPE})
public @interface Runtime {
    String[]value() ;
}
