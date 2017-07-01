package com.yx.hibernate.guanlian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address_inf")
public class Address {
	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;
	private String addressdizhi;

	public Address() {

	}

	public Address(String addressdizhi) {
		this.addressdizhi = addressdizhi;

	}

}
