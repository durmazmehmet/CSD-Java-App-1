package org.csystem.util.function;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t);
}
