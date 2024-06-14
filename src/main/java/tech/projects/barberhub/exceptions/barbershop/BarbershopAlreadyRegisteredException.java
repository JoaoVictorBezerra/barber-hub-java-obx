package tech.projects.barberhub.exceptions.barbershop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class BarbershopAlreadyRegisteredException extends BusinessException {
    private final String message;

    public BarbershopAlreadyRegisteredException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Barbershop already registered!");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
