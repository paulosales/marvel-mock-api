package com.paulosales.marvel.api.converters;

public interface Converter<S, T> {

  public T convert(S source);
}
