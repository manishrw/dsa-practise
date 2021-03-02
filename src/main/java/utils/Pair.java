package utils;

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

    public Y getRight() {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<X, Y> pair = (Pair<X, Y>) o;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
