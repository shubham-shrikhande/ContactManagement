package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table	
public class Contact{
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	@Column
	private long number;
	@Column
	private String email;
	@Column
	private String status;
}
