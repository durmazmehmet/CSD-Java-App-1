package org.csystem.math;

public class RationalException extends RuntimeException {
    private RationalStatus m_rationalStatus;
    public RationalException(String message, RationalStatus rationalStatus)
    {
        super(message);

        m_rationalStatus = rationalStatus;
    }

    public RationalStatus getRationalStatus() {return m_rationalStatus;}

    public String getMessage()
    {
        return String.format("Message=%s, Rational Status=%s", super.getMessage(), m_rationalStatus);
    }

}
