package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import lombok.Data;

@Data
public class MetricAlerteInfra extends MetricProd {

    private String componentName;
    private String instanceName;
    private Status status;
}
