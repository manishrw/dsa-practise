package code_design.twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

class Twitter {
    private static final int K = 10;
    private static final boolean DEBUG = false;

    private final Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
        if (DEBUG) System.out.println("Post tweet:\n" + this);
    }

    /** Retrieve the K most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        if (!userMap.containsKey(userId)) return tweets;
        Comparator<Tweet> tweetComparator = Comparator.comparing(Tweet::getTime).reversed();
        Queue<Tweet> heap = new PriorityQueue<>(tweetComparator);
        userMap.get(userId)
                .getFollow()
                .stream()
                .filter(userMap::containsKey)
                .map(userMap::get)
                .map(User::getHead)
                .forEach(heap::add);
        while (!heap.isEmpty() && tweets.size() < K) {
            var t = heap.poll();
            tweets.add(t.getId());
            if (t.getNext() != null) {
                heap.add(t.getNext());
            }
        }
        return tweets;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
        if (DEBUG) System.out.println("Follow:\n" + this);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
        if (DEBUG) System.out.println( "Unfollow:\n" + this);
    }

    @Override
    public String toString() {
        return "Feed: {" + userMap + "}";
    }
}


