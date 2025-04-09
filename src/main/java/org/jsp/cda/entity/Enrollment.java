package org.jsp.cda.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Student student;
	
//	@ManyToOne
	@ManyToOne(fetch = FetchType.EAGER)
	private Course course;


}
