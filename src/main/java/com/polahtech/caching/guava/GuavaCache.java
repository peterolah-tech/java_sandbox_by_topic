package com.polahtech.caching.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCache {

    private final LoadingCache<String, String> cache;

    public GuavaCache() {
        this.cache = CacheBuilder.newBuilder().build(getCacheLoader());
    }

    private static CacheLoader<String, String> getCacheLoader() {
        return new CacheLoader<>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
    }

    public void cacheData(String data) {
        cache.getUnchecked(data);
    }

}
