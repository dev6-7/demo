package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestDemoDemo {

    // Программист решил пойти в театр. Но он хочет сесть
// как можно дальше от других людей, чтобы не заразиться covid.
// Поэтому он хочет написать функцию, которая найдет
// максимальное расстояние, на которое можно сесть от других зрителей в одном ряду.
// Дан массив из 0 и 1 описывающий посадку зрителей в ряду.
// 0 - место свободно, 1 - место занято другим зрителем.
// Вывести максимальное расстояние, на котором можно сесть от других зрителей.
// Гарантируется, что есть 0 и 1.

    // Пример: [1,0,0,0,1] ->  2
    @Test
    void test() {
        List<Integer> list = List.of(0, 0, 0, 0, 1, 0, 0, 0, 1);
        int index = 0;
        int range = 0;
        int lastRange = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                if (range == 0) index = i;
                range++;
            }

            if (list.get(i) == 1 || (list.size() - 1 == i)) {
                if (index != 0 && list.get(index - 1) == 1 && (list.size() - 1 == i) && list.get(i) != 0) {
                    range = (range + 1) / 2;
                }

                if (range > lastRange) {
                    lastRange = range;
                }

                range = 0;
            }
        }

        System.out.println(lastRange);
    }


    // Даны два отсортированных массива.
    // Вывести все элементы первого массива, которые не встречаются во втором.
    // Пример
    // filter([1, 2, 3], [2, 3, 4]) => [1]
    @Test
    void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean found = false;
            for (int j = 0; j < list2.size(); j++) {
                if (list.get(i) == list2.get(j)) {
                    found = true;
                }
            }
            if (!found) {
                resultList.add(list.get(i));
            }
        }

        System.out.println(resultList);
    }
}

