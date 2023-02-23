package br.com.admin.catalogo.domain.category;

import br.com.admin.catalogo.domain.category.validation.ValidationHandler;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {
    protected AggregateRoot(ID id) {
        super(id);
    }

    @Override
    public void validate(ValidationHandler handler) {

    }

}
