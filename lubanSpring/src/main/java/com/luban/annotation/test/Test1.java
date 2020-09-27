package com.luban.annotation.test;

import com.luban.annotation.util.AnnotationConfigAplicationContext;

/**
 * @author 小贱
 * @create 2020-09-27 13:09
 */
public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigAplicationContext annotationConfigAplicationContext = new AnnotationConfigAplicationContext();
        annotationConfigAplicationContext.scan("com.luban.annotation.service");
    }
}
