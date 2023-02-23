package br.com.admin.catalogo.domain.category.validation.handler;

import br.com.admin.catalogo.domain.category.exceptions.DomainException;
import br.com.admin.catalogo.domain.category.validation.Error;
import br.com.admin.catalogo.domain.category.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try{
            aValidation.Validate();
            }catch(final Exception ex) {
                throw DomainException.with(List.of());
            }
            return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
