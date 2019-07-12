package br.edu.utfpr.group.reposition.negocio;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.edu.utfpr.group.reposition.dto.AlunoDTO;

public class AlunoNegocio {

    public void incluir(AlunoDTO aluno) {

    }

    public List<AlunoDTO> listar() {
        return Stream.of(
            AlunoDTO.builder().id(1).nome("Thiago").build(),
            AlunoDTO.builder().id(2).nome("Rodrigo").build(),
            AlunoDTO.builder().id(3).nome("Jéssica").build()
        ).collect(Collectors.toList());
    }

}