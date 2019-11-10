package in.aa.sauce.monitor.magnificentmonitor.metrics;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MagnificientMetrics {

    private int successCount = 0;
    private int failureCount = 0;
    private LocalDateTime lastUpTime;

    public LocalDateTime getLastUpTime() {
        return lastUpTime;
    }

    public void resetStats() {
        failureCount = 0;
        successCount = 0;
    }

    public int getFailureRate() {
        int totalStats = successCount + failureCount;
        if (totalStats == 0) {
            return 0;
        }
        return failureCount * 100 / totalStats;
    }

    public void notifySuccess() {
        successCount++;
        lastUpTime = LocalDateTime.now();
    }

    public void notifyFailure() {
        failureCount++;
    }

}
