package tn.esprit.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
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
public class Facture implements  Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	
 		private long idFacture ;
	 	private float montantRemise ;
	 	private float montantFacture ;
	 	@Temporal(value=TemporalType.TIMESTAMP)
		private Date DateFacture  ;
		private boolean active  ;


		@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
		private Set<DetailFacture> detailFactures;
		@ManyToOne
		Client client;
	 
}
