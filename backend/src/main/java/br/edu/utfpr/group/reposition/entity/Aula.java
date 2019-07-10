package br.edu.utfpr.group.reposition.entity;

import br.edu.utfpr.group.reposition.dao.CalendarioDAO;
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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jéssica Ayumi Uehara
 */
//@Data
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

    public Aula(Date data, Date dataInit, Date dataFin, Date dataAusencia, String conteudo, Materia materia, Reposicao reposicao) throws Exception {
        
    }
    
    public void dataPosAusencia(Date data) throws Exception {
        Date dAtual = new Date();
        if (dAtual.after(data))
            throw new Exception("Data invalida");
    }
    
    public void dataAposQuinze(Date data) throws Exception {
        Date dLimite = Aula.dataLimite(data, 15);
        
        if (data.after(dLimite))
            throw new Exception("Data invalida");
    }
    
    public void dataValidaCalendario(Date data, Date dataInit, Date dataFin) throws Exception {
        if (data.before(dataInit))
            throw new Exception("Data invalida");
        
        if (data.after(dataFin))
            throw new Exception("Data invalida");

    }
    
    private void validaData(Date data, Date dataInit, Date dataFin, Date dataAusencia) throws Exception{
        dataPosAusencia(dataAusencia);
        dataAposQuinze(data);
        dataValidaCalendario(data, dataInit, dataFin);
        
        this.data_reposicao = (data);
    }
    
    private static Date dataLimite(Date date, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
}
