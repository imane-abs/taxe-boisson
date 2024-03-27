package groupe1.sir.taxeboisson2.bean.notification;

import groupe1.sir.taxeboisson2.bean.Redevable;
import groupe1.sir.taxeboisson2.bean.adresse.Locale;
import groupe1.sir.taxeboisson2.bean.taxe.Trimestre;
import jakarta.persistence.*;

@Entity
public class NotificationRetardDeuxiemeNiveau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int code;
    @ManyToOne
    private Trimestre trimestre;
    @ManyToOne
    private Locale locale;
    @ManyToOne
    private Redevable redevable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Trimestre getTrim() {
        return trimestre;
    }

    public void setTrim(Trimestre trim) {
        this.trimestre = trim;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }
}