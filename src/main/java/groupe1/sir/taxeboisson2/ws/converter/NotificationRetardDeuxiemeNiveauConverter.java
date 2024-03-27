package groupe1.sir.taxeboisson2.ws.converter;

import groupe1.sir.taxeboisson2.bean.notification.NotificationRetardDeuxiemeNiveau;
import groupe1.sir.taxeboisson2.ws.Dto.NotificationRetardDeuxiemeNiveauDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationRetardDeuxiemeNiveauConverter {
    @Autowired
    private RedevableConverter redevableConverter;
    @Autowired
    private TrimestreConverter trimestreConverter;
    @Autowired
    private LocaleConverter localeConverter;
    public NotificationRetardDeuxiemeNiveau toBean(NotificationRetardDeuxiemeNiveauDto dto ){
        if(dto == null){
            return null ;
        }else {
            NotificationRetardDeuxiemeNiveau bean = new NotificationRetardDeuxiemeNiveau();
            bean.setCode(dto.getCode());
            bean.setAnnee(dto.getAnnee());
        if (dto.getTrimestre() != null) {
        bean.setTrim(trimestreConverter.toBean(dto.getTrimestre()));
        }
        if (dto.getLocale() != null) {
        bean.setLocale(localeConverter.toBean(dto.getLocale()));
        }
        if (dto.getRedevable() != null) {
        bean.setRedevable(redevableConverter.toBean(dto.getRedevable()));
        }
        return bean ;
    }
    }
    public NotificationRetardDeuxiemeNiveauDto toDto(NotificationRetardDeuxiemeNiveau bean ){
        if(bean == null){
            return null ;
        }
        NotificationRetardDeuxiemeNiveauDto dto = new NotificationRetardDeuxiemeNiveauDto();
            dto.setCode(bean.getCode());
            dto.setAnnee(bean.getAnnee());
        if(bean.getTrim() != null) {
            dto.setTrimestre(trimestreConverter.toDto(bean.getTrim()));
        }
        if(bean.getLocale() != null) {
            dto.setLocale(localeConverter.toDto(bean.getLocale()));
        }
        if(bean.getRedevable() != null) {
            dto.setRedevable(redevableConverter.toDto(bean.getRedevable()));
        }
        return dto;
    }
    public List<NotificationRetardDeuxiemeNiveau> toBeans(List<NotificationRetardDeuxiemeNiveauDto> dtos){
        if(dtos == null){return null ;}
        List<NotificationRetardDeuxiemeNiveau> beans = new ArrayList<NotificationRetardDeuxiemeNiveau>();
        for (NotificationRetardDeuxiemeNiveauDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }
    public List<NotificationRetardDeuxiemeNiveauDto> toDtos(List<NotificationRetardDeuxiemeNiveau> beans){
        if(beans == null){return null ;}
        List<NotificationRetardDeuxiemeNiveauDto> dtos = new ArrayList<NotificationRetardDeuxiemeNiveauDto>();
        for (NotificationRetardDeuxiemeNiveau bean : beans) {
            dtos.add(toDto(bean));
        }
        return dtos;
    }
}
