package com.testease.utils;

import java.util.UUID;

public class DataGenerator {

    public static String randomEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0,5) + "@mail.com";
    }

    public static String randomName() {
        return "User_" + UUID.randomUUID().toString().substring(0,4);
    }
}
