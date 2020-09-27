package com.luban.annotation.ano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 小贱
 * @create 2020-09-27 13:06
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Luban {
    String value();
}
