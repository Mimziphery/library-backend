insert into category (name) values ( 'NOVEL' );
insert into category (name) values ( 'THRILER' );
insert into category (name) values ( 'HISTORY' );
insert into category (name) values ( 'FANTASY' );
insert into category (name) values ( 'BIOGRAPHY' );
insert into category (name) values ( 'CLASSICS' );
insert into category (name) values ( 'DRAMA' );


insert into countries (name, continent) values ('Macedonia', 'Europe') ;
insert into countries (name, continent) values ('Russia', 'Europe') ;
insert into countries (name, continent) values ('Netherlands', 'Europe') ;
insert into countries (name, continent) values ('United States', 'America') ;
insert into countries (name, continent) values ('United Kingdom', 'Europe') ;
insert into countries (name, continent) values ('Austria', 'Europe') ;

insert into Author(name, surname, country_id) values ( 'Stephen', 'King', 4);
insert into Author(name, surname, country_id) values ( 'Anton', 'Panov', 1);
insert into Author(name, surname, country_id) values ( 'Gorjan', 'Petrevski', 1);
insert into Author(name, surname, country_id) values ( 'Fyodor', 'Dostoevsky', 2);
insert into Author(name, surname, country_id) values ( 'Annie', 'Frank', 3);
insert into Author(name, surname, country_id) values ( 'William', 'Shakespeare ', 5);
insert into Author(name, surname, country_id) values ( 'Frank', 'Herbert ', 4);
insert into Author(name, surname, country_id) values ( 'Sigmund', 'Freud ', 6);

insert into Book(name, category_id, author_id, available_copies) values ( 'The Shinning', 2, 1, 3 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Pechalbari', 7, 2, 10 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Marta', 1, 3, 1 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Crime and Punishment', 1, 4, 2 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Dune', 4, 7, 1 );
insert into Book(name, category_id, author_id, available_copies) values ( 'The Diary of Annie Frank', 3, 5, 5 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Hamlet', 6, 6, 6 );
insert into Book(name, category_id, author_id, available_copies) values ( 'An Autobiographical Study', 5, 8, 4 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Macbeth', 6, 6, 6 );
insert into Book(name, category_id, author_id, available_copies) values ( 'The ego and the Id', 5, 8, 4 );

