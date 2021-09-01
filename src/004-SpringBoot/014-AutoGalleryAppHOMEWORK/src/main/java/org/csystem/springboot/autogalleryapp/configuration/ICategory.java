package org.csystem.springboot.autogalleryapp.configuration;

import org.csystem.springboot.autogalleryapp.entity.AutoInfo;

@FunctionalInterface
public interface ICategory {
    Iterable<AutoInfo> findProc(int limit);
}
