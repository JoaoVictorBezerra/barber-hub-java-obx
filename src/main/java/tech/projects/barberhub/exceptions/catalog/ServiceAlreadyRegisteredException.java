package tech.projects.barberhub.exceptions.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class ServiceAlreadyRegisteredException extends BusinessException {
    private final String message;

    public ServiceAlreadyRegisteredException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Service already registered.");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
