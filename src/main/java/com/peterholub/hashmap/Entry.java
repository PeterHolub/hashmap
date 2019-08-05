package com.peterholub.hashmap;

/**
 * Class - representation of entry in Hash Map with getters and constructor
 **/
class Entry {
    private final int key;
    private long value;

    Entry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    int getKey() {
        return key;
    }

    long getValue() {
        return value;
    }

}