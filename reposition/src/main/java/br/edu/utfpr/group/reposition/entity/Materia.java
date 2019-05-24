/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.reposition.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jéssica Ayumi Uehara
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Materia implements Serializable {
    @Id
    private String codigo;

    //Não seriam muitos alunos?
    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Professor professor;
}
