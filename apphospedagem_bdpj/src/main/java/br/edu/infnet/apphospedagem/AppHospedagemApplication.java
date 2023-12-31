package br.edu.infnet.apphospedagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppHospedagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppHospedagemApplication.class, args);
	}

}
