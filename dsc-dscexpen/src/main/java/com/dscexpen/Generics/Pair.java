package com.dscexpen.Generics;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-05-24  12:39  星期四
 * version 1.0
 */
public class Pair<K, V> {

    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}
