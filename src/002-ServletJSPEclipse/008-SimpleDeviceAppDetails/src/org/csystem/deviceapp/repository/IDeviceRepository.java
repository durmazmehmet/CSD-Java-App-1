package org.csystem.deviceapp.repository;

import org.csystem.deviceapp.entity.DeviceInfo;
import org.csystem.repository.IRepository;

public interface IDeviceRepository extends IRepository<DeviceInfo, Integer> {
	<S extends DeviceInfo> S save(S d, int...ports);
	Iterable<DeviceInfo> findAll(int limit);
	Iterable<DeviceInfo> findByName(String name);	
	Iterable<DeviceInfo> findByNameContains(String name);
	Iterable<DeviceInfo> findPortsByNameContains(String name);
}
