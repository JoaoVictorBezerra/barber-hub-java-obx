package tech.projects.barberhub.exceptions.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import tech.projects.barberhub.exceptions.BusinessException;

public class UserNotFoundException extends BusinessException {
private final String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("User not found.");
        problemDetail.setDetail(message);
        return problemDetail;
    }
}
