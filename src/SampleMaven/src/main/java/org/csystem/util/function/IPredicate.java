package org.csystem.util.function;


@FunctionalInterface
public interface IPredicate<T> {
    boolean test(T t);
}
