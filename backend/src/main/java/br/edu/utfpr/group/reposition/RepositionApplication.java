package br.edu.utfpr.group.reposition;

import br.edu.utfpr.group.reposition.dao.AlunoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositionApplication implements CommandLineRunner{

    // private final AlunoDAO alunoDAO;

    // @Autowired
    // public RepositionApplication(AlunoDAO alunoDAO) {
    //     this.alunoDAO = alunoDAO;
    // }
    
    public static void main(String[] args) {
            SpringApplication.run(RepositionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }

}