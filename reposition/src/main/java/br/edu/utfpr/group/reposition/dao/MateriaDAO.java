/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.reposition.dao;

import br.edu.utfpr.group.reposition.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jéssica Ayumi Uehara
 */
public interface MateriaDAO extends JpaRepository<Materia, String>{
    
}
