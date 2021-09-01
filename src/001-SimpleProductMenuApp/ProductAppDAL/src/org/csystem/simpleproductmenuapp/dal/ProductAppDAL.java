package org.csystem.simpleproductmenuapp.dal;

import org.csystem.simpleproductmenuapp.entity.Product;

import java.math.BigDecimal;

public class ProductAppDAL {
    private Product [] m_products;
    private int m_index;

    public ProductAppDAL(int n)
    {
        m_products = new Product[n];
    }

    public boolean saveProduct(Product product)
    {
        if (m_index == m_products.length)
            return false;

        product.setId(m_index + 1);
        m_products[m_index++] = product;

        return true;
    }

    public Product findExpensiveProduct()
    {
        if (m_index == 0)
            return null;

        var max = m_products[0];

        for (var i = 1; i < m_index; ++i)
            if (max.getPrice().compareTo(m_products[i].getPrice()) < 0)
                max = m_products[i];

        return max;

    }

    public Product findCheapProduct()
    {
        if (m_index == 0)
            return null;

        var min = m_products[0];

        for (var i = 1; i < m_index; ++i)
            if (min.getPrice().compareTo(m_products[i].getPrice()) > 0)
                min = m_products[i];

        return min;
    }

    public BigDecimal findSellAll()
    {
        var result = BigDecimal.ZERO;

        for (var i = 0; i < m_index; ++i) {
            var p = m_products[i];

            if (p.getStock() > 0)
                result = result.add(p.getPrice().subtract(p.getCost()).multiply(BigDecimal.valueOf(p.getStock())));
        }

        return result;
    }
}
