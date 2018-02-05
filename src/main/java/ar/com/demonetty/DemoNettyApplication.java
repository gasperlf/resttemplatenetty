package ar.com.demonetty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoNettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNettyApplication.class, args);
	}

	@Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder restTemplateBuilder){
	    Netty4ClientHttpRequestFactory netty4ClientHttpRequestFactory = new Netty4ClientHttpRequestFactory();
	    netty4ClientHttpRequestFactory.setConnectTimeout(120000);
	    netty4ClientHttpRequestFactory.setReadTimeout(120000);
	    netty4ClientHttpRequestFactory.afterPropertiesSet();
	    RestTemplate restTemplate = new RestTemplate(netty4ClientHttpRequestFactory);

	    return restTemplate;
    }
}
