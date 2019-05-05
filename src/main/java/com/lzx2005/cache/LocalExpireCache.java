package com.lzx2005.cache;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class LocalExpireCache<K, V> {

    private ConcurrentHashMap<K, ExpireObject> data;

    public LocalExpireCache() {
        this.data = new ConcurrentHashMap<K, ExpireObject>();
    }

    public void put(K key, V value) {
        this.put(key, value, null, null);
    }

    public void put(K key, V value, Date expireAt) {
        this.put(key, value, expireAt, null);
    }

    public void put(K key, V value, Date expireAt, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = ZoneId.systemDefault();
        }
        LocalDateTime localDateTime = null;
        if (expireAt != null) {
            localDateTime = LocalDateTime.ofInstant(expireAt.toInstant(), zoneId);
        }
        this.put(key, value, localDateTime);
    }

    public void put(K key, V value, LocalDateTime expireAt) {
        if (key == null) {
            throw new RuntimeException("key can not be Null");
        }
        if (value == null) {
            throw new RuntimeException("value can not be Null");
        }
        ExpireObject expireObject = new ExpireObject();
        expireObject.setExpiredTime(expireAt);
        expireObject.setObject(value);
        this.data.put(key, expireObject);
    }

    public V get(K key) {
        ExpireObject expireObject = this.data.get(key);
        if (expireObject != null
                && expireObject.getExpiredTime() != null
                && !expireObject.isExpired()) {
            return expireObject.getObject();
        }
        this.data.remove(key);
        return null;
    }

    private class ExpireObject {
        private LocalDateTime expiredTime;
        private V object;

        private boolean isExpired() {
            if (null == expiredTime) {
                return false;
            }
            return LocalDateTime.now().isAfter(expiredTime);
        }

        private LocalDateTime getExpiredTime() {
            return expiredTime;
        }

        private void setExpiredTime(LocalDateTime expiredTime) {
            this.expiredTime = expiredTime;
        }

        private V getObject() {
            return object;
        }

        private void setObject(V object) {
            this.object = object;
        }
    }
}
