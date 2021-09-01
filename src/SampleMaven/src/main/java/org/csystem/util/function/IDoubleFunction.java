package org.csystem.util.function;


@FunctionalInterface
public interface IDoubleFunction<T> {
    double apply(T t);
}
