package br.edu.utfpr.group.reposition.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Aluno implements Serializable {
    
    @Id
    private Long ra;
    private String nome;
}
