package in.aa.sauce.monitor.magnificentmonitor.listener;

import in.aa.sauce.monitor.magnificentmonitor.metrics.MagnificientMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthStatusListener implements Listener {

    @Autowired
    private MagnificientMetrics magnificientMetrics;

    @Override
    public void onSuccess(Object body) {
        magnificientMetrics.notifySuccess();
    }

    @Override
    public void onError(Exception ex) {
        magnificientMetrics.notifyFailure();
    }


}
