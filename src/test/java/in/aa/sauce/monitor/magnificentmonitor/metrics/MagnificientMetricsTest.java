package in.aa.sauce.monitor.magnificentmonitor.metrics;


import in.aa.sauce.monitor.magnificentmonitor.metrics.MagnificientMetrics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MagnificientMetricsTest {

    private MagnificientMetrics metrics;

    @Before
    public void init() {
        metrics = new MagnificientMetrics();
    }

    @Test
    public void testMetrics() {
        metrics.notifyFailure();
        metrics.notifySuccess();
        metrics.notifySuccess();
        metrics.notifySuccess();
        Assert.assertEquals(25, metrics.getFailureRate());
    }

    @Test
    public void testResetStats() {
        metrics.notifySuccess();
        metrics.notifySuccess();
        metrics.notifyFailure();
        metrics.resetStats();
        Assert.assertEquals(0, metrics.getFailureRate());
    }

}