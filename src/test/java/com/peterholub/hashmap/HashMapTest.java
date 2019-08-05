package com.peterholub.hashmap;

import com.peterholub.Map;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class HashMapTest {
    private static final byte INITIAL_CAPACITY = 4;
    private static final String FIELD_NAME = "map";
    private static final byte INCREASE_FACTOR = 2;
    private Map hashMap;

    @Before
    public void setUp() {
        hashMap = new HashMap();
    }


    @Test
    public void put() throws NoSuchFieldException, IllegalAccessException {
        int expectedKey = 345;
        long expectedValue = 786767676;
        int actualKey = 0;
        long actualValue = 0;


        hashMap.put(expectedKey, expectedValue);

        //Reflection to get array field from hash map and make sure that Entry object was written
        Field map = hashMap.getClass().getDeclaredField(FIELD_NAME);
        map.setAccessible(true);

        Entry[] mapArray = (Entry[]) map.get(hashMap);
        map.setAccessible(false);

        for (Entry entry : mapArray) {
            if (entry != null) {

                actualKey = entry.getKey();
                actualValue = entry.getValue();
            }

        }


        assertEquals(expectedKey, actualKey);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void get() throws NoSuchFieldException, IllegalAccessException {
        int key = 9824;
        long expectedValue = 865342377;


        Entry entry = new Entry(key, expectedValue);

        Entry[] mapArray = new Entry[INITIAL_CAPACITY];

        mapArray[2] = entry;

        //Reflection to get array field from hash map and write Entry to that field
        Field map = hashMap.getClass().getDeclaredField(FIELD_NAME);

        map.setAccessible(true);

        map.set(hashMap, mapArray);

        map.setAccessible(false);

        //Perform test of get method
        long actualValue = hashMap.get(key);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void size() {
        //First test to make sure that method size return initial capacity

        int actualSize = hashMap.size();

        assertEquals(INITIAL_CAPACITY, actualSize);

        //Second test for making sure that map will resize after reaching load factor

        for (int i = 0; i < 4; i++) {

            hashMap.put(i, i);
        }
        int actualSizeAfterLoadFactor = hashMap.size();

        assertEquals(INITIAL_CAPACITY * INCREASE_FACTOR, actualSizeAfterLoadFactor);

    }
}