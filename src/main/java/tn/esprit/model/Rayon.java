package tn.esprit.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Rayon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idRayon ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produits;
	
	String code ;
	String libelle;
}
