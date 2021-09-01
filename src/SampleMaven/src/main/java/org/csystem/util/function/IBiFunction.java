package org.csystem.util.function;

@FunctionalInterface
public interface IBiFunction<T, U, R> {
    R apply(T t, U u);
}
