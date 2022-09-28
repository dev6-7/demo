package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests5 {

    @Test
    void test() {
        ThreadImpl tr = new ThreadImpl();
        tr.run();
        ThreadImpl tr2 = new ThreadImpl();
        tr2.run();
        ThreadImpl tr3 = new ThreadImpl();
        tr3.run();

        List<String> list = new LinkedList<>();
        list.add("asd");
        list.get(3);
    }

    @Test
    void test2() {
        int[] mass = new int[100];
        for (int i = 0; i < 100; i++) {
            mass[i] = i;
        }
        Set<Integer> set = Arrays.stream(mass).boxed().collect(Collectors.toSet());
        //System.out.println(set);

        int res = 0;
        int[] mass2 = {1, 2, 3, 5, 1, 3, 44};
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < mass2.length; i++) {
            if (set2.contains(mass2[i])) {
                res = mass2[i];
                break;
            } else {
                set2.add(mass2[i]);
            }
        }
        System.out.println(set2);
        System.out.println(res);
    }
}

class ThreadImpl implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ThreadImpl() {
        System.out.println("New ThreadImpl");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("hello there im here:" + id + ":" + i);
            Thread.yield();
        }
        System.out.println("end");
    }
}