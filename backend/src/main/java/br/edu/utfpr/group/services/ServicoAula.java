/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.services;

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

import br.edu.utfpr.group.reposition.dto.AulaDTO;
import br.edu.utfpr.group.reposition.entity.Materia;
import br.edu.utfpr.group.reposition.entity.Reposicao;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rodri
 */
@RestController
public class ServicoAula {
    private List<AulaDTO> aulas;

    public ServicoAula() {
    }
    
    @GetMapping ("/servico/aula")
    public ResponseEntity<List<AulaDTO>> listar() {
    // public List<PaisDTO> listar() {
        // return paises;
        return ResponseEntity.ok(aulas);
    }

    @GetMapping ("/servico/aula/{id}")
    public ResponseEntity<AulaDTO> listarPorId(@PathVariable int id) {
        Optional<AulaDTO> paisEncontrado = aulas.stream().filter(p -> p.getId() == id).findAny();

        return ResponseEntity.of(paisEncontrado);
    }

    @PostMapping ("/servico/aula")
    public ResponseEntity<AulaDTO> criar (@RequestBody AulaDTO aula) {
        aulas.add(aula);

        return ResponseEntity.status(201).body(aula);
    }

    @DeleteMapping ("/servico/aula/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        
        if (aulas.removeIf(aula -> aula.getId() == id))
            return ResponseEntity.noContent().build();

        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/aula/{id}")
    public ResponseEntity<AulaDTO> alterar (@PathVariable int id, @RequestBody AulaDTO aula) {
        Optional<AulaDTO> paisExistente = aulas.stream().filter(p -> p.getId() == id).findAny();

//        paisExistente.ifPresent(p -> {
//            p.setNome(aula.setData(data, dataInit, dataFin, dataAusencia);
//            p.setNome(aula.getNome());
//            p.setSigla(aula.getSigla());
//            p.setCodigoTelefone(aula.getCodigoTelefone());
//        });

        return ResponseEntity.of(paisExistente);
    }
}