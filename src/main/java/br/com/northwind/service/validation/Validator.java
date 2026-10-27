package br.com.northwind.service.validation;

import java.util.Optional;

public interface Validator<T> {
    Optional<String> validate(T objeto);
}