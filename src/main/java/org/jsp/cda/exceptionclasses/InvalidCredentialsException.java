package org.jsp.cda.exceptionclasses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidCredentialsException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
