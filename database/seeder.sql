USE spring_db;


# seed tags
insert into tags (name) values ('Tag A');
insert into tags (name) values ('Tag B');
insert into tags (name) values ('Tag C');
insert into tags (name) values ('Tag D');
insert into tags (name) values ('Tag E');


# seed ads
insert into ad (title, description) values ('Solarbreeze', 'Do you hear the people sing?
Singing a song of angry men?
It is the music of a people
Who will not be slaves again');
insert into ad (title, description) values ('Biodex', 'When the beating of your heart
Echoes the beating of the drums
There is a life about to start
When tomorrow comes');
insert into ad (title, description) values ('Stringtough', 'Will you join in our crusade?
Who will be strong and stand with me?
Beyond the barricade
Is there a world you long to see?
Then join in the fight
That will give you the right to be free');
insert into ad (title, description) values ('Bytecard', 'Do you hear the people sing?
Singing a song of angry men?
It is the music of a people
Who will not be slaves again');
insert into ad (title, description) values ('Stim', 'When the beating of your heart
Echoes the beating of the drums
There is a life about to start
When tomorrow comes');
insert into ad (title, description) values ('Rank', 'Will you give all you can give
So that our banner may advance
Some will fall and some will live
Will you stand up and take your chance?
The blood of the martyrs
Will water the meadows of France');
insert into ad (title, description) values ('Vagram', 'Do you hear the people sing?
Singing a song of angry men?
It is the music of a people
Who will not be slaves again');
insert into ad (title, description) values ('Y-find', 'When the beating of your heart
Echoes the beating of the drums
There is a life about to start
When tomorrow comes');
insert into ad (title, description) values ('It', 'eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices');
insert into ad (title, description) values ('Tresom', 'ultrices phasellus id sapien in sapien iaculis cphasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis');


# seed comments
insert into comments (content, ad_id) values
('Comment 1', 1),
('Comment 2', 1),
('Comment 3', 1),
('Comment 4', 2),
('Comment 5', 2),
('Comment 6', 2);

# seed ad_tag
insert into ad_tag (ad_id, tag_id) values
(1, 1),
(1, 2),
(2, 1),
(2, 2);