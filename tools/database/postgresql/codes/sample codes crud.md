

CREATE TABLE clientes ( 
	id SERIAL PRIMARY KEY, 
	nome VARCHAR(100), 
	email VARCHAR(100), 
	idade INT 
);              

Cria tabela


Para inserir dados:

INSERT INTO clientes (nome, email, idade)
VALUES ('Ana Silva', 'ana@email.com', 28);

INSERT INTO clientes (nome, email, idade)
VALUES ('Carlos Souza', 'carlos@email.com', 35);



Para ler os dados:

SELECT * FROM clientes;
(o asterisco serve para dizer todas as colunas)

para filtrar;

SELECT nome, email FROM clientes WHERE idade > 30;


Para atualizar: 

UPDATE clientes 
SET idade = 29 
WHERE nome = 'Ana Silva';


Para deletar:

DELETE FROM clientes
WHERE id = 2;