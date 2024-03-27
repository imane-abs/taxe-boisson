package groupe1.sir.taxeboisson2.service.facade.notification;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson2.service.impl.notification.NotificationRetardDeuxiemeNiveauDetailsImpl;

import java.util.List;

public interface NotificationDeuxiemeNiveauDetailsFacade {

    List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByTypeEstimationCode(int code);
    NotificationRetardDeuxiemeNiveauDetail findByCode(int code);
    List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNotificationRetardDeuxiemeNiveauCode(int code);
    List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNombreMoisRetard(int nombreMoisRetard);
    int deleteByMontantTotal(long montantTotal);
    int save(NotificationRetardDeuxiemeNiveauDetail notifDetails);
    int update(NotificationRetardDeuxiemeNiveauDetail notifDetails);
    int deleteByNotificationRetardDeuxiemeNiveauCode(int code);

    List<NotificationRetardDeuxiemeNiveauDetail> findAll();
}


