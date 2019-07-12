package br.edu.utfpr.group.reposition.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.group.reposition.dao.Aluno;
import br.edu.utfpr.group.reposition.dto.AlunoDTO;
import br.edu.utfpr.group.reposition.negocio.AlunoNegocio;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class ServicoAluno {

    /**
     *
     */

    private  List<AlunoDTO> alunos;

    public ServicoAluno() {
        alunos = Stream.of(
            AlunoDTO.builder().id(1).nome("Thiago").build(),
            AlunoDTO.builder().id(2).nome("Rodrigo Miyashiro").build(),
            AlunoDTO.builder().id(3).nome("Jéssica").build()
        ).collect(Collectors.toList());
    }

    @GetMapping ("/servico/aluno")
    public ResponseEntity<List<AlunoDTO>> listar() {
        
        return ResponseEntity.ok(alunos);
    }

    @GetMapping ("/servico/aluno/{id}")
    public ResponseEntity<AlunoDTO> listarPorId(@PathVariable int id) {
        Optional<AlunoDTO> alunoEncontrado = alunos.stream().filter(a -> a.getId() == id).findAny();

        return ResponseEntity.of(alunoEncontrado);
    }

    @PostMapping ("/servico/aluno")
    public ResponseEntity<AlunoDTO> criar (@RequestBody AlunoDTO aluno) {

        aluno.setId(alunos.size() + 1);
        alunos.add(aluno);

        return ResponseEntity.status(201).body(aluno);
    }

    @DeleteMapping ("/servico/aluno/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        
        if (alunos.removeIf(aluno -> aluno.getId() == id))
            return ResponseEntity.noContent().build();

        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/aluno/{id}")
    public ResponseEntity<AlunoDTO> alterar (@PathVariable int id, @RequestBody AlunoDTO aluno) {
        Optional<AlunoDTO> alunoExistente = alunos.stream().filter(a -> a.getId() == id).findAny();

        alunoExistente.ifPresent(a -> {
            a.setNome(aluno.getNome());
        });

        return ResponseEntity.of(alunoExistente);
    }
}