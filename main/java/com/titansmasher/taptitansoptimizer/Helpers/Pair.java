package com.titansmasher.taptitansoptimizer.Helpers;

/**
 * Created by Danny on 20/10/2016.
 */

public class Pair<A, B> {
    A first = null;
    B second = null;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

}