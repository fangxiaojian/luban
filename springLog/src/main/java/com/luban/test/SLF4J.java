package com.luban.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 小贱
 * @create 2020-10-13 23:32
 */
public class SLF4J {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("slf4j");
        logger.info("slf4j");

    }
}
