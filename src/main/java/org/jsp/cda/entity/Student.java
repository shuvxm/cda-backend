package org.jsp.cda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{
	@Id
	private int id;

	@OneToOne
	@MapsId
	private User user;
	@ManyToOne
	private Department  department;

	private String photo;
	private int yearOFStudying;
	
	
	
}
