package org.csystem.simpleproductmenuapp.entity;

import java.math.BigDecimal;

public class Product {
    private int m_id;
    private String m_code;
    private String m_name;
    private int m_stock;
    private BigDecimal m_cost;
    private BigDecimal m_price;

    public Product(int id, String code, String name, int stock, BigDecimal cost, BigDecimal price)
    {
        m_id = id;
        m_code = code;
        m_name = name;
        m_stock = stock;
        m_cost = cost;
        m_price = price;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getCode()
    {
        return m_code;
    }

    public void setCode(String code)
    {
        m_code = code;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getStock()
    {
        return m_stock;
    }

    public void setStock(int stock)
    {
        m_stock = stock;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public BigDecimal getPrice()
    {
        return m_price;
    }

    public void setPrice(BigDecimal price)
    {
        m_price = price;
    }

    public String toString()
    {
        return String.format("[%d]%s:%d", m_id, m_name, m_stock);
    }
}
