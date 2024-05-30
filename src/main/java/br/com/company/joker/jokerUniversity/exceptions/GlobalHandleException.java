package br.com.company.joker.jokerUniversity.exceptions;

import java.net.URI;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.micrometer.common.lang.Nullable;

@RestControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNotFoundException.class)
    ProblemDetail handleEntidadeNotFoundException(EntidadeNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "Error: " + e.getLocalizedMessage());

        problemDetail.setTitle("Resource not found");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/not-found"));
        return problemDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                "Data integrity error: " + e.getMessage());
        problemDetail.setTitle("Data Integrity Breach");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/data-integrity-violation"));
        return problemDetail;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                "Error: '" + exception.getLocalizedMessage());
        pd.setType(URI.create("http://localhost:8080/errors/internal-server-error"));
        pd.setTitle("Internal Error");
        pd.setProperty("hostname", "localhost");
        return ResponseEntity.status(500).body(pd);
    }

    @ExceptionHandler(NoSuchElementException.class)
    ProblemDetail handleNoSuchElementException(NoSuchElementException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Resource not Found");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/not-found"));
        return problemDetail;
    }


    @ExceptionHandler(NullPointerException.class)
    ProblemDetail handleNullPointerException(NullPointerException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Request error");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/bad-request"));
        return problemDetail;

    }

    @ExceptionHandler(HttpClientErrorException.class)
    ProblemDetail handleHttpClientErrorException(HttpClientErrorException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle("Request error");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/bad-request"));
        return problemDetail;
    }

    @ExceptionHandler(AccessDeniedException.class)
    ProblemDetail handleAccessDeniedException(AccessDeniedException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, e.getMessage());
        problemDetail.setTitle("Authentication error");
        problemDetail.setType(URI.create("https://api.ecommerce.com/errors/forbidden"));
        problemDetail.setDetail("Unauthenticated user. Login before proceeding.");
        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {
        ResponseEntity<Object> response = super.handleExceptionInternal(ex, body, headers, statusCode, request);

        if (response.getBody() instanceof ProblemDetail problemDetailBody) {
            problemDetailBody.setProperty("message", ex.getMessage());
            if (ex instanceof MethodArgumentNotValidException subEx) {
                BindingResult result = subEx.getBindingResult();
                problemDetailBody.setType(URI.create("http://api.ecommerce.com/erros/argument-not-valid"));
                problemDetailBody.setTitle("Request error");
                problemDetailBody.setDetail("An error occurred while processing the Request");
                problemDetailBody.setProperty("message", "Object Validation Failed" + result.getObjectName()
                        + "'. " + "Number of Erros: " + result.getErrorCount());
                List<FieldError> fldErros = result.getFieldErrors();
                List<String> erros = new ArrayList<>();

                for (FieldError obj : fldErros) {
                    erros.add("Field: " + obj.getField() + " - Error: " + obj.getDefaultMessage());
                }
                problemDetailBody.setProperty("Erros Found", erros.toString());
            }
        }
        return response;
    }
}