package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import fr.enedis.weconnect.linky.analytics.domain.metric.MetricType;
import lombok.Data;

@Data
public class MetricProd extends Metric {
    MetricType type;
}
