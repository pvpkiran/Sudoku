package com.app.utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdGenerator {

    private static Random random = new Random();
    private static AtomicLong uniqueLongId = new AtomicLong(System.currentTimeMillis());

    public static long getUniqueLongId(){

        long id = uniqueLongId.incrementAndGet();
        long uniqueID = Math.abs(random.nextLong()) + id;
        return uniqueID;
    }
}
