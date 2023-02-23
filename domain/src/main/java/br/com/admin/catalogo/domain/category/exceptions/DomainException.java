package br.com.admin.catalogo.domain.category.exceptions;

import br.com.admin.catalogo.domain.category.validation.Error;

import java.util.List;

public class DomainException extends NoStackTraceException {

    private final List<Error> errors;

    private DomainException(final String aMessage, final List<Error> anErros) {
        super(aMessage);
        this.errors = anErros;
    }

    public static DomainException with(final Error anErros){
        return new DomainException(anErros.message(), List.of(anErros));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }
    public List<Error> getErrors() {
        return errors;
    }
}
