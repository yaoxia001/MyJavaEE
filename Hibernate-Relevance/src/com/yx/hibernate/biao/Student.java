package com.yx.hibernate.biao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_inf")
@Getter
@Setter
public class Student {
	@Id
	@Column(name = "stu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String school;

	public Student() {

	}

	public Student(String name, int age, String school) {

	}

}
