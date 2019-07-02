package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import lombok.Data;

@Data
public class MetricAlerteService extends Metric {
    private String serviceName;
    private String echec;
    private int count;
}
