package org.csystem.application.samplecalculator.operation;

public interface IOperation<T> {
    T apply(T t1, T t2);
    boolean isValid(char op);
}
