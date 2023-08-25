package com.leiteria;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.leiteria.model.Animais;
import com.leiteria.model.Propriedades;
import com.leiteria.model.Racas;
import com.leiteria.model.Usuarios;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.RacaRepository;
import com.leiteria.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalRepositoryTest {
	
	@Autowired
	AnimaisRepository animalRepository;
	@Autowired
	RacaRepository racaRepository;
	@Autowired
	PropriedadeRepository propriedadeRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void createShoulPersistData() {
		Usuarios user = new Usuarios(0,"João", "joao@leite.com", "123456", null, null, null);
		usuarioRepository.save(user);
		
		Propriedades propriedade = new Propriedades("Prop teste", "loc teste", "mun teste", user);
		propriedadeRepository.save(propriedade);
		
		Racas raca = new Racas("Nelore");
		racaRepository.save(raca);
		
		Animais animal = new Animais();
		animal.setNome("Vaca teste");
		//animal.setBrinco(15);
		animal.setDataNasc(LocalDate.now());
		animal.setRegistro(2334);
		//animal.setSexo('f');
		//animal.setPropriedade(propriedade);
		animal.setRaca(raca);
		animalRepository.save(animal);
		
		Assertions.assertThat(animal.getId()).isNotNull();
		Assertions.assertThat(animal.getNome()).isEqualTo("Vaca teste");
		Assertions.assertThat(animal.getBrinco()).isNotNull();
		Assertions.assertThat(animal.getSexo()).isNotNull();
		Assertions.assertThat(animal.getSexo()).isNotEqualTo("");
		System.out.println("Brinco animal: " + animal.getBrinco());
		System.out.println("Sexo animal: " + animal.getSexo());
		
	}

}
