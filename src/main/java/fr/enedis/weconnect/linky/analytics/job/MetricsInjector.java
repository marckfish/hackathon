package fr.enedis.weconnect.linky.analytics.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MetricsInjector {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(cron = "0/10 * * * * ?")
    protected void schedule() {
        System.out.println("je passe là");
        this.template.convertAndSend("/analytics/at", new Message("Toto", "Titi"));
        this.template.convertAndSend("/analytics/deploiment", "Hello");
        this.template.convertAndSend("/analytics/prod/alerte", "Hello");
        this.template.convertAndSend("/analytics/prod/serveur", "Hello");
        this.template.convertAndSend("/analytics/prod/concentrateur", "Hello");
    }
}
