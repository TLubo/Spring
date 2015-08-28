insert into book values (1, 'Pierwsza książka');
insert into book values (2, 'Druga książka');
insert into book values (3, 'Trzecia książka');

insert into author (id, first_name, last_name) values (7, 'Anna', 'Adamska');
insert into author (id, first_name, last_name) values (8, 'Magdalena', 'Jankowska');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Kowalski');

insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (2, 9);
insert into book_author(book_id, author_id) values (3, 9);