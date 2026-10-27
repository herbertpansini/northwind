package br.com.northwind.service.validation.impl;

import br.com.northwind.service.exception.NorthwindException;
import br.com.northwind.service.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValidationExecutor {

    public <T> void validate(T objeto, List<? extends Validator<T>> validators) {
        validators.stream()
                .map(validator -> validator.validate(objeto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .ifPresent(erro -> {
                    throw new NorthwindException(erro);
                });
    }
}