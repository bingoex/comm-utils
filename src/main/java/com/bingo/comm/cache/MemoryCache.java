package com.bingo.comm.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MemoryCache<T> implements CacheManager<T> {
    /**
     * 超时时间，默认不超时
     */
    private long expiredTime;
    /**
     * 容量大小
     */
    private long size;

    private Cache<Object, Object> cache = null;

    public void init() {
        // 初始化Guava的LocalCache
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(size).initialCapacity((int) (size / 2));
        if (expiredTime > 0) {
            builder.expireAfterWrite(expiredTime, TimeUnit.SECONDS);
        }

        cache = builder.build();
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Cache<Object, Object> getCache() {
        return cache;
    }

    public T get(String key) {
        Object v = cache.getIfPresent(key);
        if (v == null) {
            return null;
        }

        return (T)v;
    }

    public Map<String, T> mGet(List<String> keys) {
        Map<String, T> map = new HashMap<>();
        for (String key : keys) {
            map.put(key, get(key));
        }

        return map;
    }

    public boolean invalid(String tairKey) {
        cache.invalidate(tairKey);
        return true;
    }

    public boolean delete(String key) {
        return invalid(key);
    }

    public boolean put(String key, Object obj) {
        if (obj == null) {
            //put null 走delete接口
            return false;
        }

        cache.put(key, obj);
        return true;
    }

    public static void main(String[] args) {
        MemoryCache<String> memoryCache = new MemoryCache<>();
        memoryCache.setExpiredTime(3000);
        memoryCache.setSize(10000);
        memoryCache.init();

        memoryCache.put("key1", "hehe");
        String value = memoryCache.get("key1");
        System.out.println(value);
    }
}
