package com.lzx2005.cache;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

public class LocalExpireCacheTest {

    @Test
    public void test() throws InterruptedException {
        LocalExpireCache<String, String> localExpireCache = new LocalExpireCache<>();
        localExpireCache.put("a", "1");
        localExpireCache.put("b", "2", new Date());
        localExpireCache.put("c", "3", LocalDateTime.now().plusDays(1));
        localExpireCache.put("d", "4", new Date(), ZoneId.systemDefault());

        Thread.sleep(100);

        String c = localExpireCache.get("c");
        assertEquals("3", c);
        String d = localExpireCache.get("d");
        assertNull(d);
    }
}