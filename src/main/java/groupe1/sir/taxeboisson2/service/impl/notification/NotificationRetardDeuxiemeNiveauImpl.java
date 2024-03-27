package groupe1.sir.taxeboisson2.service.impl.notification;

import groupe1.sir.taxeboisson2.bean.Redevable;
import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;
import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson2.bean.adresse.Locale;
import groupe1.sir.taxeboisson2.dao.facade.notification.NotificationRetardDeuxiemeNiveauDao;
import groupe1.sir.taxeboisson2.service.facade.notification.NotificationRetardDeuxiemeNiveauFacade;
import groupe1.sir.taxeboisson2.service.impl.LocaleImpl;
import groupe1.sir.taxeboisson2.service.impl.RedevableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationRetardDeuxiemeNiveauImpl implements NotificationRetardDeuxiemeNiveauFacade {
    @Autowired
    private NotificationRetardDeuxiemeNiveauDao notificationRetardDeuxiemeNiveauDao;
    @Autowired
    private RedevableImpl redevableService;
    @Autowired
    private LocaleImpl localeService;
    @Autowired
    private TrimestreImpl trimestreService;
    @Autowired
    private NotificationRetardDeuxiemeNiveauDetailsImpl notificationRetardDeuxiemeNiveauDetailService;

    @Override
    @Transactional
    public NotificationRetardDeuxiemeNiveau findByCode(int code) {
        return notificationRetardDeuxiemeNiveauDao.findByCode(code);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByRedevableCin(String cin) {
        return notificationRetardDeuxiemeNiveauDao.findByRedevableCin(cin);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByLocaleLibelle(String libelle) {
        return notificationRetardDeuxiemeNiveauDao.findByLocaleLibelle(libelle);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByTrimestreCode(int code) {
        return notificationRetardDeuxiemeNiveauDao.findByTrimestreCode(code);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndTrimestreCode(int annee, int trimCode) {
        return notificationRetardDeuxiemeNiveauDao.findByAnneeAndTrimestreCode(annee, trimCode);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndLocaleLibelle(int annee, String libelle) {
        return notificationRetardDeuxiemeNiveauDao.findByAnneeAndLocaleLibelle(annee, libelle);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndRedevableCin(int annee, String cin) {
        return notificationRetardDeuxiemeNiveauDao.findByAnneeAndRedevableCin(annee, cin);
    }
    @Override
    @Transactional
    public int deleteByAnneeAndLocaleLibelle(int annee, String libelle) {
        return notificationRetardDeuxiemeNiveauDao.deleteByAnneeAndLocaleLibelle(annee, libelle);
    }
    @Override
    @Transactional
    public int deleteByAnneeAndTrimestreCode(int annee, int trimCode) {
        return notificationRetardDeuxiemeNiveauDao.deleteByAnneeAndTrimestreCode(annee, trimCode);
    }
    @Override
    @Transactional
    public int deleteByAnnee(int annee) {
        return notificationRetardDeuxiemeNiveauDao.deleteByAnnee(annee);
    }
    @Override
    @Transactional
    public int deleteByRedevableCin(String cin) {
        return notificationRetardDeuxiemeNiveauDao.deleteByRedevableCin(cin);
    }
    @Override
    @Transactional
    public int deleteByLocaleLibelle(String libelle) {
        return notificationRetardDeuxiemeNiveauDao.deleteByLocaleLibelle(libelle);
    }
    @Override
    public int save(NotificationRetardDeuxiemeNiveau notificationRetardDeuxiemeNiveau) {
        Redevable redevable = redevableService.findByCin(notificationRetardDeuxiemeNiveau.getRedevable().getCin());
        if (redevable == null) return -1;
        Locale locale = localeService.findByRef(notificationRetardDeuxiemeNiveau.getLocale().getRef());
        if (locale == null) return -2;

        int derniereNotification = locale.getDerniereNotification();
        int dernierAnneDePaiement = locale.getDernierAnneeDePaiement();
        int dernierTrimestreDePaiement = locale.getDernierTrimestreDePaiement();

        if (derniereNotification == 0) return -3;

        if (dernierAnneDePaiement > notificationRetardDeuxiemeNiveau.getAnnee()) return -4;

        if (dernierTrimestreDePaiement > notificationRetardDeuxiemeNiveau.getTrimestre().getValeur()) return -5;

        NotificationRetardDeuxiemeNiveauDetail notificationRetardDeuxiemeNiveauDetail = new NotificationRetardDeuxiemeNiveauDetail();

        NotificationRetardDeuxiemeNiveau saved = notificationRetardDeuxiemeNiveauDao.save(notificationRetardDeuxiemeNiveau);
        notificationRetardDeuxiemeNiveauDetail.setNotificationRetardDeuxiemeNiveau(saved);
        notificationRetardDeuxiemeNiveauDetailService.save(notificationRetardDeuxiemeNiveauDetail);

        return 1;
    }

    @Override
    public int update(NotificationRetardDeuxiemeNiveau notif) {
          NotificationRetardDeuxiemeNiveau notificationRetardDeuxiemeNiveau = findByCode(notif.getCode());
          if(notificationRetardDeuxiemeNiveau == null){
              return -1;
          }
              notificationRetardDeuxiemeNiveau.setAnnee(notif.getAnnee());
              notificationRetardDeuxiemeNiveau.setRedevable(notif.getRedevable());
              notificationRetardDeuxiemeNiveau.setLocale(notif.getLocale());
              notificationRetardDeuxiemeNiveau.setCode(notif.getCode());
              notificationRetardDeuxiemeNiveau.setTrim(notif.getTrim());
              return 1;


    }
    @Override
    @Transactional
    public int deleteByCode(int code) {
        int notifDetailsSupprime = notificationRetardDeuxiemeNiveauDetailService.deleteByNotificationRetardDeuxiemeNiveauCode(code);
        int notifDeuxiemeNiveauSupprime = notificationRetardDeuxiemeNiveauDao.deleteByCode(code);
        return notifDetailsSupprime + notifDeuxiemeNiveauSupprime ;
    }
    @Override
    @Transactional
    public int deleteByTrimestreCode(int code) {
        return notificationRetardDeuxiemeNiveauDao.deleteByTrimestreCode(code);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveau> findAll() {
        return notificationRetardDeuxiemeNiveauDao.findAll();
    }
}
