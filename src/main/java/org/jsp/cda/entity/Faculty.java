package org.jsp.cda.entity;

import java.time.LocalTime;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty 
{
	@OneToOne
	@MapsId
	@Id
	private User user_id;
	
	@ManyToOne
	private Department department_id;
	
	private LocalTime officeHours;
	
	

}
