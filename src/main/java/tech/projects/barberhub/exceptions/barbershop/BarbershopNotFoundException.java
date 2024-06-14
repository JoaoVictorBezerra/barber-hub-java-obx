package tech.projects.barberhub.exceptions.barbershop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class BarbershopNotFoundException extends BusinessException {
    private final String message;

    public BarbershopNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Barbershop not found!");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
