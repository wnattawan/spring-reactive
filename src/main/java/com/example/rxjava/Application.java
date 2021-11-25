package com.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;

public class Application {
    public static void main(String... args) {
        Flowable.fromArray(args).subscribe(s -> System.out.println("Hello " + s + "!"));
    }
}