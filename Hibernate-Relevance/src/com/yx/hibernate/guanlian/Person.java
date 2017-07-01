package com.yx.hibernate.guanlian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.yx.hibernate.guanlian.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person_inf")
@Setter
@Getter
public class Person {
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	// 定义该Person实体关联的Address实体
	@ManyToOne(targetEntity = Address.class)
	// 映射外键列，指定外键列的列名为address_id、不允许为空
	@JoinColumn(name = "address_id", nullable = false)
	// 指定hibernate将所有的持久化操作都级联到关联实体
	@Cascade(CascadeType.ALL)
	private Address address;

}
