package code_design.twitter;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final int id;
    private final Set<Integer> follow;
    private Tweet head;

    public User(int id) {
        this.id = id;
        follow = new HashSet<>();
        follow.add(id);
        head = null;
    }

    public void follow(int userId) {
        follow.add(userId);
    }

    public void unfollow(int userId) {
        follow.remove(userId);
    }

    public void post(int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.setNext(head);
        head = tweet;
    }

    public int getId() {
        return id;
    }

    public Set<Integer> getFollow() {
        return follow;
    }

    public Tweet getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "User(" +
                "id: " + id +
                ", follow: " + follow +
                ", head: " + head +
                ")";
    }
}
