package br.edu.utfpr.group.reposition;

import br.edu.utfpr.group.reposition.dao.CalendarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositionApplication implements CommandLineRunner{

    private final CalendarioDAO calendarioDAO;

    /**
     *  A  injeção de dependências está sendo feito corretamente,
     *  entretanto não é possivel entender o seu fluxo,
     *  talvez seja algo ainda a ser implementado?
     */
    @Autowired
    public RepositionApplication(CalendarioDAO calendarioDAO) {
        this.calendarioDAO = calendarioDAO;
    }  
    
    public static void main(String[] args) {
            SpringApplication.run(RepositionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }

}
