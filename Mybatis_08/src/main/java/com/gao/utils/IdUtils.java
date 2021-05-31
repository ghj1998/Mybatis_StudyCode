package com.gao.utils;

import java.util.UUID;

public class IdUtils {
    static public String getId(){
        return UUID.randomUUID().toString().replaceAll(".","");
    }
}
