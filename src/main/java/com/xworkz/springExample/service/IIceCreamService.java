package com.xworkz.springExample.service;

import java.util.Optional;

import com.xworkz.springExample.entity.IceCreamEntity;

public interface IIceCreamService {

	IceCreamEntity save(IceCreamEntity entity);

	IceCreamEntity getById(Integer id);

	Optional<IceCreamEntity> getEnityById(Integer id);

	IceCreamEntity updateByType(IceCreamEntity entity);

	boolean updateBrandById(Integer id, String brand);

}
