package com.peterholub.hashmap;

import com.peterholub.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class HashMapTest {

    private Map hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void put() throws NoSuchFieldException {
        int key = 345;
        long value = 786767676;

        hashMap.put(key, value);



    }

    @Test
    public void get() {
    }

    @Test
    public void size() {
    }
}