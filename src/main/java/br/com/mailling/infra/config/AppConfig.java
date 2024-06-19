package br.com.mailling.infra.config;

import br.com.mailling.application.mappers.CondoMapper;
import br.com.mailling.application.service.CondoApplicationService;
import br.com.mailling.domain.repository.CondoRepository;
import br.com.mailling.domain.service.CondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private CondoRepository condoRepository;

    @Bean
    public CondoService condoService() {
        return new CondoService(condoRepository);
    }

    @Bean
    public CondoApplicationService condoApplicationService(CondoService condoService){
        return new CondoApplicationService(condoService, CondoMapper.INSTANCE);
    }
}
