package org.csystem.collectioninjection.operation;

public interface IOperation {
    int apply(int t1, int t2);
    boolean isValid(char op);
}
