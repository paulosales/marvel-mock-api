package com.paulosales.marvel.api.service.exception;

public class ServiceException extends Exception {

  private static final long serialVersionUID = -2051518492183026067L;

  public ServiceException(String message, Throwable e) {
    super(message, e);
  }
}
