package org.csystem.util.function;


@FunctionalInterface
public interface IFunction<T, R> {
    R apply(T t);
}
