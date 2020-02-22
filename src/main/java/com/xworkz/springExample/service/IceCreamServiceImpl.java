package com.xworkz.springExample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springExample.entity.IceCreamEntity;
import com.xworkz.springExample.repository.IIceCreameRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IceCreamServiceImpl implements IIceCreamService {

	@Autowired
	private IIceCreameRepository iceCreameRepository;

	@Override
	public IceCreamEntity save(IceCreamEntity entity) {
		
		return iceCreameRepository.save(entity);
	}

	@Override
	public IceCreamEntity getById(Integer id) {
		return iceCreameRepository.getOne(id);
	}

	@Override
	public Optional<IceCreamEntity> getEnityById(Integer id) {
		return iceCreameRepository.findById(id);
	}

	@Override
	public IceCreamEntity updateByType(IceCreamEntity entity) {
		IceCreamEntity creamEntity = iceCreameRepository.getByType(entity.getType());
		log.info("Entity is {}",creamEntity);
		if(entity.getBrand()!=null) {
			creamEntity.setBrand(entity.getBrand());
		}
		if(entity.getFlavour()!=null) {
			creamEntity.setFlavour(entity.getFlavour());
		}
		if(entity.getLocation()!=null) {
			creamEntity.setLocation(entity.getLocation());
		}
		return iceCreameRepository.save(creamEntity);
	}

	@Override
	public boolean updateBrandById(Integer id, String brand) {
		int res = iceCreameRepository.updateBrandById(id,brand);
		if(res>0) {
			return true;
		}
		
		return false;
	}

}
