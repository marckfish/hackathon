package fr.enedis.weconnect.linky.analytics.generator;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.*;

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
        metric.setAtCC1Ok(Integer.valueOf(faker.numerify("4##")).intValue());
        metric.setAtCC2Ok(Integer.valueOf(faker.numerify("2##")).intValue());
        metric.setAtCC2Ko(Integer.valueOf(faker.numerify("0##")).intValue());
        metric.setAtMaterialOk(Integer.valueOf(faker.numerify("1#")).intValue());
        metric.setAtMaterialKo(Integer.valueOf(faker.numerify("0#")).intValue());
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

    public static List<MetricAlerteInfra> generateMetricAlerteInfra(int sampleCount, int itemCount) {
        List<MetricAlerteInfra> metrics = new ArrayList<>();
        IntStream.range(1, sampleCount).forEach(count ->{
            MetricAlerteInfra metric = new MetricAlerteInfra();
            metric.setDateMetric(Instant.now());
            metric.setComponentName( faker.options().option("REF", "CORE", "BPEL", "OSB", "IGC", "IDSE", "IDS-ZI"));
            metric.setType(faker.options().option(MetricType.class));
            metric.setInstances(new ArrayList<>());
            IntStream.range(1, itemCount).forEach(item ->{
                Instance instance = new Instance();
                instance.setInstanceName(faker.bothify("Instance_?#?#"));
                instance.setStatus(faker.options().option(StatusProd.class));
                metric.getInstances().add(instance);
            });
            metrics.add(metric);
        });
        return metrics;
    }

    public static MetricAlerteMateriel generateMetricAlerteMateriel() {
        MetricAlerteMateriel metric = new MetricAlerteMateriel();
        metric.setDateMetric(Instant.now());
        metric.setRate(faker.numerify("##%"));
        metric.setTypeMateriel("K");
        return metric;
    }

    public static List<MetricAlerteService> generateMetricAlerteService() {
        List<MetricAlerteService> metrics = new ArrayList<>();

        MetricAlerteService metric1 = new MetricAlerteService();
        metric1.setDateMetric(Instant.now());
        metric1.setStatus(faker.options().option(Status.class));
        metric1.setServiceName("SMC01");
        metric1.setEchecs(new ArrayList<>());
        if (Status.ECHEC.equals(metric1.getStatus())){
            Echec echec16 = new Echec();
            echec16.setEchec("ECH006");
            echec16.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric1.getEchecs().add(echec16);
            Echec echec12 = new Echec();
            echec12.setEchec("ECH002");
            echec12.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric1.getEchecs().add(echec12);
            metrics.add(metric1);

        }


        MetricAlerteService metric27 = new MetricAlerteService();
        metric27.setDateMetric(Instant.now());
        metric27.setStatus(faker.options().option(Status.class));
        metric27.setServiceName("SMC27");
        metric27.setEchecs(new ArrayList<>());
        if (Status.ECHEC.equals(metric27.getStatus())){
            Echec echec276 = new Echec();
            echec276.setEchec("ECH006");
            echec276.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric27.getEchecs().add(echec276);
            Echec echec272 = new Echec();
            echec272.setEchec("ECH002");
            echec272.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric27.getEchecs().add(echec272);
            metrics.add(metric27);

        }


        MetricAlerteService metric9 = new MetricAlerteService();
        metric9.setDateMetric(Instant.now());
        metric9.setStatus(faker.options().option(Status.class));
        metric9.setServiceName("SMC09");
        metric9.setEchecs(new ArrayList<>());
        if (Status.ECHEC.equals(metric9.getStatus())){
            Echec echec96 = new Echec();
            echec96.setEchec("ECH006");
            echec96.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric9.getEchecs().add(echec96);
            Echec echec92 = new Echec();
            echec92.setEchec("ECH002");
            echec92.setCount(Integer.valueOf(faker.numerify("1#")).intValue());
            metric9.getEchecs().add(echec92);
            metrics.add(metric9);
        }
        return metrics;
    }
}
