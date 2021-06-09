package com.gao.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    static public String getId(){
//        System.out.println(UUID.randomUUID().toString());
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void testIdUtils(){
        System.out.println(IdUtils.getId());
    }
}


