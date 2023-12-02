package personal.bonnycasi.clientfrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class FrontendController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/")
    public String rootPath() {
        return "This is a test.";
    }

    @GetMapping("/test-connection")
    public String testConnection() {
        Application application = eurekaClient.getApplication("eureka-client");

        InstanceInfo instanceInfo = application.getInstances().get(0);

        String url = String.format(
                "http://%s:%d/something",
                instanceInfo.getIPAddr(),
                instanceInfo.getPort());

        System.out.println("URL is: " + url);

        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
