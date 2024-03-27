package groupe1.sir.taxeboisson2.service.facade.notification;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;

import java.util.List;

public interface NotificationRetardDeuxiemeNiveauFacade {
    NotificationRetardDeuxiemeNiveau findByCode(int code);
    List<NotificationRetardDeuxiemeNiveau> findByRedevableCin(String cin);
    List<NotificationRetardDeuxiemeNiveau> findByLocaleLibelle(String libelle);
    List<NotificationRetardDeuxiemeNiveau> findByTrimestreCode(int code);
    List<NotificationRetardDeuxiemeNiveau> findByAnneeAndTrimestreCode(int annee, int trimCode);
    List<NotificationRetardDeuxiemeNiveau> findByAnneeAndLocaleLibelle(int annee, String libelle);
    List<NotificationRetardDeuxiemeNiveau> findByAnneeAndRedevableCin(int annee, String cin);
    int deleteByAnneeAndLocaleLibelle(int annee, String libelle);
    int deleteByAnneeAndTrimestreCode(int annee, int trimCode);
    int deleteByAnnee(int annee);
    int deleteByRedevableCin(String cin);
    int deleteByLocaleLibelle(String libelle);
    int save(NotificationRetardDeuxiemeNiveau notif);
    int update(NotificationRetardDeuxiemeNiveau notif);
    int deleteByCode(int code);
    int deleteByTrimestreCode(int code);
    List<NotificationRetardDeuxiemeNiveau> findAll();
}


