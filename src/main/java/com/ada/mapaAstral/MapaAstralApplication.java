package com.ada.mapaAstral;

import com.ada.mapaAstral.repository.MapaAstralRepository;
import com.ada.mapaAstral.repository.PessoaRepository;
import com.ada.mapaAstral.service.MapaAstralService;
import com.ada.mapaAstral.service.PessoaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapaAstralApplication implements CommandLineRunner {

	private final MapaAstralRepository mapaAstralRepository = new MapaAstralRepository();
	private final PessoaRepository pessoaRepository = new PessoaRepository();
	private final PessoaService pessoaService = new PessoaService(pessoaRepository);
	private final MapaAstralService mapaAstralService = new MapaAstralService(mapaAstralRepository, pessoaService);

	public static void main(String[] args) {
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
		SpringApplication.run(MapaAstralApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mapaAstralService.importar();
	}
}



