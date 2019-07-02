package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import fr.enedis.weconnect.linky.analytics.domain.metric.StatusProd;
import lombok.Data;

@Data
public class MetricAlerteInfra extends MetricProd {

    private String componentName;
    private String instanceName;
    private StatusProd status;
}
