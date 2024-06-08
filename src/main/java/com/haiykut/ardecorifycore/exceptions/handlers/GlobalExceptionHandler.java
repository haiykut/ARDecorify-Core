package com.haiykut.ardecorifycore.exceptions.handlers;
import com.haiykut.ardecorifycore.exceptions.details.AuthenticatonExceptionDetails;
import com.haiykut.ardecorifycore.exceptions.details.NotFoundExceptionDetails;
import com.haiykut.ardecorifycore.exceptions.details.ValidationProblemDetails;
import com.haiykut.ardecorifycore.exceptions.types.AuthenticationException;
import com.haiykut.ardecorifycore.exceptions.types.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundExceptionDetails handleNotFoundException(NotFoundException exception){
        return new NotFoundExceptionDetails(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationProblem(MethodArgumentNotValidException exception){
        Map<String, String> errorBindings = new HashMap<>();
        exception.getBindingResult().getFieldErrors().stream().map((error) -> errorBindings.put(error.getField(), error.getDefaultMessage())).toList();
        return new ValidationProblemDetails(errorBindings);
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AuthenticatonExceptionDetails handleAuthenticationException(AuthenticationException exception){
        return new AuthenticatonExceptionDetails(exception.getMessage());
    }
}
