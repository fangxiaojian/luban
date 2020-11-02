package com.luban.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JCL 是借助 Log4j 进行 打印 日志的
 * 当系统没有 log4j 时， 会借助 JUL 进行 打印 日志
 *
 * @author 小贱
 * @create 2020-10-13 21:15
 */
public class JCL {
    public static void main(String[] args) {
        Log log = LogFactory.getLog("jcl");
        log.info("jcl");
    }
}
