package com.ecommerce.om.common.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptions {

    /*@ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    protected ResponseEntity<Object> transactionExceptionHandler(WebRequest request, ArithmeticException ex) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "işleminizi gerçekleştiremiyoruz"));
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    protected ResponseEntity<Object> sqlExceptionHandler(WebRequest request, SQLException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

    @ExceptionHandler(JDBCConnectionException.class)
    protected ResponseEntity<Object> handleConnectionError(WebRequest request, JDBCConnectionException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

    @ExceptionHandler(BeanCreationException.class)
    protected ResponseEntity<Object> beanerrors(WebRequest request, BeanCreationException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Object> handlePersistenceException(final Exception ex, final WebRequest request) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }*/

   /* @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> entityNotFound(WebRequest request, RuntimeException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }*/

   /* @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<Object> entityNotFound(WebRequest request, NonUniqueResultException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> iaException(WebRequest request, IllegalArgumentException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ResponseEntity<Object> cngj(WebRequest request, CannotGetJdbcConnectionException ex) {
        return ResponseEntity.ok(new ErrorResult("500", "Sunucuda beklenmedik bir hata meydana geldi."));
    }

   @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Object> handleException(WebRequest request,JsonParseException ex) {
        return ResponseEntity.ok(new ErrorResult(String.valueOf(HttpStatus.RESET_CONTENT.value()), "Lütfen değer giriniz"));
    }*/

}
