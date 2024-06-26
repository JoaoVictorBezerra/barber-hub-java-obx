package tech.projects.barberhub.exceptions.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class RoleNotAllowedException extends BusinessException {
    private final String message;
    public RoleNotAllowedException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Forbidden.");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
