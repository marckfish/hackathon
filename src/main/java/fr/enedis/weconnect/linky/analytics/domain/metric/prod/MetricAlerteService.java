package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import lombok.Data;

import java.util.List;

@Data
public class MetricAlerteService extends Metric {
    private String serviceName;
    private Status status;
    private List<Echec> echecs;
}
