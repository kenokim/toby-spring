package com.example.tobyspringtv1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class TobySpringTv1Application {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext c
                     = SpringApplication.run(TobySpringTv1Application.class, args)) {

        }
    }

    /*public static void main(String[] args) {
        ConfigurableApplicationContext c = SpringApplication.run(TobySpringTv1Application.class, "a", "b");
        c.close();
    }*/

    /*@Bean
    public CommandLineRunner run() {
        // 팩토리 메소드 + 익명 클래스
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("run() ...");
            }
        };
    }*/

    /*@Bean
    public ApplicationRunner run() {
        return new ApplicationRunner() {

            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("run() ...");
            }
        };
    }*/

    @Bean
    public ApplicationRunner run() {
        /*return
                (ApplicationArguments args) -> {
                    System.out.println("run() ...");
                };*/
        return (args) -> System.out.println("run() ...");
    }

    @RestController

    // HTTP Request: request line, header, body
    // HTTP Response: status code, header, body

    public static class MyController {
        @RequestMapping("/hello")
        public String hello() {
            return "hello";
        }
    }

    // Mono = 비동기 데이터 스르림

    @RequestMapping("/hello2")
    public Mono<String> hello() {
        return Mono.just("Hello Reactive")
                .map(s -> s.toUpperCase())
                .publishOn(Schedulers.newSingle("publishOn"))
                .log();
    }

    @RequestMapping("/hello3")
    public CompletableFuture<String> hello3() {
        // Spring 4 style
        // ForkJoinPool.commonPool();
        return CompletableFuture
                .supplyAsync(() -> "Hello world")
                .thenApply(s -> s.toUpperCase());
    }

}
