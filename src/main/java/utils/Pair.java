package utils;

import java.util.Objects;

public class Pair {
    private int key;
    private int value;

    public Pair(final int key, final int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public Pair key(int key) {
        this.key = key;
        return this;
    }

    public Pair value(int value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " key='" + key + "'" +
            ", value='" + value + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) o;
        return key == pair.key && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

}
