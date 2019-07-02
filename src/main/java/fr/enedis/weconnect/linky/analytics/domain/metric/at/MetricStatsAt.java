package fr.enedis.weconnect.linky.analytics.domain.metric.at;

import fr.enedis.weconnect.linky.analytics.domain.metric.Metric;
import lombok.Data;

@Data
public class MetricStatsAt extends Metric {
    private int atCC1Ok;
    private int atCC1Ko;
    private int atCC2Ok;
    private int atCC2Ko;
    private int atMaterialOk;
    private int atMaterialKo;
}
