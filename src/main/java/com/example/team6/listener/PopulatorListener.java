package com.example.team6.listener;

import com.example.team6.pojo.CidadeWrapper;
import com.example.team6.repository.CidadeRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Log
@Component
public class PopulatorListener implements ApplicationListener<ApplicationReadyEvent>
{
    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event)
    {
        log.info("Starting " + this.getClass().getSimpleName() + " script");

        for (int i = 1; i <= 1885; i++)
        {
            RestTemplate restTemplate = new RestTemplate();
            CidadeWrapper entity = restTemplate
                .getForObject("https://api-ldc-hackathon.herokuapp.com/api/ubs/" + i, CidadeWrapper.class);
            log.info("Request: " + i);

            cidadeRepository.saveAll(entity.getRecords());
        }

        log.info("Ending " + this.getClass().getSimpleName() + " script");
    }
}
