package groupe1.sir.taxeboisson2.service.impl.notification;

import groupe1.sir.taxeboisson2.bean.adresse.CategorieLocale;
import groupe1.sir.taxeboisson2.bean.adresse.Locale;
import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;
import groupe1.sir.taxeboisson2.bean.notification.TypeEstimation;
import groupe1.sir.taxeboisson2.bean.taxe.TauxTaxeBoisson;
import groupe1.sir.taxeboisson2.bean.taxe.TaxeBoisson;
import groupe1.sir.taxeboisson2.bean.taxe.Trimestre;
import groupe1.sir.taxeboisson2.dao.facade.notification.NotificationRetardDeuxiemeNiveauDetailsDao;
import groupe1.sir.taxeboisson2.service.facade.notification.NotificationDeuxiemeNiveauDetailsFacade;
import groupe1.sir.taxeboisson2.service.impl.LocaleImpl;
import groupe1.sir.taxeboisson2.service.impl.taxe.TauxTaxeBoissonImpl;
import groupe1.sir.taxeboisson2.service.impl.taxe.TaxeBoissonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NotificationRetardDeuxiemeNiveauDetailsImpl implements NotificationDeuxiemeNiveauDetailsFacade {
    @Autowired
    private NotificationRetardDeuxiemeNiveauDetailsDao notificationDeuxiemeNiveauDetailsDao;
    @Autowired
    private NotificationRetardDeuxiemeNiveauImpl notificationRetardDeuxiemeNiveauImpl;
    @Autowired
    private TrimestreImpl trimestreImpl;
    @Autowired
    private TypeEstimationImpl typeEstimationService;
    @Autowired
    private TaxeBoissonImpl taxeBoissonService;
    @Autowired
    private LocaleImpl localeService ;
    @Autowired
    private TauxTaxeBoissonImpl tauxTaxeBoissonService ;

    @Override
    public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByTypeEstimationCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.findByTypeEstimationCode(code);
    }

    @Override
    public NotificationRetardDeuxiemeNiveauDetail findByCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.findByCode(code);
    }

    @Override
    public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNotificationRetardDeuxiemeNiveauCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.findByNotificationRetardDeuxiemeNiveauCode(code);
    }

    @Override
    public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNombreMoisRetard(int nombreMoisRetard) {
        return notificationDeuxiemeNiveauDetailsDao.findByNombreMoisRetard(nombreMoisRetard);
    }

    @Override
    @Transactional
    public int deleteByMontantTotal(long montantTotal) {
        return notificationDeuxiemeNiveauDetailsDao.deleteByMontantTotal(montantTotal);
    }

    @Override
    public int save(NotificationRetardDeuxiemeNiveauDetail notifDetails) {
        NotificationRetardDeuxiemeNiveau notificationRetardDeuxiemeNiveau = notificationRetardDeuxiemeNiveauImpl.findByCode(notifDetails.getNotificationRetardDeuxiemeNiveau().getCode());
        Locale locale = localeService.findByRef(notifDetails.getNotificationRetardDeuxiemeNiveau().getLocale().getRef());
        Trimestre trimestre = trimestreImpl.findByCode(notifDetails.getNotificationRetardDeuxiemeNiveau().getTrimestre().getCode());
        if(notificationRetardDeuxiemeNiveau == null) return -1;
        if(locale == null) return -2 ;

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateMaxDePaiement = LocalDateTime.of(notifDetails.getNotificationRetardDeuxiemeNiveau().getAnnee(), trimestre.getMoisFin(), trimestre.getJourFin(), 0, 0);
        double nbrMoisRetard = ChronoUnit.MONTHS.between(dateMaxDePaiement, dateTimeNow);

        notifDetails.setNombreMoisRetard(nbrMoisRetard);
        notifDetails.setAnnee(notificationRetardDeuxiemeNiveau.getAnnee());

        TaxeBoisson taxeBoisson = taxeBoissonService.findByLocaleRefAndTrimestreReferenceAndAnnee(locale.getRef(), trimestre.getCode(), notificationRetardDeuxiemeNiveau.getAnnee()-1);
        TypeEstimation typeEstimation = new TypeEstimation();
        CategorieLocale categorieLocale = locale.getCategorieLocale();
        List<Locale> locales = localeService.findByCategorieLocaleRefAndRueCode(categorieLocale.getCode(), locale.getRue().getCode());

        if (taxeBoisson != null){
            notifDetails.setChiffreAffaireEstime(taxeBoisson.getChiffreAffaire());
            typeEstimation = saveTypeEstimation(typeEstimation , "Estimation par chiffre d'affaire de l'année précédente");
        }
        if (locales != null){
            typeEstimation = saveTypeEstimation(typeEstimation , "Estimation par chiffre d'affaire de la rue");
            estimerChiffreAffaire(locales, trimestre, notificationRetardDeuxiemeNiveau.getAnnee(), notifDetails, typeEstimation);
        }

        locales = localeService.findByCategorieLocaleRefAndRueQuartierCode(categorieLocale.getCode(), locale.getRue().getQuartier().getCode());
        if (locales != null){
            typeEstimation = saveTypeEstimation(typeEstimation , "Estimation par chiffre d'affaire de le quartier");
            estimerChiffreAffaire(locales, trimestre, notificationRetardDeuxiemeNiveau.getAnnee(), notifDetails, typeEstimation);

        }

        locales = localeService.findByCategorieLocaleRefAndRueQuartierSecteurCode(categorieLocale.getCode(), locale.getRue().getQuartier().getSecteur().getCode());
        if (locales != null){
            typeEstimation = saveTypeEstimation(typeEstimation , "Estimation par chiffre d'affaire de le secteur");
            estimerChiffreAffaire(locales, trimestre, notificationRetardDeuxiemeNiveau.getAnnee(), notifDetails, typeEstimation);
        }

        locales = localeService.findByCategorieLocaleRefAndRueQuartierSecteurVilleCode(categorieLocale.getCode(), locale.getRue().getQuartier().getSecteur().getVille().getCode());
        if (locales != null){
            typeEstimation = saveTypeEstimation(typeEstimation , "Estimation par chiffre d'affaire de la ville");
            estimerChiffreAffaire(locales, trimestre, notificationRetardDeuxiemeNiveau.getAnnee(), notifDetails, typeEstimation);
        }

        TauxTaxeBoisson tauxTaxeBoisson = tauxTaxeBoissonService.findByCategorieLocaleRef(categorieLocale.getCode());
        double pourcentageRetardPremierMois = tauxTaxeBoisson.getPourcentageRetardPremierMois();
        double pourcentageRetardAutreMois = tauxTaxeBoisson.getPourcentageRetardAutreMois();
        BigDecimal montantRetardPremierMois = notifDetails.getChiffreAffaireEstime().multiply(BigDecimal.valueOf(pourcentageRetardPremierMois));
        BigDecimal montantRetardAutreMois = notifDetails.getChiffreAffaireEstime().multiply(BigDecimal.valueOf(pourcentageRetardAutreMois));
        notifDetails.setMontantRetardPremierMois(montantRetardPremierMois);
        notifDetails.setMontantRetardAutreMois(montantRetardAutreMois);
        BigDecimal montantDeBase = BigDecimal.ZERO;
        BigDecimal montantTotal = BigDecimal.ZERO;
        montantDeBase = notifDetails.getChiffreAffaireEstime().multiply(BigDecimal.valueOf(tauxTaxeBoisson.getPourcentage()));
        if (nbrMoisRetard == 1){
            montantTotal = montantDeBase.add(montantRetardPremierMois);
        }
        else if (nbrMoisRetard > 1){
            montantTotal = montantDeBase.add(montantRetardAutreMois);
        }
        notifDetails.setMontantBase(montantDeBase);
        notifDetails.setMontantTotal(montantTotal);

        notificationDeuxiemeNiveauDetailsDao.save(notifDetails);
        return 1;
    }

    public void estimerChiffreAffaire(List<Locale> locales, Trimestre trimestre, int annee, NotificationRetardDeuxiemeNiveauDetail notificationRetardDeuxiemeNiveauDetail , TypeEstimation typeEstimation){
        BigDecimal somme = BigDecimal.ZERO;
        for (Locale l : locales){
            TaxeBoisson taxeBoisson = taxeBoissonService.findByLocaleRefAndTrimestreReferenceAndAnnee(l.getRef(), trimestre.getCode(), annee-1);
            if (taxeBoisson != null){
                somme = somme.add(taxeBoisson.getChiffreAffaire());
            }
        }
        BigDecimal nombreLocales = BigDecimal.valueOf(locales.size());
        if (!BigDecimal.ZERO.equals(nombreLocales)) {
            BigDecimal moyenne = somme.divide(nombreLocales, RoundingMode.HALF_UP);
            notificationRetardDeuxiemeNiveauDetail.setChiffreAffaireEstime(moyenne);
        }
        notificationRetardDeuxiemeNiveauDetail.setTypeEstimation(typeEstimation);}
    public TypeEstimation saveTypeEstimation(TypeEstimation typeEstimation , String libelle ){
        typeEstimation.setLibelle(libelle);
        return typeEstimationService.save(typeEstimation);
    }
    @Override
    public int update(NotificationRetardDeuxiemeNiveauDetail notifDetails) {
        int codeNotifDetails = notifDetails.getCode();
        NotificationRetardDeuxiemeNiveauDetail notificationRetardDeuxiemeNiveauDetails = notificationDeuxiemeNiveauDetailsDao.findByCode(codeNotifDetails);
        if (notificationRetardDeuxiemeNiveauDetails == null) {
            return -1;
        }
            notificationRetardDeuxiemeNiveauDetails.setAnnee(notifDetails.getAnnee());
            notificationRetardDeuxiemeNiveauDetails.setCode(notifDetails.getCode());
            notificationRetardDeuxiemeNiveauDetails.setChiffreAffaireEstime(notifDetails.getChiffreAffaireEstime());
            notificationRetardDeuxiemeNiveauDetails.setNombreMoisRetard(notifDetails.getNombreMoisRetard());
            notificationRetardDeuxiemeNiveauDetails.setMontantBase(notifDetails.getMontantBase());
            notificationRetardDeuxiemeNiveauDetails.setMontantRetardPremierMois(notifDetails.getMontantRetardPremierMois());
            notificationRetardDeuxiemeNiveauDetails.setTrim(notifDetails.getTrimestre());
            notificationRetardDeuxiemeNiveauDetails.setMontantTotal(notifDetails.getMontantTotal());
            notificationRetardDeuxiemeNiveauDetails.setTypeEstimation(notifDetails.getTypeEstimation());
            notificationRetardDeuxiemeNiveauDetails.setMontantRetardAutreMois(notifDetails.getMontantRetardAutreMois());
            return 1;


    }

    @Override
    @Transactional
    public int deleteByNotificationRetardDeuxiemeNiveauCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.deleteByNotificationRetardDeuxiemeNiveauCode(code);
    }
    @Transactional
    public int deleteByCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.deleteByCode(code);
    }

    public int deleteByChiffreAffaireEstime(BigDecimal chiffreAffaireEstime) {
        return notificationDeuxiemeNiveauDetailsDao.deleteByChiffreAffaireEstime(chiffreAffaireEstime);
    }

    @Transactional
    public int deleteByTrimestreCode(int code) {
        return notificationDeuxiemeNiveauDetailsDao.deleteByTrimestreCode(code);
    }
    @Override
    public List<NotificationRetardDeuxiemeNiveauDetail> findAll() {
        return notificationDeuxiemeNiveauDetailsDao.findAll();
    }

}
