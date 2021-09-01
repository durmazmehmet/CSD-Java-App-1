package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample(10);
        
        s.setX(-3);
    }
}

class TestUtil {
    public static final boolean DEBUG = false;
}

class Sample {
    private int m_x;    
    
    public Sample(int x)
    {
        m_x = x;
    }
    
    public void setX(int x)
    {       
        m_x = Math.abs(x);
        
        if (TestUtil.DEBUG)
            assert m_x > 0;
    }
}