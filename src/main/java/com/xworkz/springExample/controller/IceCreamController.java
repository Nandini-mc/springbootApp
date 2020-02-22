package com.xworkz.springExample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.springExample.entity.IceCreamEntity;
import com.xworkz.springExample.service.IIceCreamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IceCreamController {

	
	@Autowired
	private IIceCreamService iIceCreamService;
	
	@GetMapping("/")
	public String check() {
		return "Working????????";
	}
	@GetMapping("/getBrandById")
	public ResponseEntity<String> getBrandById(@RequestParam("id") Integer id){
		log.info("id is {}",id);
		Optional<IceCreamEntity> opEntity = iIceCreamService.getEnityById(id);
		if(opEntity.isPresent())
			return new ResponseEntity<String>(opEntity.get().getBrand(),HttpStatus.OK);
		
			return new ResponseEntity<String>("data not found",HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getIceCreamById")
	public ResponseEntity<IceCreamEntity> getIceCreamById(@RequestParam("id") Integer id){
		log.info("id is {}",id);
		IceCreamEntity entity = iIceCreamService.getById(id);
		return new ResponseEntity<IceCreamEntity>(entity,HttpStatus.OK);
	}
	
	@PostMapping("/saveIceCream")
	public ResponseEntity<IceCreamEntity> save(@RequestBody IceCreamEntity entity){
		entity = iIceCreamService.save(entity);
		log.info("entity is {}",entity);
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/updateById")
	public ResponseEntity<IceCreamEntity> updateIceCreamById( @RequestBody IceCreamEntity entity){
		log.info("entity is {}",entity);
		entity = iIceCreamService.save(entity);
		return new ResponseEntity<IceCreamEntity>(entity,HttpStatus.OK);
	}
	
	@PutMapping("/updateByType")
	public ResponseEntity<IceCreamEntity> updateIceCreamByType( @RequestBody IceCreamEntity entity){
		log.info("entity is {}",entity);
		entity = iIceCreamService.updateByType(entity);
//		entity = iIceCreamService.save(entity);
		return new ResponseEntity<IceCreamEntity>(entity,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateBrandById")
	public ResponseEntity<String> updateBrandById(@RequestParam Integer id , @RequestParam String brand){
		log.info("Id Is {} and brand is {}",id,brand);
		boolean updt = iIceCreamService.updateBrandById(id,brand);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
