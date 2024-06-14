package tech.projects.barberhub.exceptions.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class InvalidTokenException extends BusinessException {
    private final String message;

    public InvalidTokenException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Invalid Access Token.");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
