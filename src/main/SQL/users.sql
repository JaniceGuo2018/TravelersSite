create table users
(username varchar(255),
password varchar(255),
firstName varchar(255),
lastName varchar(255),
avatar varchar(255),
adminCode varchar(255),
email varchar(255),
intro text,
userid int
);

insert into users values ('Alice','123', 'Alice', 'Buckler',
'https://images.unsplash.com/photo-1534436828370-d7b0bd2a2360?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=d47c600fdf37599d4c865d2845b63838&auto=format&fit=crop&w=500&q=60',
'123',
'Alice12@gmail.com',
'I like hiking and fishing. I have been to a couple of places like Rocky Mount and Niagra Falls. I love sharing my travel tips with people!',478);


insert into users values ('John','123', 'John', 'Adam',
'https://images.unsplash.com/photo-1534413602980-2d55ba73a68f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0aca95693dcdf1a6d21ee5d88c3225c4&auto=format&fit=crop&w=500&q=60',
'123',
'JohnA@gmail.com',
'I like traveling alone. Walking and biking are my favorite transportations!',399);