package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootTest
class DemoApplicationTests2 {

    @Test
    void test() {
        System.out.println(getFirstUnique("abcabcd"));
    }

    //Найти в строке первую уникальную букву
    //
    //Например:
    //"abc" => a
    //"abca" => b
    //"abcab" => c
    //"abcabcd" => d

    public Character getFirstUnique(String st) {

        char[] chars = st.toCharArray();

        Map<Character, Integer> charMap = new LinkedHashMap();

        for(int i = 0; i<chars.length; i++) {
            char curElement = chars[i];
            if (charMap.get(curElement) == null) {
                charMap.put(curElement, 0);
            } else {
                int resCount = charMap.get(curElement) + 1;
                charMap.put(curElement, resCount);
            }
        }

        for (Character c : charMap.keySet()) {
            if (charMap.get(c) == 0) {
                return c;
            }
        }
        return '0';
    }
}

