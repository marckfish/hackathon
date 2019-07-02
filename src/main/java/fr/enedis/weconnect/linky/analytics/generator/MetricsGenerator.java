package fr.enedis.weconnect.linky.analytics.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Options;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import fr.enedis.weconnect.linky.analytics.domain.metric.prod.MetricDeploiement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class MetricsGenerator {
    public static FakeValuesService fvs = new FakeValuesService(new Locale("fr-FR"), new RandomService());
    public static Faker faker = new Faker();

    public static List<MetricDeploiement> generateMetricDeploiement(int componentNumber) {
        List<MetricDeploiement> metrics = new ArrayList<>();

        IntStream.range(1, componentNumber).forEach(count -> {
                    MetricDeploiement metric = new MetricDeploiement();
                    metric.setComponentName(fvs.bothify("Component" + count +"_??"));
                    metric.setStatus(faker.options().option(Status.class));
                    metrics.add(metric);
                }
        );
        return metrics;
    }
}
