package tn.esprit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Fournisseur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFournisseur ;
	private String code;
	private String libelle;
	
}
