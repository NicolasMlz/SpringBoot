package br.com.cod3r.exerciciossb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciciosSbApplication {
	
	//Iniciar um servidor possivel de ser acessado atraves de uma url
	//Sempre sera desse jeito com o spring boot
	public static void main(String[] args) {
		SpringApplication.run(ExerciciosSbApplication.class, args);
	}

}
