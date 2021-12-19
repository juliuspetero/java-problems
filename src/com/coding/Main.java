package com.coding;


import com.coding.thread.ThreadDemo;

public class Main {

    public static void main(String[] args) {

        System.out.println(new ThreadDemo().hashCode());
        System.out.println(Integer.valueOf(11).hashCode());
        System.out.println("Integer.valueOf(11)".hashCode());
    }
}
