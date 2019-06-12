package com.jeka.golub.shelter.persistence.converters;

import java.text.ParseException;

public interface Converter<T, R> {
    T convertForward(R subject);

    R convertReverse(T subject) throws ParseException;
}
