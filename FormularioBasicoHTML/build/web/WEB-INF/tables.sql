/*
Desenvolva um formulário em HTML que contenham o cadastro de clientes que armazene em Banco de Dados  MYSQL: código , nome,  telefone e email. Em outra página em JSP que receba esses dados e  adicione os dados em banco de dados.
*/

create database faculdade;
create table cliente(
id int auto_increment primary key,
nome varchar(60)
);