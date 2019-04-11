package com.ltym.intentkey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luys
 * @describe
 * @date 2019/2/21
 * @email samluys@foxmail.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicIntentKey {
    String value();
}
