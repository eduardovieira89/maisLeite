CREATE TABLE `raca` (
	`id_raca` int NOT NULL AUTO_INCREMENT,
	`descricao` varchar(50) NOT NULL,
	PRIMARY KEY (`id_raca`)
);

CREATE TABLE `propriedade` (
	`id_propriedade` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(60),
	`localidade` varchar(60),
	`municipio` varchar(60),
	`id_proprietario` bigint NOT NULL,
	PRIMARY KEY (`id_propriedade`)
);

CREATE TABLE `animal` (
	`id_animal` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(50),
	`brinco` int NOT NULL,
	`data_nasc` DATE NOT NULL,
	`registro` bigint NOT NULL,
	`sexo` char NOT NULL,
	`pai` varchar(60),
	`mae` varchar(60),
	`id_raca` int NOT NULL,
	`id_propriedade` bigint NOT NULL,
	`id_pai` bigint,
	`id_mae` bigint,
	PRIMARY KEY (`id_animal`)
);

CREATE TABLE `usuario` (
	`id_usuario` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(60) NOT NULL,
	`email` varchar(60) NOT NULL UNIQUE,
	`senha` varchar(60) NOT NULL,
	`chefe` bigint,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `regra` (
	`nome_regra` varchar(60) NOT NULL,
	PRIMARY KEY (`nome_regra`)
);

CREATE TABLE `usuario_regras` (
	`id_usuario` bigint NOT NULL,
	`id_regra` varchar(60) NOT NULL
);

ALTER TABLE `propriedade` ADD CONSTRAINT `propriedade_fk0` FOREIGN KEY (`id_proprietario`) REFERENCES `usuario`(`id_usuario`);

ALTER TABLE `animal` ADD CONSTRAINT `animal_fk0` FOREIGN KEY (`id_raca`) REFERENCES `raca`(`id_raca`);

ALTER TABLE `animal` ADD CONSTRAINT `animal_fk1` FOREIGN KEY (`id_propriedade`) REFERENCES `propriedade`(`id_propriedade`);

ALTER TABLE `animal` ADD CONSTRAINT `animal_fk2` FOREIGN KEY (`id_pai`) REFERENCES `animal`(`id_animal`);

ALTER TABLE `animal` ADD CONSTRAINT `animal_fk3` FOREIGN KEY (`id_mae`) REFERENCES `animal`(`id_animal`);

ALTER TABLE `usuario` ADD CONSTRAINT `usuario_fk0` FOREIGN KEY (`chefe`) REFERENCES `usuario`(`id_usuario`);

ALTER TABLE `usuario_regras` ADD CONSTRAINT `usuario_regras_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario`(`id_usuario`);

ALTER TABLE `usuario_regras` ADD CONSTRAINT `usuario_regras_fk1` FOREIGN KEY (`id_regra`) REFERENCES `regra`(`nome_regra`);


INSERT INTO `regra` (`nome_regra`) VALUES ('ROLE_ADMIN');
INSERT INTO `regra` (`nome_regra`) VALUES ('ROLE_FUNCIONARIO');
INSERT INTO `regra` (`nome_regra`) VALUES ('ROLE_PRODUTOR');