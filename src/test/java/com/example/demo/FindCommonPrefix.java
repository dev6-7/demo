package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindCommonPrefix {

    @Test
    void test() {
        String[] words = {"dog", "racecar", "car"};
        String[] words2 = {"flower", "flow", "flight"};
        String[] words3 = {"a"};
        String[] words4 = {"", "b"};
        String[] words5 = {"aaa", "aa", "aaa"};
        String[] words6 = {"c", "acc", "ccc"};
        String[] words7 = {"abca", "aba", "aaab"};
        String[] words8 = {"a", "a", "b"};
        String[] words9 = {"baab", "bacb", "b", "cbc"};

        Assertions.assertEquals("", buildString(words));
        Assertions.assertEquals("fl", buildString(words2));
        Assertions.assertEquals("a", buildString(words3));
        Assertions.assertEquals("", buildString(words4));
        Assertions.assertEquals("aa", buildString(words5), """
                "aaa", "aa", "aaa""");
        Assertions.assertEquals("", buildString(words6), """
                "c", "acc", "ccc""");
        Assertions.assertEquals("a", buildString(words7), """
                "abca", "aba", "aaab""");
        Assertions.assertEquals("", buildString(words8), """
                "a","a","b""");
        Assertions.assertEquals("", buildString(words9), """
                "baab","bacb","b","cbc""");
    }

    public String buildString(String[] words) {
        if (words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }

        char[] firstWord = words[0].toCharArray();
        if (firstWord.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int maxResSize = firstWord.length;

        for (int wordIndex = 1; wordIndex < words.length; wordIndex++) {
            char[] wordChars = words[wordIndex].toCharArray();

            char[] compareWithIt = (result.length() == 0) ? firstWord : result.toString().toCharArray();

            if (result.length() > 0 && maxResSize > result.length()) {
                maxResSize = result.length();
            }
            if (maxResSize > wordChars.length) {
                maxResSize = wordChars.length;
            }

            boolean match = false;
            StringBuilder matchedString = new StringBuilder("");
            for (int j = 0; j < (maxResSize); j++) {
                char wordChar = wordChars[j];
                char compareWithThisChar = compareWithIt[j];

                if (wordChar != compareWithThisChar) {
                    break;
                } else {
                    match = true;
                    matchedString.append(wordChar);
                }
            }
            //постпроцесс
            // если у нас в текущем слове был матч, то мы должны проверить, а не короче ли стал матч и если да, то заюзать его.
            if (match) {
                if (result.isEmpty() || (!result.isEmpty() && !matchedString.isEmpty())) {
                    if (result.isEmpty() || matchedString.length() < result.length()) {
                        result = matchedString;
                    }
                }
            } else {
                return "";
            }
        }

        return result.toString();
    }
}