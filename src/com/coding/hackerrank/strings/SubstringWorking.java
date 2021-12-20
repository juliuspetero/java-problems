package com.coding.hackerrank.strings;

import org.junit.Test;

import java.util.Objects;

public class SubstringWorking {

    @Test
    public void testing() {
        String str1 = "hey I am learning substring method implementation";
        String str2 = str1.substring(6, 8);
        System.out.println(str2);
    }

    public static void testing2() {
        String z = rt();
        String str1 = "hey I am learning substring method implementation";
        String str2 = str1.substring(6, 8);
        System.out.println(str2);

    }

    public static String rt() {
        String x = Objects.toString(System.currentTimeMillis());
        return x;
    }
}
