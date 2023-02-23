package br.com.admin.catalogo.domain.category.entity;

public record CategorySearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}
