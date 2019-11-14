package com.api.mascotas;

import com.api.mascotas.model.Mascota;
import com.api.mascotas.repository.MascotaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotasApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(MascotaRepository mascotaRepository) {
		return (args) -> {
			mascotaRepository.save(new Mascota("croketa","gato",(long)14,"muy buena compañera"));
			mascotaRepository.save(new Mascota("rulo","gato",(long)4,"arisco pero muy cariñoso"));
		};
	}

}
