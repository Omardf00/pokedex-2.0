use pokedexdb;

select * from pokemon;

insert into pokemon(name) values('Bulbasaur');
insert into pokemon(name) values('Ivysaur');
insert into pokemon(name) values('Venusaur');
insert into pokemon(name) values('Charmander');
insert into pokemon(name) values('Charmeleon');
insert into pokemon(name) values('Charizard');
insert into pokemon(name) values('Squirtle');
insert into pokemon(name) values('Wartortle');
insert into pokemon(name) values('Blastoise');

select * from pokemon_detail;

insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(1,'Semilla',6.9,0.7,'Monstruo Planta',87.5,12.5,'Pradera','Verde','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(2,'Semilla',13.0,1.0,'Monstruo Planta',87.5,12.5,'Pradera','Verde','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(3,'Semilla',100.0,2.0,'Monstruo Planta',87.5,12.5,'Pradera','Verde','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(4,'Lagartija',8.5,0.6,'Monstruo Dragón',87.5,12.5,'Montaña','Rojo','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(5,'Llama',19.0,1.1,'Monstruo Dragón',87.5,12.5,'Montaña','Rojo','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(6,'Llama',90.5,1.7,'Monstruo Dragón',87.5,12.5,'Montaña','Rojo','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(7,'Tortuguita',9.0,0.5,'Monstruo Agua',87.5,12.5,'Agua dulce','Azul','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(8,'Tortuga',22.5,1.0,'Monstruo Agua',87.5,12.5,'Agua dulce','Azul','Primera',null,null,null);
insert into pokemon_detail(num_pokedex,category,weight,height,egg_group,male,female,habitat,colour,generation,figure,fingerprint,scream) 
values(9,'Armazón',85.5,1.6,'Monstruo Agua',87.5,12.5,'Agua dulce','Azul','Primera',null,null,null);

select * from type;

insert into type(type) values('Agua'); /*1*/
insert into type(type) values('Bicho'); /*2*/
insert into type(type) values('Dragón'); /*3*/
insert into type(type) values('Eléctrico'); /*4*/
insert into type(type) values('Fantasma'); /*5*/
insert into type(type) values('Fuego'); /*6*/
insert into type(type) values('Hielo'); /*7*/
insert into type(type) values('Lucha'); /*8*/
insert into type(type) values('Normal'); /*9*/
insert into type(type) values('Planta'); /*10*/
insert into type(type) values('Psíquico'); /*11*/
insert into type(type) values('Roca'); /*12*/
insert into type(type) values('Tierra'); /*13*/
insert into type(type) values('Veneno'); /*14*/
insert into type(type) values('Volador'); /*15*/

select * from pokemon_type;

insert into pokemon_type(num_pokedex, id_type) values(1,10);
insert into pokemon_type(num_pokedex, id_type) values(1,14);
insert into pokemon_type(num_pokedex, id_type) values(2,10);
insert into pokemon_type(num_pokedex, id_type) values(2,14);
insert into pokemon_type(num_pokedex, id_type) values(3,10);
insert into pokemon_type(num_pokedex, id_type) values(3,14);
insert into pokemon_type(num_pokedex, id_type) values(4,6);
insert into pokemon_type(num_pokedex, id_type) values(5,6);
insert into pokemon_type(num_pokedex, id_type) values(6,6);
insert into pokemon_type(num_pokedex, id_type) values(6,15);
insert into pokemon_type(num_pokedex, id_type) values(7,1);
insert into pokemon_type(num_pokedex, id_type) values(8,1);
insert into pokemon_type(num_pokedex, id_type) values(9,1);

select * from evolution_form;

insert into evolution_form(name) values('Nivel');

select * from evolution_from;

insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,2,1);
insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,3,2);
insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,5,4);
insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,6,5);
insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,8,7);
insert into evolution_from(id_form,num_pokedex_evolutioned,num_pokedex_origin) values(1,9,8);
