package code_design.twitter;

import java.util.concurrent.atomic.AtomicLong;

public class Tweet {
    private final int id;
    private final long time;
    private Tweet next;
    private static final AtomicLong timeStamp = new AtomicLong();

    public Tweet(int id) {
        this.id = id;
        this.time = timeStamp.incrementAndGet();
        next = null;
    }

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public Tweet getNext() {
        return next;
    }

    public void setNext(Tweet next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Tweet(" + id +", " + time + ") -> " + next;
    }
}
