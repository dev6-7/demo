package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests4 {

    @Test
    void test() {
        int req = romanToInt("LVIII");
        Assertions.assertEquals(58, req);
        Assertions.assertTrue(req < 4000);

        int req2 = romanToInt("MCMXCIV");
        Assertions.assertEquals(1994, req2);
        Assertions.assertTrue(req2 < 4000);

        int req3 = romanToInt("III");
        Assertions.assertEquals(3, req3);
        Assertions.assertTrue(req3 < 4000);
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] reversedNumber = new StringBuilder(s)
                .reverse()
                .toString()
                .toCharArray();

        Map<Character, Integer> letters = new HashMap<>();
        letters.put('I', 1);
        letters.put('V', 5);
        letters.put('X', 10);
        letters.put('L', 50);
        letters.put('C', 100);
        letters.put('D', 500);
        letters.put('M', 1000);

        for (int i = 0; i < reversedNumber.length; i++) {
            if ((i + 1) < reversedNumber.length) {
                if ((reversedNumber[i] == 'V' || reversedNumber[i] == 'X') && reversedNumber[i + 1] == 'I') {
                    int substraction = letters.get(reversedNumber[i]) - letters.get(reversedNumber[i + 1]);
                    result += substraction;
                    i++;
                    continue;
                }
                if ((reversedNumber[i] == 'L' || reversedNumber[i] == 'C') && reversedNumber[i + 1] == 'X') {
                    int substraction = letters.get(reversedNumber[i]) - letters.get(reversedNumber[i + 1]);
                    result += substraction;
                    i++;
                    continue;
                }
                if ((reversedNumber[i] == 'D' || reversedNumber[i] == 'M') && reversedNumber[i + 1] == 'C') {
                    int substraction = letters.get(reversedNumber[i]) - letters.get(reversedNumber[i + 1]);
                    result += substraction;
                    i++;
                    continue;
                }
            }

            result += letters.get(reversedNumber[i]);
        }

        return result;
    }
}