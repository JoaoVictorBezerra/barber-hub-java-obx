package tech.projects.barberhub.exceptions.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class ServiceNotFoundException extends BusinessException {
    private final String message;

    public ServiceNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Service not found.");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
