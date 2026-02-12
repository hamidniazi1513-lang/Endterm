package com.hamidniazi.endterm_project.patterns;

import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
    // 1. Static variable to hold the single instance (Singleton)
    private static SimpleCache instance;

    // 2. The in-memory storage (Map)
    private Map<String, Object> cacheMap;

    // 3. Private constructor to prevent direct instantiation
    private SimpleCache() {
        cacheMap = new HashMap<>();
        System.out.println("SimpleCache initialized!");
    }

    // 4. Global access point (Thread-safe Singleton)
    public static synchronized SimpleCache getInstance() {
        if (instance == null) {
            instance = new SimpleCache();
        }
        return instance;
    }

    // 5. Methods to manage data
    public void put(String key, Object value) {
        cacheMap.put(key, value);
        System.out.println("Added to Cache: " + key);
    }

    public Object get(String key) {
        if (cacheMap.containsKey(key)) {
            System.out.println("Fetched from Cache: " + key);
            return cacheMap.get(key);
        }
        return null;
    }

    public void clear(String key) {
        cacheMap.remove(key);
        System.out.println("Invalidated Cache Key: " + key);
    }

    public void clearAll() {
        cacheMap.clear();
        System.out.println("Cache Cleared Completely.");
    }
}