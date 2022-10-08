package tn.esprit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.model.CategorieClient;
import tn.esprit.model.Client;
import tn.esprit.model.Profession;
import tn.esprit.services.ClientServiceImlp;

@SpringBootTest
public class ClientTest {
	
	@Autowired
	private ClientServiceImlp clientServiceImlp;
	
	
	@Test
	public void Test(){
		
		try {
            Client client =new Client();
            Date date= new SimpleDateFormat( "yyyyMMdd" ).parse( "20051105" );
            client.setEmail("7ARBOUCHA@gmail.com");
            client.setNom("RJAB");
            client.setPrenom("MONJI");
            client.setPassword("1234");
            client.setCategorie(CategorieClient.Premium);
            client.setProffesion(Profession.Etudiant);
            client.setDateNaissance(date);
            clientServiceImlp.ajouterClient(client);

        }catch (Exception e){


            System.out.println(e.getMessage());
        }
		
	}

}
