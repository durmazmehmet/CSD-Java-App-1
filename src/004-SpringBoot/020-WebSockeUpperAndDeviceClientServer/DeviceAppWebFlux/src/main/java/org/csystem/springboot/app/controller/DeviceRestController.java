package org.csystem.springboot.app.controller;

import org.csystem.springboot.app.model.DeviceInfo;
import org.csystem.springboot.app.service.DeviceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/devicesrest")
public class DeviceRestController {
    private final DeviceService m_deviceService;

    public DeviceRestController(DeviceService deviceService)
    {
        m_deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public Mono<DeviceInfo> findById(@PathVariable("id") long id)
    {
        return m_deviceService.findById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<DeviceInfo> findAll()
    {
        return m_deviceService.findAll();
    }
}
