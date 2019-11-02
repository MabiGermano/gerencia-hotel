-- -----------------------------------------------------
-- Insert Endereço
-- -----------------------------------------------------

INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('R Torquato de Aquino', '15', '2562659', 'Peixinhos', 'Brasil', 'Olinda', '');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('Av tabatinga', '5', '9859867', 'Santa maria', 'Brasil', 'São Paulo', 'apto 9');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('R aderval costa', '98', '256418', 'Corrente', 'Brasil', 'Recife', '');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`) VALUES ('Av Gauchos', '24', '5256985', 'Chimarrão', 'Brasil', 'Santa catarina');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`) VALUES ('R Treze de outubro', '12', '8523647', 'São josé dos campos', 'Brasil', 'São paulo');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`) VALUES ('Av O erro', '56', '9845621', 'Penha', 'Brasil', 'Rio de Janeiro');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('R Barracão', '8', '9785956', 'São Gonçalo', 'Brasil', 'São paulo', 'apto 25');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('Av Governador onório', '52', '8527419', 'Vila madaloca', 'Brasil', 'São Paulo', '');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`, `complemento`) VALUES ('Av Marquês de olinda', '3', '9859748', 'Recife', 'Brasil', 'Recife', '6 Andar');
INSERT INTO `hosp3`.`endereco` (`rua`, `numero`, `cep`, `bairro`, `pais`, `cidade`) VALUES ('Av Santada e Santos', '856', '9586325', 'Casa forte', 'Brasil', 'Recife');

-- -----------------------------------------------------
-- Insert Quarto
-- -----------------------------------------------------

INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('150', '2', 'Simples', '1', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('200', '2', 'Suite', '5', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('150', '2', 'Simples', '2', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('300', '4', 'Suite', '3', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('200', '2', 'Suite', '4', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('300', '4', 'Suite', '6', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('150', '2', 'Simples', '7', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('300', '4', 'Suite', '8', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('200', '2', 'Suite', '9', '1');
INSERT INTO `hosp3`.`quarto` (`valor`, `quantidade_pessoas`, `tipo`, `numero`, `disponivel`) VALUES ('300', '4', 'Suite', '10', '1');


-- -----------------------------------------------------
-- Insert Consumo extra
-- -----------------------------------------------------

INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('1 hospede extra', '80');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('1 hospede extra', '80');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('chocolate ', '4.00');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('consumo de 4 águas', '12');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('Almoço do chefe', '30');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('Ceviche', '45');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('Chá de camomila', '6');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('1 hospede extra', '80');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('Salada', '14');
INSERT INTO `hosp3`.`consumo_extra` (`descricao`, `valor`) VALUES ('Salgadinho', '3');


-- -----------------------------------------------------
-- Insert Hospede
-- -----------------------------------------------------

INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('José Bezerra', '476.913.520-34', 'jose.bezerra@hotmail.com', '2', '985895895', 'rapunzel*');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Rapunzel', '533.996.080-39', 'rapunzel@hotmail.com', '6', '852678496', 'estrelasflutuantes');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Bocão', '865.839.170-17', 'bocao@gmail.com', '1', '741523986', 'falafala');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Marcos', '899.328.160-27', 'carrinho@gmail.com', '3', '42344423343', 'tacalepau');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Sabrina Spellman', '111.821.650-44', 'spellman@gmail.com', '9', '957699021', 'salem');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Kara denvers', '923.834.180-05', 'supergirl@gmail.com', '4', '851245863', 'al3xdenvers');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Nunguento Mais', '398.568.470-79', 'tatarde@hotmail.com', '5', '232343560', 'mizera');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Lampião', '792.409.730-95', 'lampiao@hotmail.com', '8', '828282823', 'cangaco');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Maria Bonita', '165.144.840-00', 'buritinha@hotmail.com', '10', '828956978', 'cangaceira');
INSERT INTO `hosp3`.`hospede` (`nome`, `cpf`, `email`, `endereco_id`, `telefone`, `palavra_passe`) VALUES ('Elsa', '165.144.840-00', 'elsa@gmail.com', '7', '978584978', 'lerigou');

-- -----------------------------------------------------
-- Insert Hospedagem
-- -----------------------------------------------------

INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('2', '7');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('4', '1');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('9', '10');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('1', '8');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('6', '6');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('5', '2');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('8', '3');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('10', '4');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('3', '9');
INSERT INTO `hosp3`.`hospedagem` (`hospede_id`, `quarto_id`) VALUES ('5', '5');

-- -----------------------------------------------------
-- Insert Funcionario
-- -----------------------------------------------------

INSERT INTO `hosp3`.`funcionario` (`nome`, `cpf`, `endereco_id`, `email`, `telefone`, `codigo`, `palavra_passe`) VALUES ('Ana rosa', '339.592.190-59', '5', 'anaRosa@gmail.com', '928286547', '25B', 'oxeoxe');
INSERT INTO `hosp3`.`funcionario` (`nome`, `cpf`, `endereco_id`, `email`, `telefone`, `codigo`, `palavra_passe`) VALUES ('Lucas Silva', '129.607.840-06', '2', 'lucas.silva@hotmail.com', '958626478', '77B', 'ukeuke');
INSERT INTO `hosp3`.`funcionario` (`nome`, `cpf`, `endereco_id`, `email`, `telefone`, `codigo`, `palavra_passe`) VALUES ('Papai noel', '726.334.960-40', '6', 'renas@gmail.com', '789456123', '21B', 'renas');
INSERT INTO `hosp3`.`funcionario` (`nome`, `cpf`, `endereco_id`, `email`, `telefone`, `codigo`, `palavra_passe`) VALUES ('Natasha Romanoff', '467.527.870-18', '1', 'blackWindow@gmail.com', '808051648', '01B', 'viuvaNegra');

-- -----------------------------------------------------
-- Insert Registro
-- -----------------------------------------------------


INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('1', '6', '925', '2', '4');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('0', '10', '600', '3', '1');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('1', '3', '400', '1', '2');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('0', '9', '700', '4', '3');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('1', '8', '300', '2', '7');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('0', '1', '280', '3', '6');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('1', '2', '400', '3', '8');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('0', '5', '650', '4', '5');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('1', '4', '480', '2', '10');
INSERT INTO `hosp3`.`registro` (`flag_ativo`, `consumo_id`, `pagamento`, `funcionario_id`, `hospedagem_id`) VALUES ('0', '7', '300', '1', '9');
