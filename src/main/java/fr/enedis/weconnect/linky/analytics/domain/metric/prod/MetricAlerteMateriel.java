package fr.enedis.weconnect.linky.analytics.domain.metric.prod;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import lombok.Data;

@Data
public class MetricAlerteMateriel extends Metric {
    private String TypeMateriel;
    private String rate;
}
