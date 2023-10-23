select s.* from student as s;

select s.* from student as s where age > 10 and age < 20;

select s.name from student as s;

select s.name from student as s where name like '%s%';

select s.* from student as s where age < s.id;

select s.* from student as s order by age;