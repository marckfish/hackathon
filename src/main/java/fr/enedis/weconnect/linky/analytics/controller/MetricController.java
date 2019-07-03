package fr.enedis.weconnect.linky.analytics.controller;

import fr.enedis.weconnect.linky.analytics.domain.metric.at.MetricListAt;
import fr.enedis.weconnect.linky.analytics.domain.metric.at.MetricStatsAt;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteInfra;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteMateriel;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteService;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricDeploiement;
import fr.enedis.weconnect.linky.analytics.generator.MetricsGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricController {

    @GetMapping("/analytics/stat/at")
    public MetricStatsAt generateMetricStatsAt() {
        return MetricsGenerator.generateMetricStatsAt();
    }

    @GetMapping("/analytics/deploiment")
    public List<MetricDeploiement> generateMetricDeploiement() {
        return MetricsGenerator.generateMetricDeploiement(10);
    }

    @GetMapping("/analytics/prod/services")
    public List<MetricAlerteService> generateMetricAlerteService() {
        return MetricsGenerator.generateMetricAlerteService();
    }

    @GetMapping("/analytics/prod/server")
    public List<MetricAlerteInfra> generateMetricAlerteInfra() {
        return MetricsGenerator.generateMetricAlerteInfra(7, 5);
    }

    @GetMapping("/analytics/prod/k")
    public MetricAlerteMateriel generateMetricAlerteMateriel() {
        return MetricsGenerator.generateMetricAlerteMateriel();
    }

    @GetMapping("/analytics/ats")
    public List<MetricListAt> generateMetricListAts() {
        return MetricsGenerator.generateMetricListAts(10, 20);
    }

}
