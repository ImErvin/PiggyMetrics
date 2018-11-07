package api;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@EnableEurekaClient

@ApplicationPath("/")
public class RestApplication extends Application {
}