package br.com.admin.catalogo.domain.category.entity;

import br.com.admin.catalogo.domain.category.AggregateRoot;
import br.com.admin.catalogo.domain.category.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(final CategoryID andId,
                     final String aName,
                     final String aDescription,
                     final boolean isActive,
                     final Instant aCreatedAt,
                     final Instant aUpdateadAt,
                     final Instant aDeleteAt) {
        super(andId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdateadAt;
        this.deletedAt = aDeleteAt;
    }

    public static  Category newCategory(final String  aName, final String aDescription, final boolean aIsActive) {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        final var deletedAt = aIsActive ? null : now;

        return new Category(id, aName, aDescription, aIsActive, now, now, deletedAt);
    }

    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category deactivate(){
        if(getDeletedAt() == null) {
            this.deletedAt = Instant.now();
        }
        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category activate() {
        this.deletedAt = null;
        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public Category update(final String aName,
                           final String aDescription,
                           final boolean isActive) {
        this.name = aName;
        this.description = aDescription;
            if(isActive) {
                activate();
            } else {
                deactivate();
            }
        this.updatedAt = Instant.now();
        return this;
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
