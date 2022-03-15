create database projectjava;
use projectjava;
-- task 1 adding song
-- artist table
create table artist(
artistid bigint primary key auto_increment,
artistname char(20),
artistgender char(10)
);
alter table artist auto_increment=100;
insert into artist values(artistid,'sonu nigam','male');
select * from artist;
-- album table
create table album(
albumid bigint primary key auto_increment,
albumname char(20),
albumreleasedate date
);
alter table album auto_increment=1000;
insert into album values(albumid,'sonu nigam songs','2021-9-11');
select * from album;
-- gener table
create table gener(
generid bigint primary key auto_increment,
genername char(20)
);
alter table gener auto_increment=100000;
insert into gener values(generid,'Kal ho naa ho');
select * from gener;
-- song table
create table song(
songid bigint primary key auto_increment,
songname char(20),
songduration char(10),
artistid bigint,
albumid bigint,
generid bigint,
foreign key (artistid) references artist(artistid),
foreign key (albumid) references album(albumid),
foreign key (generid) references gener(generid)
);
alter table song auto_increment=1;
insert into song(songname,songduration,artistid,albumid,generid) values('Kal ho naa ho','5:20',100,1000,100000);
select * from song;
--  create view 
create view songdata
as
select
 s1.songname,songduration,atst.artistname,artistgender, ab.albumname,albumreleasedate,g.genername
from song s1 join artist atst on s1.artistid = atst.artistid
join album ab on s1.albumid=ab.albumid
join gener g on s1.generid=g.generid;
select * from songdata;


-- task 2  adding podcast
-- podcasttype table
create table podcasttype(
podcasttypeid bigint primary key auto_increment,
podcasttype char(20)
);
alter table podcasttype auto_increment=100;
insert into podcasttype(podcasttype) values("drama");
select * from podcasttype;
-- narator table
create table narator(
naratorid bigint primary key auto_increment,
naratorname char(20)
);
alter table narator auto_increment=1;
insert into narator(naratorname) values('valmiki');
select * from narator;
-- celebrety table
create table celebrety(
celebretyid bigint primary key auto_increment,
celebretyname char(20)
);
alter table celebrety auto_increment=100;
insert into celebrety(celebretyname) values('ram');
select * from celebrety;
-- podcastdetail table
create table podcastdetail(
podid bigint primary key auto_increment,
podcastname char(20),
podcasttypeid bigint,
naratorid bigint ,
celebretyid bigint,
foreign key (podcasttypeid) references podcasttype(podcasttypeid),
foreign key (naratorid) references narator(naratorid),
foreign key (celebretyid) references celebrety(celebretyid)
);
alter table podcastdetail auto_increment=1000;
insert into podcastdetail(podcastname,podcasttypeid,naratorid,celebretyid) values('Ramayan',100,1,100);
select * from podcastdetail;
-- podcastepisode table
create table podcastepisode(
podcastid bigint primary key auto_increment,
episodename char(20),
episodeno int,
episodeduration char(10),
uploadeddate date,
podid bigint,
foreign key (podid) references podcastdetail(podid)
);
alter table podcastepisode auto_increment=1100;
insert into podcastepisode(episodename,episodeno,episodeduration,uploadeddate,podid) values('episode1',1,'13.09','2020-03-31',1000);
select* from podcastepisode;
create view podcastdata
as
select
 p1.episodename,episodeno,episodeduration,uploadeddate,pod.podcastname,c1.celebretyname, n.naratorname,t1.podcasttype
from podcasttype t1 join podcastdetail pod on t1.podcasttypeid = pod.podcasttypeid
join narator n on n.naratorid=pod.naratorid
join celebrety c1 on c1.celebretyid=pod.celebretyid
join podcastepisode p1 on p1.podid=pod.podid;
select* from podcastdata;

-- task3  creating a playlist
create table playlist(
playlistid bigint primary key auto_increment,
playlistname char(20)
);
alter table playlist auto_increment=10;
insert into playlist(playlistname)values('my song');
select* from playlist;

drop table playlist;
drop table playlistcontent;
create table playlistcontent(
content_id int primary key auto_increment,
contentduration char(30),
playlistid bigint,
trackid bigint,
foreign key (playlistid) references playlist(playlistid)
);
select * from playlistcontent;
insert into playlistcontent(contentduration,playlistid,trackid) values('20:0',10,1100);




create view playlistdata as
select p.playlistname , pl.contentduration ,
s.songname , s.songduration , pe.episodename , pe.episodeduration
from playlist p join playlistcontent pl on p.playlistid=pl.playlistid
left outer join song s on s.songid=pl.trackid
left outer join podcastepisode pe on pe.podcastid=pl.trackid;
select* from playlistdata;
