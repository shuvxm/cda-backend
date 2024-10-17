package org.jsp.cda.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class InvalidUserIdException extends RuntimeException
{
	String message;
	
	public String getMessage()
	{
		return this.message;
	}

}
