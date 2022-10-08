package tn.esprit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class DetailFacture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailFacture ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateCreation ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateDernierModification ;
	@Enumerated(EnumType.ORDINAL)
	private CategorieProduit CategorieProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="detailFacture")
	private Set<Produit> produits;
	@ManyToOne
	Facture facture;

	
	
}
