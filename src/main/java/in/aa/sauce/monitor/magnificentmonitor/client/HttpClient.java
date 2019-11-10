package in.aa.sauce.monitor.magnificentmonitor.client;

import in.aa.sauce.monitor.magnificentmonitor.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    private final String url;
    private final Listener listener;

    public HttpClient(@Value("${service.url}") String url, @Autowired Listener listener) {
        this.url = url;
        this.listener = listener;
    }

    public void init() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            listener.onSuccess(response.getBody());
        } catch (Exception e) {
            listener.onError(e);
        }
    }


}
