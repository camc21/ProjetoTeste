package br.com.carlos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ProjetoTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
		
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
//		String result = bCryptPasswordEncoder.encode("admin123");
//		System.out.println("My hash " + result);
	}

}
