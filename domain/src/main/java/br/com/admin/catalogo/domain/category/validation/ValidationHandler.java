package br.com.admin.catalogo.domain.category.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);

    ValidationHandler validate(Validation aValidation);

    public List<Error> getErrors();

    default boolean hasError(){
        return getErrors() != null && !getErrors().isEmpty();
    }

    public interface Validation{
        void Validate();
    }
}
