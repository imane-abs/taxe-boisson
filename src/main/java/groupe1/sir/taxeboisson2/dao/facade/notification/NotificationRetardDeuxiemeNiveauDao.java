package groupe1.sir.taxeboisson2.dao.facade.notification;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRetardDeuxiemeNiveauDao extends JpaRepository<NotificationRetardDeuxiemeNiveau , Long> {
             NotificationRetardDeuxiemeNiveau findByCode(int code);
             List<NotificationRetardDeuxiemeNiveau> findByRedevableCin(String cin);
             List<NotificationRetardDeuxiemeNiveau> findByLocaleLibelle(String libelle);
             List<NotificationRetardDeuxiemeNiveau> findByTrimestreCode(int code);
             List<NotificationRetardDeuxiemeNiveau> findByAnnee(int annee);
             List<NotificationRetardDeuxiemeNiveau> findByAnneeAndTrimestreCode(int annee , int trimCode);
             List<NotificationRetardDeuxiemeNiveau> findByAnneeAndLocaleLibelle(int annee , String libelle);
             List<NotificationRetardDeuxiemeNiveau> findByAnneeAndRedevableCin(int annee , String cin);
             List<NotificationRetardDeuxiemeNiveau> findByTrimestreCodeAndAnneeAndRedevableCin(int trimCode , int annee , String cin );
             List<NotificationRetardDeuxiemeNiveau> findByTrimestreCodeAndAnneeAndLocaleLibelle(int trimCode , int annee , String libelle );
             int deleteByTrimestreCodeAndAnneeAndLocaleLibelle(int trimCode , int annee , String libelle );
             int deleteByTrimCodeAndAnneeAndRedevableCin(int trimCode , int annee , String cin );
             int deleteByAnneeAndRedevableCin(int annee , String cin);
             int deleteByAnneeAndLocaleLibelle(int annee , String libelle);
             int deleteByAnneeAndTrimestreCode(int annee , int trimCode);
             int deleteByAnnee(int annee);
             int deleteByRedevableCin(String cin);
             int deleteByLocaleLibelle(String libelle);
             int deleteByCode(int code);
             int deleteByTrimestreCode(int code);
}
