//package org.example.service;
//
///*
// * Created by kelly on 29/09/2020.
// */
//
//import java.util.Objects;
//
//@FunctionalInterface
//public interface Function<T, R> {
//    // 接受输入参数，对输入执行所需操作后  返回一个结果。
//    R apply(T t);
//
//    // 返回一个 先执行before函数对象apply方法，再执行当前函数对象apply方法的 函数对象。
//    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
//        Objects.requireNonNull(before);
//        return (V v) -> apply(before.apply(v));
//    }
//
//    // 返回一个 先执行当前函数对象apply方法， 再执行after函数对象apply方法的 函数对象。
//    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
//        Objects.requireNonNull(after);
//        return (T t) -> after.apply(apply(t));
//    }
//
//    // 返回一个执行了apply()方法之后只会返回输入参数的函数对象。
//    static <T> Function<T, T> identity() {
//        return t -> t;
//    }
//}
//
