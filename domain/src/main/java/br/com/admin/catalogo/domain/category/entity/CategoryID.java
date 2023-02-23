package br.com.admin.catalogo.domain.category.entity;

import br.com.admin.catalogo.domain.category.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(final String value){
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique(){
        return CategoryID.from(UUID.randomUUID());
    }

    public static  CategoryID from( final String andId){
        return new CategoryID(andId);
    }

    public static CategoryID from(final UUID andId){
        return new CategoryID((andId.toString().toLowerCase()));
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
