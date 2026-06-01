package com.mongrel.backend.dto;

public record GastoResponseDTO(
    Long id,
    String descricao,
    Double valor
) {

}