package com.nextbook.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCifrado {
    public static void main(String[] args) {
        String cifrada = new BCryptPasswordEncoder().encode("admin123");
        System.out.println(cifrada);
    }
}
