package com.nextbook.config;

public class BCryptTest {
    public static void main(String[] args) {
        String hash = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("admin123");
        System.out.println(hash);
    }
}