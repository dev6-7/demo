package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class HashCodeTest {

    @Test
    public void testFailHashCode() {
        MyTestClass element = new MyTestClass();
        MyTestClass element2 = new MyTestClass();
        MyTestClass element3 = new MyTestClass();
        System.out.println(element.hashCode());
        System.out.println(element2.hashCode());
        System.out.println(element3.hashCode());
        HashMap<MyTestClass, String> map = new HashMap<>();
        map.put(element, "123");
        map.put(element2, "321");
        map.put(element3, "543");
        int res = 1 & (16 - 1);
        System.out.println(res);
        System.out.println(1 & 12);

        map.put(element, "12333");
        System.out.println(map);


        Set<String> set = new HashSet<>();
        set.add("asd");
        set.add("a3");
        set.add("as3");
        Set<String> set2 = new HashSet<>();
        set2.add("asd");
        set.removeAll(set2);
        System.out.println(set);
    }
}

class MyTestClass {

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}