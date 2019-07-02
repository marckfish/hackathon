package fr.enedis.weconnect.linky.analytics.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Options;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import fr.enedis.weconnect.linky.analytics.domain.metric.MetricType;
import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import fr.enedis.weconnect.linky.analytics.domain.metric.StatusProd;
import fr.enedis.weconnect.linky.analytics.domain.metric.at.MetricListAt;
import fr.enedis.weconnect.linky.analytics.domain.metric.at.MetricStatsAt;
import fr.enedis.weconnect.linky.analytics.domain.metric.at.Scenario;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteInfra;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteMateriel;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricAlerteService;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricDeploiement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class MetricsGenerator {
    public static FakeValuesService fvs = new FakeValuesService(new Locale("fr-FR"), new RandomService());
    public static Faker faker = new Faker();

    public static List<MetricDeploiement> generateMetricDeploiement(int sampleCount) {
        List<MetricDeploiement> metrics = new ArrayList<>();

        IntStream.range(1, sampleCount).forEach(count -> {
                    MetricDeploiement metric = new MetricDeploiement();
                    metric.setComponentName(fvs.bothify("Component" + count + "_??"));
                    metric.setStatus(faker.options().option(Status.class));
                    metric.setDateMetric(Instant.now());
                    metrics.add(metric);
                }
        );
        return metrics;
    }

    public static MetricStatsAt generateMetricStatsAt() {
        MetricStatsAt metric = new MetricStatsAt();
        metric.setDateMetric(Instant.now());
        metric.setAtCC1Ko(Integer.valueOf(faker.numerify("0##")).intValue());
        metric.setAtCC1Ok(Integer.valueOf(faker.numerify("9##")).intValue());
        metric.setAtCC2Ok(Integer.valueOf(faker.numerify("2##")).intValue());
        metric.setAtCC2Ko(Integer.valueOf(faker.numerify("0##")).intValue());
        return metric;
    }


    public static List<MetricListAt> generateMetricListAts(int sampleCount, int itemCount) {
        List<MetricListAt> metric = new ArrayList<>();

        IntStream.range(1, sampleCount).forEach(count -> {
            MetricListAt campagne = new MetricListAt();
            campagne.setDateMetric(Instant.now());
            String campagneName = "Campagne" + faker.options().option("SMC", "PIL", "SIL") + "##" + faker.options().option("CC1", "CC2");
            campagne.setCampagneName(faker.numerify(campagneName));
            campagne.setScenarios(new ArrayList<>());
            IntStream.range(1, itemCount).forEach(items -> {
                Scenario scenario = new Scenario();
                scenario.setDateExecution(Instant.now());
                scenario.setName(faker.numerify("ScenarioAt0##S##"));
                scenario.setStatus(faker.options().option(Status.class));
                campagne.getScenarios().add(scenario);
            });
            metric.add(campagne);
        });
        return metric;
    }

    public static MetricAlerteInfra generateMetricAlerteInfra() {
        MetricAlerteInfra metric = new MetricAlerteInfra();
        metric.setDateMetric(Instant.now());
        metric.setComponentName(faker.numerify("Component_?#?#"));
        metric.setInstanceName(faker.numerify("Instance_?#?#"));
        metric.setStatus(faker.options().option(StatusProd.class));
        metric.setType(faker.options().option(MetricType.class));
        return metric;
    }

    public static MetricAlerteMateriel generateMetricAlerteMateriel() {
        MetricAlerteMateriel metric = new MetricAlerteMateriel();
        metric.setDateMetric(Instant.now());
        metric.setRate(faker.numerify("##%"));
        metric.setTypeMateriel("K");
        return metric;
    }

    public static MetricAlerteService generateMetricAlerteService() {
        MetricAlerteService metric = new MetricAlerteService();
        metric.setDateMetric(Instant.now());
        metric.setServiceName(faker.options().option("SMC01", "SMC27", "SMC09"));
        metric.setEchec(faker.options().option("ECH042", "ECH002", "ECH006", "ECH004"));
        metric.setCount(Integer.valueOf(faker.numerify("0#")).intValue());
        return metric;
    }
}
