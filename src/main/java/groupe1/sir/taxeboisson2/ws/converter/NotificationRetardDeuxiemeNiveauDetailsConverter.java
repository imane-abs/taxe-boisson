package groupe1.sir.taxeboisson2.ws.converter;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveauDetail;
import groupe1.sir.taxeboisson2.ws.Dto.NotificationRetardDeuxiemeNiveauDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationRetardDeuxiemeNiveauDetailsConverter {
    @Autowired
    TrimestreConverter trimestreConverter;
    @Autowired
    NotificationRetardDeuxiemeNiveauConverter notificationRetardDeuxiemeNiveauConverter;
    @Autowired
    TypeEstimationConverter typeEstimationConverter;
    public NotificationRetardDeuxiemeNiveauDetail toBean(NotificationRetardDeuxiemeNiveauDetailsDto dto ){
        if(dto == null){
            return null ;
        }
        NotificationRetardDeuxiemeNiveauDetail bean = new NotificationRetardDeuxiemeNiveauDetail();
            bean.setCode(dto.getCode());
            bean.setAnnee(dto.getAnnee());
        if (dto.getTrim() != null) {
            bean.setTrim(trimestreConverter.toBean(dto.getTrim()));
        }
        if (dto.getChiffreAffaireEstime() != null) {
            bean.setChiffreAffaireEstime(dto.getChiffreAffaireEstime());
        }
        bean.setNombreMoisRetard(dto.getNombreMoisRetard());
        if (dto.getMontantBase() != null) {
            bean.setMontantBase(dto.getMontantBase());
        }
        if (dto.getMontantRetardPremierMois() != null) {
            bean.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
        }
        if (dto.getMontantRetardAutreMois() != null) {
            bean.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
        }
        if (dto.getMontantTotal() != null) {
            bean.setMontantTotal(dto.getMontantTotal());
        }
        if (dto.getTypeEstimation() != null) {
            bean.setTypeEstimation(typeEstimationConverter.toBean(dto.getTypeEstimation()));
        }
        if(dto.getNotificationRetardDeuxiemeNiveau() != null) {
            bean.setNotificationRetardDeuxiemeNiveau(notificationRetardDeuxiemeNiveauConverter.toBean(dto.getNotificationRetardDeuxiemeNiveau()));
        }
        return bean ;
    }
    public NotificationRetardDeuxiemeNiveauDetailsDto toDto(NotificationRetardDeuxiemeNiveauDetail bean ){
        if(bean == null){
            return null ;
        }
        NotificationRetardDeuxiemeNiveauDetailsDto dto = new NotificationRetardDeuxiemeNiveauDetailsDto();
        dto.setCode(bean.getCode());
        dto.setAnnee(bean.getAnnee());
        if(bean.getTrim() != null){
            dto.setTrim(trimestreConverter.toDto(bean.getTrim()));
        }
        if(bean.getChiffreAffaireEstime() != null){
            dto.setChiffreAffaireEstime(bean.getChiffreAffaireEstime());
        }
        dto.setNombreMoisRetard(bean.getNombreMoisRetard());
        if(bean.getMontantBase() != null){
            dto.setMontantBase(bean.getMontantBase());
        }
        if(bean.getMontantRetardPremierMois() != null){
            dto.setMontantRetardPremierMois(bean.getMontantRetardPremierMois());
        }
        if(bean.getMontantRetardAutreMois() != null) {
            dto.setMontantRetardAutreMois(bean.getMontantRetardAutreMois());
        }
        if(bean.getMontantTotal() != null) {
            dto.setMontantTotal(bean.getMontantTotal());
        }
        if(bean.getTypeEstimation() != null) {
            dto.setTypeEstimation(typeEstimationConverter.toDto(bean.getMontantTotal()));
        }
        if(bean.getNotificationRetardDeuxiemeNiveau() != null) {
            dto.setNotificationRetardDeuxiemeNiveau(notificationRetardDeuxiemeNiveauConverter.toDto(bean.getNotificationRetardDeuxiemeNiveau()));
        }
        return dto;
    }
    public List<NotificationRetardDeuxiemeNiveauDetail> toBeans(List<NotificationRetardDeuxiemeNiveauDetailsDto> dtos){
        if(dtos == null){return null ;}
        List<NotificationRetardDeuxiemeNiveauDetail> beans = new ArrayList<NotificationRetardDeuxiemeNiveauDetail>();
        for (NotificationRetardDeuxiemeNiveauDetailsDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }
    public List<NotificationRetardDeuxiemeNiveauDetailsDto> toDtos(List<NotificationRetardDeuxiemeNiveauDetail> beans){
        if(beans == null){return null ;}
        List<NotificationRetardDeuxiemeNiveauDetailsDto> dtos = new ArrayList<NotificationRetardDeuxiemeNiveauDetailsDto>();
        for (NotificationRetardDeuxiemeNiveauDetail bean : beans) {
            dtos.add(toDto(bean));
        }
        return dtos;
    }
}
