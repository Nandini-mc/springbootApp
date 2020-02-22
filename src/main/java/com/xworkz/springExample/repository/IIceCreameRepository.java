package com.xworkz.springExample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xworkz.springExample.entity.IceCreamEntity;


public interface IIceCreameRepository extends JpaRepository<IceCreamEntity, Integer> {

	IceCreamEntity getByType(String type);

	@Modifying
	@Transactional
	@Query("UPDATE IceCreamEntity entity SET entity.brand = :brand WHERE entity.id = :id")
	int updateBrandById(@Param("id") Integer id, @Param("brand") String brand);

}
