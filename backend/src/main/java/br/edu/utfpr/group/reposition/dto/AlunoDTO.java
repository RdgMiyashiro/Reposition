package br.edu.utfpr.group.reposition.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoDTO {
    private long id;
    private String nome;
}