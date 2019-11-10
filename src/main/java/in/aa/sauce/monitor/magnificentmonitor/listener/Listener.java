package in.aa.sauce.monitor.magnificentmonitor.listener;

public interface Listener<T> {
    void onSuccess(T body);

    void onError(Exception ex);
}