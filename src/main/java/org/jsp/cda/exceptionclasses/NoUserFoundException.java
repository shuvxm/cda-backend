package org.jsp.cda.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NoUserFoundException extends RuntimeException
{
	String message;
	

}
