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
	// �����Personʵ�������Addressʵ��
	@ManyToOne(targetEntity = Address.class)
	// ӳ������У�ָ������е�����Ϊaddress_id��������Ϊ��
	@JoinColumn(name = "address_id", nullable = false)
	// ָ��hibernate�����еĳ־û�����������������ʵ��
	@Cascade(CascadeType.ALL)
	private Address address;

}
