package org.example.validators;

public interface Validator<T> {
    boolean isValid(T t);
}
