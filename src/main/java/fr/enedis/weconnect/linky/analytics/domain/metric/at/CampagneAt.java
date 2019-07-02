package fr.enedis.weconnect.linky.analytics.domain.metric.at;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import lombok.Data;

import java.util.List;

@Data
public class CampagneAt extends Metric {
    private String name;
    private List<Scenario> scenarios;
}
