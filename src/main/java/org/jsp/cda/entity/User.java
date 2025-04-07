package org.jsp.cda.entity;

import jakarta.persistence.*;
import org.jsp.cda.utility.UserRole;
import org.jsp.cda.utility.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(nullable = false, unique = true)
	private String username;

//	@Column(nullable = false)
	private String password;

//	@Column(nullable = false)
	private String name;
	
//	@Column(unique = true)
	private String email;
	
//	@Column(unique = true)
	private long phone;

	private int otp;

	// @Enumerated(EnumType.ORDINAL)
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	

}
