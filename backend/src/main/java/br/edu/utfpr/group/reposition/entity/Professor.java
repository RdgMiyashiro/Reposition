/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.reposition.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Professor implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private String ra;
    private String nome;
}
