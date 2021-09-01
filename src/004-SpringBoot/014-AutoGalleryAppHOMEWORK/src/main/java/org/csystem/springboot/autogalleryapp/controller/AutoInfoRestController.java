package org.csystem.springboot.autogalleryapp.controller;

import org.csystem.springboot.autogalleryapp.entity.AutoInfo;
import org.csystem.springboot.autogalleryapp.service.IAutoInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autosrest")
public class AutoInfoRestController {
    private final IAutoInfoService m_autoInfoService;

    public AutoInfoRestController(IAutoInfoService autoInfoService)
    {
        m_autoInfoService = autoInfoService;
    }

    @GetMapping("/autos")
    public Iterable<AutoInfo> getAutosByKmIntervalAndRent(
            @RequestParam("kmin") int kmin,
            @RequestParam("kmax") int kmax,
            @RequestParam("rent") boolean rent)
    {
        return m_autoInfoService.findByKmIntervalAndRent(kmin, kmax, rent);
    }

    @GetMapping("/autoscount")
    public Iterable<AutoInfo> getTopByCategory(@RequestParam("count") int limit, @RequestParam(value = "category", required = false, defaultValue = "") String category)
    {
        return m_autoInfoService.findTopByCategory(limit, category);
    }

    @PostMapping
    public AutoInfo save(@RequestBody AutoInfo autoInfo)
    {
        return m_autoInfoService.save(autoInfo);
    }
}
