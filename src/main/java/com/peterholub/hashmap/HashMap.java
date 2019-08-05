package com.peterholub.hashmap;

import com.peterholub.Map;

import java.util.Arrays;

/**
 * Class Hash Map implementation of Map interface
 **/
public class HashMap implements Map {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final byte INITIAL_CAPACITY = 4;
    private static final byte INCREASE_FACTOR = 2;
    private static final byte FIRST_INDEX = 0;
    private static final byte PRIME_NUMBER = 3;
    private int pairsWritten;
    private int mapSize = INITIAL_CAPACITY;
    private Entry[] map = new Entry[INITIAL_CAPACITY];

    /**
     * Method for put key and value into the map
     *
     * @param key   key value
     * @param value double value to store
     **/
    @Override
    public void put(int key, long value) {
        Entry entry = new Entry(key, value);
        //Always check if first index available  to write Entry
        if (map[FIRST_INDEX] == null) {
            map[FIRST_INDEX] = entry;
            pairsWritten++;
            return;
        }
        int probe = 0;
        int hashKey = (firstHash(key) + probe * secondHash(key)) % mapSize;
        //Looping till first free index will be found
        while (map[hashKey] != null && probe <= mapSize) {
            probe++;
            hashKey = (firstHash(key) + probe * secondHash(key)) % mapSize;
        }
        map[hashKey] = entry;

        //Increment counter after Entry written
        pairsWritten++;

        //Invoke method for checking load factor and resize map if load factor more than 0.75
        resizeMap();
    }

    /**
     * Method for get value from map by key
     *
     * @param key key to get value
     **/
    @Override
    public long get(int key) {
        int probe = 0;
        int hashKey = (firstHash(key) + probe * secondHash(key)) % mapSize;
        //Looping till index will be not null and key value in Entry will be the same as passed parameter, or iteration thru all map will finished
        for (int i = 0; i <= mapSize; i++) {
            Entry entry = map[hashKey];
            if (entry != null) {
                if (entry.getKey() == key) {
                    return map[hashKey].getValue();
                }
            }
            probe++;
            hashKey = (firstHash(key) + probe * secondHash(key)) % mapSize;
        }
        //Return 0 if there is no key in map
        return 0;
    }

    /**
     * Method to get map size
     **/
    @Override
    public int size() {
        return mapSize;
    }

    /**
     * First hashcode generation for double hashing algorithm by formula Hash1 = key % M where M is Map size.
     *
     * @param key key value
     **/

    private int firstHash(int key) {
        return key % mapSize;
    }

    /**
     * Second hashcode generation for double hashing algorithm by formula Hash1 = P - ( key % P ) where P is a prime number that is smaller than the size of the map.
     *
     * @param key key value
     **/
    private int secondHash(int key) {
        return PRIME_NUMBER - (key % PRIME_NUMBER);
    }

    /**
     * Method for resize of Hash Map length. When Load factor ratio (pairsWritten /mapSize) reaches 0.75 then size of map increase
     **/
    private void resizeMap() {
        if (pairsWritten / mapSize > DEFAULT_LOAD_FACTOR) {
            map = Arrays.copyOf(map, mapSize * INCREASE_FACTOR);
            mapSize = mapSize * INCREASE_FACTOR;
        }
    }
}


