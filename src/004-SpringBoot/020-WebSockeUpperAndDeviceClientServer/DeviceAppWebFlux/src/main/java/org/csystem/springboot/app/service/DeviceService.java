package org.csystem.springboot.app.service;

import org.csystem.springboot.app.model.DeviceInfo;
import org.csystem.springboot.app.repository.IDeviceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class DeviceService {
    private final IDeviceRepository m_deviceRepository;

    public DeviceService(IDeviceRepository deviceRepository)
    {
        m_deviceRepository = deviceRepository;
    }

    public Mono<DeviceInfo> findById(long id)
    {
        return Mono.justOrEmpty(m_deviceRepository.findById(id)).delayElement(Duration.ofMillis(3000));
    }

    public Flux<DeviceInfo> findAll()
    {
        return Flux.fromIterable(m_deviceRepository.findAll()).delayElements(Duration.ofMillis(100));
    }
}
