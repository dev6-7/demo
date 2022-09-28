package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void testTwitter() {
        Twitter twitter = new Twitter();
        for (int i = 0; i < 10; i++) {
            twitter.postTweet(1, 1);
        }
    }

}

class Twitter {

    Map<Integer, List<Integer>> tweets = new HashMap();
    Map<Integer, List<Integer>> follows = new HashMap();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (tweets.get(userId) == null) {
            List<Integer> tLists = new ArrayList<>();
            tLists.add(tweetId);
            tweets.putIfAbsent(userId, tLists);
        } else {
            tweets.get(userId).add(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> friendIds = follows.get(userId).stream().sorted().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) return 1;
                if (o2 < o1) return -1;
                return 0;
            }
        }).toList();

        return null;
    }

    public void follow(int followerId, int followeeId) {
        if (tweets.get(followerId) == null) {
            List<Integer> tLists = new ArrayList<>();
            tLists.add(followeeId);
            tweets.putIfAbsent(followerId, tLists);
        } else {
            tweets.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (tweets.get(followerId) != null && !tweets.get(followerId).isEmpty()) {
            tweets.get(followerId).remove(followeeId);
        }
    }
}
