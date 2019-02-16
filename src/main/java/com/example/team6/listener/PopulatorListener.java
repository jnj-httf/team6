package com.example.team6.listener;

import com.example.team6.model.Cidade;
import com.example.team6.repository.CidadeRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.transaction.annotation.Transactional;

@Log
public class PopulatorListener implements ApplicationListener<ApplicationReadyEvent>
{
    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event)
    {
        log.info("Starting " + this.getClass().getSimpleName() + " script");

        Cidade cidade = Cidade.builder()
            .coCep("123456")
            .codMunic("1234")
            .build();

        cidadeRepository.save(cidade);

        log.info("Ending " + this.getClass().getSimpleName() + " script");
    }
}
