package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import lombok.Data;

@Data
public class MetricDeploiement extends Metric {
    private String componentName;
    private Status status;
}
