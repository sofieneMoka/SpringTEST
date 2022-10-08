package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.model.DetailFacture;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;

public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {

	    @Query("select sum (d.prixTotal) from DetailFacture d where ((d.produit.idProduit= :idProduit) and (d.facture.dateFacture BETWEEN :startDate and :endDate))")
	    Float getRevenuBrutProduit(Long idProduit, Date startDate,Date endDate);


}
