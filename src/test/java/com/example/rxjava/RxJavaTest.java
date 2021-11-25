package com.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class RxJavaTest {
    @Test
    public void testCreateObservables() {
        // create Observable with from()
        var observableOfString = Observable.fromArray("a", "b", "c");
        var observableOfInteger = Observable.fromArray(1, 2, 3, 4);

        // create Observable with just()
        var observableOfString2 = Observable.just("Hello");

    }
}
