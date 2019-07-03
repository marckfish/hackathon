package fr.enedis.weconnect.linky.analytics.domain.metric.prod;


import fr.enedis.weconnect.linky.analytics.domain.metric.StatusProd;
import lombok.Data;

@Data
public class Instance {
    private String instanceName;
    private StatusProd status;
}
