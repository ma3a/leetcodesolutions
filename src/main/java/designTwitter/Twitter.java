package designTwitter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem desc: https://leetcode.com/problems/design-twitter/#/description
 *
 * Submission details: https://leetcode.com/submissions/detail/98456904/
 */
public class Twitter {

    private static final int MAX_FEED_LENGTH = 10;
    private Map<Integer, List<Tweet>> tweetByUser = new HashMap<>();
    private Map<Integer, List<Integer>> followUserMap = new HashMap<>();

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (tweetByUser.get(userId) == null) {
            tweetByUser.put(userId, new ArrayList<>());
            follow(userId, userId);
        }
        tweetByUser.get(userId).add(new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!followUserMap.containsKey(userId)) {
            return Collections.emptyList();
        }
        List<Tweet> feed = new ArrayList<>();
        for (Integer followeeId : followUserMap.get(userId)) {
            if (tweetByUser.get(followeeId) == null) {
                continue;
            }
            List<Tweet> tweets = tweetByUser.get(followeeId);
            feed.addAll(tweets);
        }
        Collections.sort(feed);
        return feed.subList(0, Math.min(MAX_FEED_LENGTH, feed.size())).stream().map(t -> t.tweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        followUserMap.computeIfAbsent(followeeId, (follow) -> new ArrayList<>());

        List<Integer> followees = followUserMap.get(followerId);
        if (followees.indexOf(followeeId) < 0) {
            followees.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followUserMap.containsKey(followerId)) {
            return;
        }
        List<Integer> followers = followUserMap.get(followerId);
        int idx = followers.indexOf(followeeId);
        if (!(idx < 0)) {
            followers.remove(idx);
        }
    }

    static class Tweet implements Comparable {
        int tweetId;

        long createDate;

        private Tweet(int tweetId) {
            this.tweetId = tweetId;
            createDate = System.nanoTime();
        }

        @Override
        public int compareTo(Object o) {
            Tweet another = (Tweet) o;
            return (int) (another.createDate - this.createDate);
        }
    }

}
