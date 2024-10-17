package org.jsp.cda.responsestructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResponseStructure<T> 
{
	private int status;
	private String message;
	private T body;

}
