package Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ExceptionHandling exception = new ExceptionHandling(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionHandling exceptionHandling = new ExceptionHandling(new Date(),ex.getMessage(),ex.getBindingResult().toString());

        return new ResponseEntity<>(exceptionHandling,HttpStatus.BAD_REQUEST);
    }
}
