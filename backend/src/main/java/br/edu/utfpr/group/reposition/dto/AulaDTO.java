/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.group.reposition.dto;

/**
 *
 * @author Rodri
 */

import br.edu.utfpr.group.reposition.entity.Aula;
import br.edu.utfpr.group.reposition.entity.Materia;
import br.edu.utfpr.group.reposition.entity.Reposicao;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


//Funcionalidade do sistema relacionada à reposição de aula, porem nao houve tempo de coloca-la em pratica
@AllArgsConstructor
@Data
@Builder
public class AulaDTO {
    private Long id;
    private Date data_reposicao;
    private String conteudo;
    private Reposicao reposicao;
    private Materia materia;
    
    public void setData(Date data, Date dataInit, Date dataFin, Date dataAusencia) throws Exception{
        if(validaData(data, dataInit, dataFin, dataAusencia))
            this.data_reposicao = data;
        else
            throw new Exception("Data invalida");
    }
    
    private boolean dataPosAusencia(Date data) throws Exception {
        Date dAtual = new Date();
        if (dAtual.after(data))
            throw new Exception("Data invalida");
        else return true;
    }
    
    private boolean dataAposQuinze(Date data) throws Exception {
        Date dLimite = dataLimite(data, 15);
        
        if (data.after(dLimite))
            throw new Exception("Data invalida");
        else return true;
    }
    
    private boolean dataValidaCalendario(Date data, Date dataInit, Date dataFin) throws Exception {
        if (data.before(dataInit))
            throw new Exception("Data invalida");
        
        else if (data.after(dataFin))
            throw new Exception("Data invalida");
        
        else return true;
    }
    
    private boolean validaData(Date data, Date dataInit, Date dataFin, Date dataAusencia) throws Exception{        
        return (dataPosAusencia(dataAusencia) && dataAposQuinze(data) && dataValidaCalendario(data, dataInit, dataFin));
    }
    
    private Date dataLimite(Date date, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
}
