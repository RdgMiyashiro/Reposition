package br.edu.utfpr.group.reposition.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Jéssica Ayumi Uehara
 */
@Data
@Builder
@Entity
@AllArgsConstructor
public class Aula implements Serializable {
    @Id @GeneratedValue
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date data_reposicao;
    private String conteudo;
    
    @ManyToOne 
    private Reposicao reposicao;
    
    @ManyToOne
    private Materia materia;
}
