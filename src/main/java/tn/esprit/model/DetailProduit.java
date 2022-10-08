package tn.esprit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailProduit;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date datDernieremodification;
	
	@Enumerated(EnumType.ORDINAL)

	private CategorieProduit categorieProduit;
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;

	
}
