package org.csystem.springboot.app.repository;

import org.csystem.springboot.app.model.DeviceInfo;
import org.springframework.data.repository.CrudRepository;

public interface IDeviceRepository extends CrudRepository<DeviceInfo, Long> {

}
