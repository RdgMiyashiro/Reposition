package br.edu.utfpr.group.reposition;

import br.edu.utfpr.group.reposition.dao.AulaDAO;
import br.edu.utfpr.group.reposition.dao.CalendarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositionApplication implements CommandLineRunner{

    private final CalendarioDAO calendarioDAO;
    private final AulaDAO aulaDAO;

    @Autowired
    public RepositionApplication(CalendarioDAO calendarioDAO, AulaDAO aulaDAO) {
        this.calendarioDAO = calendarioDAO;
        this.aulaDAO = aulaDAO;
    }
    
    public static void main(String[] args) {
            SpringApplication.run(RepositionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }

}
