package dsa.utils;

import java.util.Objects;

public class Pair<X, Y> {
    private X left;
    private Y right;

    public Pair(final X left, final Y right) {
        this.left = left;
        this.right = right;
    }

    public X getLeft() {
        return left;
    }

    public X getKey() {
        return left;
    }

    public Y getRight() {
        return right;
    }

    public Y getValue() {
        return right;
    }

    public Pair<X, Y> left(X key) {
        this.left = key;
        return this;
    }

    public Pair<X, Y> right(Y value) {
        this.right = value;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " left='" + left + "'" +
            ", right='" + right + "'" +
            "}";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair)) {
            return false;
        }
        final Pair<X, Y> pair = (Pair<X, Y>) o;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
