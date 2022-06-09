package util;

import java.util.Objects;

// created own pair class as one does not exist in the standard java library
public class Pair {

    private final Integer x;
    private final Integer y;

    public Pair(Integer x, Integer y) {
    this.x = x;
    this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        String val = x + " " + y;
        return val;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return pair.x == x &&
                pair.y == y;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(x, y);
    }

}
