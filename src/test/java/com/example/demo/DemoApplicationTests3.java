package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class DemoApplicationTests3 {

    @Test
    void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, res);

        int[] nums2 = {3, 2, 3};
        int target2 = 6;
        int[] res2 = twoSum(nums2, target2);
        assertArrayEquals(new int[]{0, 2}, res2);

        int[] nums3 = {2, 5, 5, 11};
        int target3 = 10;
        int[] res3 = twoSum(nums3, target3);
        assertArrayEquals(new int[]{1, 2}, res3);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = i+1; j < nums.length; j += 1) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

