
package org.csystem.springboot.app.controller;

import org.csystem.springboot.app.service.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService m_deviceService;

    public DeviceController(DeviceService deviceService)
    {
        m_deviceService = deviceService;
    }


    @GetMapping
    public Mono<String> list(Model model)
    {
        var devices = m_deviceService.findAll();

        model.addAttribute("devices", devices);

        return Mono.just("devices/list");
    }

    @GetMapping(value = "/morereactive")
    public Mono<String> listMoreReactive(Model model)
    {
        var devices = m_deviceService.findAll();

        model.addAttribute("devices", new ReactiveDataDriverContextVariable(devices, 100));

        return Mono.just("devices/list");
    }
}
