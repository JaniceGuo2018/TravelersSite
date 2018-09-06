

select  userid, siteid, rating from site into outfile 'd:/bigdata/hadoop/test/data.csv' 
fields terminated by ',' optionally enclosed by '"' lines terminated by '\n';