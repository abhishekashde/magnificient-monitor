package in.aa.sauce.monitor.magnificentmonitor.scheduler;

import in.aa.sauce.monitor.magnificentmonitor.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HeartbeatScheduler {

    @Autowired
    HttpClient httpClient;

    @Scheduled(fixedRateString = "${polling.interval}")
    public void poll() {
        httpClient.init();
    }

}
