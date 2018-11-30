
/*
Er notað fyrir ubuntu
sudo -u postgres psql -d hbv -a -f insertSql.sql
*/

/*
*   Prófunar gögn
*   Hér þarf first að búa til notanda og bæta við notenda id fyrir öll userid þar sem á við.
*   Síðan þarf að búa til einn session, nota id fyrir þann session og setja inn fyrir öll session_id
*   síðan er hægt að nota þetta skjal til þessa að bæta við gögnum við viðeigandi töflur
*/

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/IODxDxX7oi4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Push up', 
    'rep', 
    10, 
    'Chest', 
    4, 
    1000
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/1fbU_MkV7NE" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Sit up', 
    'rep', 
    10, 
    'Abs', 
    4, 
    1001
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" he<iframe width="560" height="315" src="https://www.youtube.com/embed/ASdvN_XEl_c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'Plank', 
    'min', 
    1, 
    'Core',
    4, 
    1002
);

insert into exercise (info, name, rep_type, reps, type, userid, id) 
values (
    '<iframe width="560" height="315" src="https://www.youtube.com/embed/aclHkVaku9U" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
    'No weight squat', 
    'reps', 
    30, 
    'Legs',
    4,
    1003
);


insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-20 14:07:46.394',
    1000, 
    11, 
    90, 
    1007
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-22 14:07:46.394',
    1000, 
    13, 
    90, 
    1006
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-24 14:07:46.394',
    1000, 
    15, 
    90, 
    1005
);

insert into training (date, exercise_id, reps, session_id, id)
values (
    '2018-11-25 14:07:46.394',
    1000, 
    11, 
    90, 
    1004
);


select * from exercise;