package com.titansmasher.taptitansoptimizer.Helpers;

import java.util.ArrayList;

/**
 * Created by Danny on 21/10/2016.
 */

public class ArrayListConstructor<V> {

    private ArrayList<V> list = new ArrayList<V>();

    public ArrayListConstructor<V> add(V value) {
        this.list.add(value);
        return this;
    }

    public ArrayList<V> getList() {
        return this.list;
    }

    public int size(){
        return list.size();
    }
}