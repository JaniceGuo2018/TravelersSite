create table site
(
siteid int,
name varchar(255),
price varchar(255),
image varchar(255),
rating float,
description text,
location varchar(255),
userid int,
username varchar(255),
cat varchar(255)
);

insert into site values (
64, 'Iceland', '89', 
'https://images.unsplash.com/photo-1534518182594-01b1f2d46115?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=4a0c4b7e13c50588755466e017091174&auto=format&fit=crop&w=500&q=60',
9, 'The northern light here has been called the most spectacular show on earth, and you can see it live in Iceland! These mysterious lights that dance across the night sky in the wintertime. With its proximity to the Arctic Circle, Iceland is one of the best places on earth to witness this incredible phenomenon.',
'Reykjavik' ,35,'Alice','Cities');

insert into site values (
null, 'Niagra Falls', '50', 
'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/3Falls_Niagara.jpg/220px-3Falls_Niagara.jpg',
8.5, 'With awe-inspiring scenery year-round, thrilling attractions, interactive exhibits, miles of hiking trails, and delectable dining options in a family-friendly environment, Niagara Falls State Park is an adventure-packed experience! No passport is needed to experience an unforgettable and breathtaking Niagara Falls vacation.',
'Niagara Falls State Park USA', 'Ben','Mountains');