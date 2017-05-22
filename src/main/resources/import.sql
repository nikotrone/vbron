CREATE TABLE task (
  id          INTEGER PRIMARY KEY,
  description VARCHAR(64) NOT NULL,
  completed   BIT NOT NULL);

insert into task(description, completed) values ('B1', '1');
insert into task(description, completed) values ('B2', '0');