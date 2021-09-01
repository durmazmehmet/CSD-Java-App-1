package com.tuncaykalfa.operationsamples;

import org.csystem.simpleframework.IOperation;

public class AddOperation implements IOperation {
    public int doOperation(int a, int b)
    {
        return a + b;
    }
}
