package groupe1.sir.taxeboisson2.ws.Dto;

public class NotificationRetardDeuxiemeNiveauDto {

    private int annee;
    private int code;
    private TrimestreDto trimestre;
    private LocaleDto locale;
    private RedevableDto redevable;

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

    public TrimestreDto getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(TrimestreDto trimestre) {
        this.trimestre = trimestre;
    }

    public LocaleDto getLocale() {
        return locale;
    }

    public void setLocale(LocaleDto locale) {
        this.locale = locale;
    }

    public RedevableDto getRedevable() {
        return redevable;
    }

    public void setRedevable(RedevableDto redevable) {
        this.redevable = redevable;
    }
}
