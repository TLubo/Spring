insert into library (id, name) values (1, 'Pierwsza biblioteka');
insert into library (id, name) values (2, 'Miejska biblioteka');

insert into book (id, title, library_id) values (1, 'Pierwsza książka', 1);
insert into book (id, title, library_id) values (2, 'Druga książka', 2);
insert into book (id, title, library_id) values (3, 'Trzecia książka', 2);
insert into book (id, title, library_id) values (4, 'Czwarta książka', 2);
insert into book (id, title, library_id) values (5, 'Piąta książka', 1);

insert into author (id, first_name, last_name) values (1, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (2, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (3, 'Adam', 'Nowak');
insert into author (id, first_name, last_name) values (4, 'Jan', 'Nowakowski');
insert into author (id, first_name, last_name) values (5, 'Anna', 'Nowakowska');

insert into book_author(book_id, author_id) values (1, 5);
insert into book_author(book_id, author_id) values (2, 4);
insert into book_author(book_id, author_id) values (3, 3);
insert into book_author(book_id, author_id) values (4, 2);
insert into book_author(book_id, author_id) values (5, 1);