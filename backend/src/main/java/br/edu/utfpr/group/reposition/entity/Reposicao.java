/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.reposition.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Reposicao implements Serializable {
    @Id @GeneratedValue
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date data_inicio_ausencia;
    
    @Temporal(TemporalType.DATE)
    private Date data_final_ausencia;
    
    private Boolean presencial;
    private String sala_reposicao;
    private int quantidade_aula;
}
