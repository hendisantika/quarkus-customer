package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-customer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/10/21
 * Time: 06.17
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
