package org.jsp.cda.exceptionclasses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoCoursesFoundException extends RuntimeException{
    private String message;

    public String getMessage() {
        return this.message=message;
    }
}
