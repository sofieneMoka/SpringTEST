package tn.esprit.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idProduit; 
	private String  code; 
	private String  idlibelle;
	private float  idprixUnitaire;

	@ManyToMany(targetEntity=Fournisseur.class,cascade=CascadeType.MERGE)
	private Set<Fournisseur> fournisseurProduit;

	@ManyToOne
	Rayon rayon;
	@ManyToOne
	DetailFacture detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	Stock stock;

}
