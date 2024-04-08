package com.atguigu.schedule.test;

import com.atguigu.schedule.util.MD5Util;
import org.junit.Test;

public class TestMD5Util {
    @Test
    public void Testencrypt(){
        System.out.println(MD5Util.encrypt("1235"));
    }
}
