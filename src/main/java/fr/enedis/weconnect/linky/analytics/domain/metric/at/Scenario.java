package fr.enedis.weconnect.linky.analytics.domain.metric.at;

import fr.enedis.weconnect.linky.analytics.domain.metric.Status;
import lombok.Data;

import java.time.Instant;

@Data
public class Scenario {
    private String name;
    private Status status;
    private Instant dateExecution;
}
