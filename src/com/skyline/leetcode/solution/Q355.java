package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Design Twitter
 * https://leetcode.com/problems/design-twitter/
 * Created by chenliang on 2017/1/29.
 */
public class Q355 {
    public class Twitter {

        Map<Integer, Set<Integer>> followMap = new HashMap<>();

        Map<Integer, ArrayList<Tweet>> postedTweetMap = new HashMap<>();

        int time = 0;

        public class Tweet {
            int time;
            int id;
            int userId;

            public Tweet(int time, int id, int userId) {
                this.time = time;
                this.id = id;
                this.userId = userId;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        public void initFollowMap(int userId) {
            if (!followMap.containsKey(userId)) {
                followMap.put(userId, new HashSet<>());
            }
        }

        public void initTweetMap(int userId) {
            if (!postedTweetMap.containsKey(userId)) {
                postedTweetMap.put(userId, new ArrayList<>());
            }
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            this.follow(userId, userId);
            postedTweetMap.get(userId).add(new Tweet(time++, tweetId, userId));
        }

        private Comparator<Tweet> comparator = new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time - o1.time;
            }
        };

        PriorityQueue<Tweet> queue = new PriorityQueue<>(comparator);

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            this.initFollowMap(userId);
            Set<Integer> followees = followMap.get(userId);
            if (followees.isEmpty()) {
                return new ArrayList<>();
            }
            queue.clear();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int followee : followees) {
                List<Tweet> tweets = postedTweetMap.get(followee);
                if (tweets.size() > 0) {
                    queue.add(tweets.get(tweets.size() - 1));
                }
                indexMap.put(followee, tweets.size() - 1);
            }
            while (!queue.isEmpty() && list.size() < 10) {
                Tweet tweet = queue.poll();
                list.add(tweet.id);
                int index = indexMap.get(tweet.userId);
                if (index > 0) {
                    index--;
                    indexMap.put(tweet.userId, index);
                    queue.add(postedTweetMap.get(tweet.userId).get(index));
                }
            }
            return list;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            this.initFollowMap(followerId);
            this.initTweetMap(followerId);
            this.initTweetMap(followeeId);
            this.followMap.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                this.initFollowMap(followerId);
                this.followMap.get(followerId).remove(followeeId);
            }
        }
    }
}
