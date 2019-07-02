package fr.enedis.weconnect.linky.analytics.job;

import fr.enedis.weconnect.linky.analytics.generator.MetricsGenerator;
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
        //this.template.convertAndSend("/analytics/at", new Message("Toto", "Titi"));
        this.template.convertAndSend("/analytics/deploiment", MetricsGenerator.generateMetricDeploiement(10));
        //this.template.convertAndSend("/analytics/prod/alerte", "Hello");
        //this.template.convertAndSend("/analytics/prod/serveur", "Hello");
        //his.template.convertAndSend("/analytics/prod/concentrateur", "Hello");
    }
}
