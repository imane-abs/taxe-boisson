package groupe1.sir.taxeboisson2.bean.notification;

import groupe1.sir.taxeboisson2.bean.taxe.Trimestre;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class NotificationRetardDeuxiemeNiveauDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Trimestre trimestre;
    private int annee;
    private int code;
    private BigDecimal chiffreAffaireEstime;
    private double nombreMoisRetard;
    private BigDecimal montantBase;
    private BigDecimal montantRetardPremierMois;
    private BigDecimal montantRetardAutreMois;
    private BigDecimal montantTotal;
    @ManyToOne
    private NotificationRetardDeuxiemeNiveau notificationRetardDeuxiemeNiveau;
    @ManyToOne
    private TypeEstimation typeEstimation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BigDecimal getChiffreAffaireEstime() {
        return chiffreAffaireEstime;
    }

    public void setChiffreAffaireEstime(BigDecimal chiffreAffaireEstime) {
        this.chiffreAffaireEstime = chiffreAffaireEstime;
    }

    public double getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(double nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public BigDecimal getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(BigDecimal montantBase) {
        this.montantBase = montantBase;
    }

    public BigDecimal getMontantRetardPremierMois() {
        return montantRetardPremierMois;
    }

    public void setMontantRetardPremierMois(BigDecimal montantRetardPremierMois) {
        this.montantRetardPremierMois = montantRetardPremierMois;
    }

    public BigDecimal getMontantRetardAutreMois() {
        return montantRetardAutreMois;
    }

    public void setMontantRetardAutreMois(BigDecimal montantRetardAutreMois) {
        this.montantRetardAutreMois = montantRetardAutreMois;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public NotificationRetardDeuxiemeNiveau getNotificationRetardDeuxiemeNiveau() {
        return notificationRetardDeuxiemeNiveau;
    }

    public void setNotificationRetardDeuxiemeNiveau(NotificationRetardDeuxiemeNiveau notificationRetardDeuxiemeNiveau) {
        this.notificationRetardDeuxiemeNiveau = notificationRetardDeuxiemeNiveau;
    }

    public TypeEstimation getTypeEstimation() {
        return typeEstimation;
    }

    public void setTypeEstimation(TypeEstimation typeEstimation) {
        this.typeEstimation = typeEstimation;
    }

    public void setTrim(Trimestre trim) {
        this.trimestre = trim;
    }
}