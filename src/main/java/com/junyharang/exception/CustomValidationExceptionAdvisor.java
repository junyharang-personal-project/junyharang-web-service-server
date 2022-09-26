package com.junyharang.exception;

import com.junyharang.constant.DefaultResponse;
import com.junyharang.constant.DefaultResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b>Validation 문제 발생 시 Exception Advisor Method</b>
 *
 * @author 주니하랑
 * @version 1.0.0
 */

@RestControllerAdvice
public class CustomValidationExceptionAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponse<String>> processValidationException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuilder stringBuilder = new StringBuilder();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            stringBuilder.append("[");
            stringBuilder.append(fieldError.getField());
            stringBuilder.append("](은)는 ");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(" 입력된 값: [");
            stringBuilder.append(fieldError.getRejectedValue());
            stringBuilder.append("] 이에요.");
        });

        return new ResponseEntity<>(DefaultResponse.response(DefaultResponseMessage.BAD_REQUEST, DefaultResponseMessage.KOREAN_400, stringBuilder.toString()), HttpStatus.BAD_REQUEST);
    }
}
