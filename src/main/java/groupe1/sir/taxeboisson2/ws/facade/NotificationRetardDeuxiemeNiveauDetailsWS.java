package groupe1.sir.taxeboisson2.ws.facade;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson2.service.impl.notification.NotificationRetardDeuxiemeNiveauDetailsImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/NotificationRetardDeuxiemeNiveauDetails")
public class NotificationRetardDeuxiemeNiveauDetailsWS {
       private NotificationRetardDeuxiemeNiveauDetailsImpl notificationDeuxiemeNiveauDetails = new NotificationRetardDeuxiemeNiveauDetailsImpl();
       @GetMapping("/code/{code}")
       public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByTypeEstimationCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.findByTypeEstimationCode(code);
       }
       @GetMapping("/code/{code}")
       public NotificationRetardDeuxiemeNiveauDetail findByCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.findByCode(code);
       }
       @GetMapping("/NotificationRetardDeuxiemeNiveau/code/{code}")
       public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNotificationRetardDeuxiemeNiveauCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.findByNotificationRetardDeuxiemeNiveauCode(code);
       }
       @GetMapping("/nombreMoisRetard/{nombreMoisRetard}")
       public List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNombreMoisRetard(@PathVariable int nombreMoisRetard) {
              return notificationDeuxiemeNiveauDetails.findByNombreMoisRetard(nombreMoisRetard);
       }
       @DeleteMapping("/montantTotal/{montantTotal}")
       public int deleteByMontantTotal(@PathVariable long montantTotal) {
              return notificationDeuxiemeNiveauDetails.deleteByMontantTotal(montantTotal);
       }
       @PostMapping("")
       public int save(@RequestBody NotificationRetardDeuxiemeNiveauDetail notifDetails) {
              return notificationDeuxiemeNiveauDetails.save(notifDetails);
       }
       @PutMapping("")
       public int update(@RequestBody NotificationRetardDeuxiemeNiveauDetail notifDetails) {
              return notificationDeuxiemeNiveauDetails.update(notifDetails);
       }
       @DeleteMapping("/NotificationRetardDeuxiemeNiveau/code/{code}")
       public int deleteByNotificationRetardDeuxiemeNiveauCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.deleteByNotificationRetardDeuxiemeNiveauCode(code);
       }
       @DeleteMapping("/code/{code}")
       public int deleteByCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.deleteByCode(code);
       }
       @DeleteMapping("/Trimestre/code/{code}")
       public int deleteByTrimestreCode(@PathVariable int code) {
              return notificationDeuxiemeNiveauDetails.deleteByTrimestreCode(code);
       }
       @GetMapping("")
       public List<NotificationRetardDeuxiemeNiveauDetail> findAll() {
              return notificationDeuxiemeNiveauDetails.findAll();
       }
}
