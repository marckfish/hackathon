package fr.enedis.weconnect.linky.analytics.job;

import fr.enedis.weconnect.linky.analytics.generator.MetricsGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MetricsInjector {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(cron = "0/10 * * * * ?")
    protected void scheduleDeploiement() {
        this.template.convertAndSend("/analytics/at", MetricsGenerator.generateMetricStatsAt());
        this.template.convertAndSend("/analytics/deploiment", MetricsGenerator.generateMetricDeploiement(10));
        this.template.convertAndSend("/analytics/prod/alerte", MetricsGenerator.generateMetricAlerteService());
        this.template.convertAndSend("/analytics/prod/serveur", MetricsGenerator.generateMetricAlerteInfra());
        this.template.convertAndSend("/analytics/prod/concentrateur", MetricsGenerator.generateMetricAlerteMateriel());
        this.template.convertAndSend("/analytics/liste/at", MetricsGenerator.generateMetricListAts(10, 20));
    }
}
