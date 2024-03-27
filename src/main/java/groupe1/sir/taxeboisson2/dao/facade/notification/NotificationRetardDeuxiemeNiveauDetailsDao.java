package groupe1.sir.taxeboisson2.dao.facade.notification;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson.service.impl.notification.NotificationRetardDeuxiemeNiveauDetailsImpl;
import groupe1.sir.taxeboisson2.service.impl.notification.NotificationRetardDeuxiemeNiveauDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface NotificationRetardDeuxiemeNiveauDetailsDao extends JpaRepository<NotificationRetardDeuxiemeNiveauDetail, Long> {
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByTypeEstimationCode(int code);
           NotificationRetardDeuxiemeNiveauDetail findByCode(int code);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNotificationRetardDeuxiemeNiveauCode(int code);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByNombreMoisRetard(int nombreMoisRetard);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByAnnee(int annee);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByMontantTotal(long montantTotal);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByChiffreAffaireEstime (BigDecimal chiffreAffaireEstime);
           List<NotificationRetardDeuxiemeNiveauDetailsImpl> findByTrimestreCode (int code);
           int deleteByMontantTotal(long montantTotal);
           int deleteByAnnee(int annee);
           int deleteByNotificationRetardDeuxiemeNiveauCode(int code);
           int deleteByNombreMoisRetard(int nombreMoisRetard);
           int deleteByTypeEstimationCode(int code);
           int deleteByCode(int code);
           int deleteByChiffreAffaireEstime (BigDecimal chiffreAffaireEstime);
           int deleteByTrimestreCode (int code);
}
