package in.aa.sauce.monitor.magnificentmonitor.listener;

public interface Listener {
    void onSuccess(String body);

    void onError(Exception ex);
}