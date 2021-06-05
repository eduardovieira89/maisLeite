package com.leiteria;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.model.Raca;
import com.leiteria.model.Usuario;
import com.leiteria.repository.AnimalRepository;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.RacaRepository;
import com.leiteria.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalRepositoryTest {
	
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	RacaRepository racaRepository;
	@Autowired
	PropriedadeRepository propriedadeRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void createShoulPersistData() {
		Usuario user = new Usuario("João", "joao@leite.com", "123456");
		usuarioRepository.save(user);
		
		Propriedade propriedade = new Propriedade("Prop teste", "loc teste", "mun teste", user);
		propriedadeRepository.save(propriedade);
		
		Raca raca = new Raca("Nelore");
		racaRepository.save(raca);
		
		Animal animal = new Animal();
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
