package fr.enedis.weconnect.linky.analytics.domain.metric.at;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import lombok.Data;

import java.util.List;

@Data
public class MetricListAt extends Metric {
    private String CampagneName;
    private List<Scenario> scenarios;
}
