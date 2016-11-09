package com.titansmasher.taptitansoptimizer.Helpers;

import java.util.HashMap;

/**
 * Created by Danny on 20/10/2016.
 */

public class HashMapConstructor<K, V> {

    private HashMap<K, V> map = new HashMap<K, V>();

    public HashMapConstructor<K, V> add(K key, V value) {
        this.map.put(key, value);
        return this;
    }

    public HashMap<K, V> getMap() {
        return this.map;
    }

    public int size(){
        return map.size();
    }
}
