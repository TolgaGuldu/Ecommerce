package com.ecommerce.pim.common.exceptions;

import com.ecommerce.pim.common.results.ErrorResult;
import com.ecommerce.pim.common.results.Result;
import com.ecommerce.pim.common.results.ValidationErrorResult;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 25 October, 2022
 *
 * @author tolga
 */

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage() + ". " + "\r\n");
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage() + ". " + "\r\n");
        }

        Result result = new ValidationErrorResult<>(errors.toString());

        return ResponseEntity.badRequest().body(result);
    }

   /* @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "beklenilen değerler uygun formatta değil"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.NOT_FOUND.value()), "Aradığınız sayfa bulunamadı."));
    }*/
}
