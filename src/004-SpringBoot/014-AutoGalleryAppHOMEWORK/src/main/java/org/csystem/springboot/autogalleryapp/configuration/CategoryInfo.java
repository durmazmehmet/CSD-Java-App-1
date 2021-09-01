package org.csystem.springboot.autogalleryapp.configuration;

public class CategoryInfo {
    private String m_categoryStr;
    private ICategory m_category;

    public CategoryInfo(String categoryStr)
    {
        this(categoryStr, null);
    }

    public CategoryInfo(String categoryStr, ICategory category)
    {
        m_categoryStr = categoryStr;
        m_category = category;
    }

    public String getCategoryStr()
    {
        return m_categoryStr;
    }

    public void setCategoryStr(String categoryStr)
    {
        m_categoryStr = categoryStr;
    }

    public ICategory getCategory()
    {
        return m_category;
    }

    public void setCategory(ICategory category)
    {
        m_category = category;
    }

    @Override
    public boolean equals(Object other)
    {
        return m_categoryStr.equals(((CategoryInfo)other).m_categoryStr);
    }
}
