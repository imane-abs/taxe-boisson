package groupe1.sir.taxeboisson2.ws.facade;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;
import groupe1.sir.taxeboisson2.service.impl.notification.NotificationRetardDeuxiemeNiveauImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/NotificationRetardDeuxiemeNiveau")
public class NotificationRetardDeuxiemeNiveauWS {
         private NotificationRetardDeuxiemeNiveauImpl notificationRetardDeuxiemeNiveau ;

    @GetMapping("/code/{code}")
    public NotificationRetardDeuxiemeNiveau findByCode(@PathVariable int code) {
        return notificationRetardDeuxiemeNiveau.findByCode(code);
    }
    @GetMapping("/cin/{cin}")
    public List<NotificationRetardDeuxiemeNiveau> findByRedevableCin(@PathVariable String cin) {
        return notificationRetardDeuxiemeNiveau.findByRedevableCin(cin);
    }
    @GetMapping("/libelle/{libelle}")
    public List<NotificationRetardDeuxiemeNiveau> findByLocaleLibelle(@PathVariable String libelle) {
        return notificationRetardDeuxiemeNiveau.findByLocaleLibelle(libelle);
    }
    @GetMapping("/Trimestre/code/{code}")
    public List<NotificationRetardDeuxiemeNiveau> findByTrimestreCode(@PathVariable int code) {
        return notificationRetardDeuxiemeNiveau.findByTrimestreCode(code);
    }
    @GetMapping("/annee/{annee}/Trimestre/code/{trimCode}")
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndTrimestreCode(@PathVariable int annee, @PathVariable int trimCode) {
        return notificationRetardDeuxiemeNiveau.findByAnneeAndTrimestreCode(annee, trimCode);
    }
    @GetMapping("/annee/{annee}/Locale/libelle/{libelle}")
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndLocaleLibelle(@PathVariable int annee,@PathVariable String libelle) {
        return notificationRetardDeuxiemeNiveau.findByAnneeAndLocaleLibelle(annee, libelle);
    }
    @GetMapping("annee/{annee}/Redevable/cin/{cin}")
    public List<NotificationRetardDeuxiemeNiveau> findByAnneeAndRedevableCin(@PathVariable int annee,@PathVariable String cin) {
        return notificationRetardDeuxiemeNiveau.findByAnneeAndRedevableCin(annee, cin);
    }

    @DeleteMapping("annee/{annee}/Locale/libelle/{libelle}")
    public int deleteByAnneeAndLocaleLibelle(@PathVariable int annee,@PathVariable String libelle) {
        return notificationRetardDeuxiemeNiveau.deleteByAnneeAndLocaleLibelle(annee, libelle);
    }

    @DeleteMapping("annee/{annee}/Trimestre/code/{trimCode}")
    public int deleteByAnneeAndTrimestreCode(@PathVariable int annee, @PathVariable int trimCode) {
        return notificationRetardDeuxiemeNiveau.deleteByAnneeAndTrimestreCode(annee, trimCode);
    }

    @DeleteMapping("/Annee/{Annee}")
    public int deleteByAnnee(@PathVariable int annee) {
        return notificationRetardDeuxiemeNiveau.deleteByAnnee(annee);
    }

    @DeleteMapping("/Redevable/cin/{cin}")
    public int deleteByRedevableCin(@PathVariable String cin) {
        return notificationRetardDeuxiemeNiveau.deleteByRedevableCin(cin);
    }

    @DeleteMapping("/Locale/cin/{cin}")
    public int deleteByLocaleLibelle(@PathVariable String libelle) {
        return notificationRetardDeuxiemeNiveau.deleteByLocaleLibelle(libelle);
    }
    @PostMapping("")
    public int save(@RequestBody NotificationRetardDeuxiemeNiveau notif) {
        return notificationRetardDeuxiemeNiveau.save(notif);
    }
    @PutMapping("")
    public int update(@RequestBody NotificationRetardDeuxiemeNiveau notif) {
        return notificationRetardDeuxiemeNiveau.update(notif);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable int code) {
        return notificationRetardDeuxiemeNiveau.deleteByCode(code);
    }

    @DeleteMapping("/Trimestre/code/{code}")
    public int deleteByTrimestreCode(@PathVariable int code) {
        return notificationRetardDeuxiemeNiveau.deleteByTrimestreCode(code);
    }
    @GetMapping("")
    public List<NotificationRetardDeuxiemeNiveau> findAll() {
        return notificationRetardDeuxiemeNiveau.findAll();
    }
}
