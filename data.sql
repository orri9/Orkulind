/*
Er notað fyrir ubuntu
sudo -u postgres psql -d hbv -a -f data.sql

From the psql prompt:
\i [full path]/data.sql
*/


insert into username (id, name, password)
values (
	1000,
	'notandi',
	'lykilord'
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/IODxDxX7oi4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Push up', 
    'rep', 
    10, 
    'Chest', 
    1000, 
    1000
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/1fbU_MkV7NE" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Sit up', 
    'rep', 
    10, 
    'Abs', 
    1000, 
    1001
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" he<iframe width="560" height="315" src="https://www.youtube.com/embed/ASdvN_XEl_c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Plank', 
    'min', 
    1, 
    'Core',
    1000, 
    1002
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/aclHkVaku9U" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'No weight squat', 
    'reps', 
    30, 
    'Legs',
    1000,
    1003
);

insert into session (id, name, type, userid)
values (
	1000,
	'My Favourite Session',
	'Favourite',
	1000
);

insert into session_exercises (sessions_id, exercises_id)
values (
	1000,
	1000
),
(
	1000,
	1001
),
(
	1000,
	1002
),
(
	1000,
	1003
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-20 10:05:46.394',
    1000, 
    11, 
    1000, 
    1007
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-22 14:07:46.394',
    1000, 
    13, 
    1000, 
    1006
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-24 12:12:46.394',
    1000, 
    15, 
    1000, 
    1005
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-25 18:17:46.394',
    1000, 
    11, 
    1000,
    1004
);
