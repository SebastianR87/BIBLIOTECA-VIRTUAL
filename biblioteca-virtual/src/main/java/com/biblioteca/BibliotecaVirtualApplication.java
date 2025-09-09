package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.biblioteca")
public class BibliotecaVirtualApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaVirtualApplication.class, args);
    }
}
