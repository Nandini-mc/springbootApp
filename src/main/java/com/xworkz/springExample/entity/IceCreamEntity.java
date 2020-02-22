package com.xworkz.springExample.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ice_creame_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IceCreamEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 6125967377937648993L;

	@Id
	@GenericGenerator(name="primary",strategy="increment")
	@GeneratedValue(generator="primary")
	private Integer id;
	private String brand;
	private String location;
	private String type;
	private String flavour;

	@Override
	public String toString() {
		return "IceCreamEntity [id=" + id + ", brand=" + brand + ", location=" + location + ", type=" + type
				+ ", flavour=" + flavour + "]";
	}

}
