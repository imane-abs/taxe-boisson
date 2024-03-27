package groupe1.sir.taxeboisson2.ws.Dto;

import java.math.BigDecimal;

public class NotificationRetardDeuxiemeNiveauDetailsDto {
    private TrimestreDto trim;//
    private int annee;//
    private int code;//
    private BigDecimal chiffreAffaireEstime;//
    private int nombreMoisRetard;//
    private BigDecimal montantBase;//
    private BigDecimal montantRetardPremierMois;//
    private BigDecimal montantRetardAutreMois;//
    private BigDecimal montantTotal;//
    private NotificationRetardDeuxiemeNiveauDto notificationRetardDeuxiemeNiveau;//
    private TypeEstimationDto typeEstimation;//

    public TrimestreDto getTrim() {
        return trim;
    }

    public void setTrim(TrimestreDto trim) {
        this.trim = trim;
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

    public int getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(int nombreMoisRetard) {
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

    public NotificationRetardDeuxiemeNiveauDto getNotificationRetardDeuxiemeNiveau() {
        return notificationRetardDeuxiemeNiveau;
    }

    public void setNotificationRetardDeuxiemeNiveau(NotificationRetardDeuxiemeNiveauDto notificationRetardDeuxiemeNiveau) {
        this.notificationRetardDeuxiemeNiveau = notificationRetardDeuxiemeNiveau;
    }

    public TypeEstimationDto getTypeEstimation() {
        return typeEstimation;
    }

    public void setTypeEstimation(TypeEstimationDto typeEstimation) {
        this.typeEstimation = typeEstimation;
    }
}
