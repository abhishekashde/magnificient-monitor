package in.aa.sauce.monitor.magnificentmonitor.scheduler;

import in.aa.sauce.monitor.magnificentmonitor.metrics.MagnificientMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportScheduler {
    private Logger LOG = LoggerFactory.getLogger(ReportScheduler.class);

    @Autowired
    private MagnificientMetrics metrics;

    @Value("${threshold.error}")
    private int errorThreshold;

    @Value("${threshold.warn}")
    private int warnThreshold;

    @Value("${threshold.info}")
    private int infoThreshold;

    @Scheduled(fixedRateString = "${data.aggregation.interval}", initialDelayString = "${data.aggregation.interval}")
    public void display() {
        Integer failureRate = metrics.getFailureRate();
        long successRate = 100 - failureRate;
        if (failureRate > errorThreshold) {
            logError(metrics.getLastUpTime(), successRate);
        } else if (failureRate > warnThreshold) {
            LOG.warn("Service uptime : {} ", successRate);
        } else if (failureRate > infoThreshold) {
            LOG.warn("Service uptime : {} ", successRate);
        }
        LOG.debug("Service uptime : {} ", successRate);
        metrics.resetStats();
    }

    private void logError(LocalDateTime lastUpTime, long successRate) {
        if (lastUpTime != null && successRate == 0) {
            LOG.error("Service Unavailable. Last known uptime : {} ", lastUpTime);
        } else if (lastUpTime == null) {
            LOG.error("Service was never up.");
        } else {
            LOG.error("Service uptime : {} ", successRate);
        }
    }
}
