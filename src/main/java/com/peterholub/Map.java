package com.peterholub;
/**
 *Interface to declare main methods for Map data structure
 **/
public interface Map {

    /**
     * Method for put key and value into the map
     *
     * @param key   key value
     * @param value double value to store
     **/
    void put(int key, long value);

    /**
     * Method for get value from map by key
     *
     * @param key key to get value
     **/
    long get(int key);

    /**
     * Method to get map size
     **/
    int size();
}
