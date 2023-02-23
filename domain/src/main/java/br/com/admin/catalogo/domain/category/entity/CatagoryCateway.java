package br.com.admin.catalogo.domain.category.entity;

import br.com.admin.catalogo.domain.category.entity.Category;
import br.com.admin.catalogo.domain.category.entity.CategoryID;
import br.com.admin.catalogo.domain.category.pagination.Pagination;

import java.util.Optional;

public interface CatagoryCateway {

    Category create(CategoryID aCatagory);

    void deleteById(CategoryID andId);

    Optional<Category> findById(CategoryID andId);

    Category update(Category aCategory);

    Pagination<Category> findAll(CategorySearchQuery aQuery);

}
