package org.jsp.cda.exceptionclasses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidStudentIdException extends RuntimeException{
    private String message;

    public String getMessage() {
        return this.message=message;
    }
}
