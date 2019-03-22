--join

create table client(
	id	varchar2(20)	primary key,
	password	varchar2(30)	not null,
	email	varchar2(100)	not null,
	name	varchar2(30)	not null,
	phone	varchar2(50)	not null,
	address	varchar2(200)	not null,
	gender	varchar2(10),
	birth	varchar2(20)
);

--------------------------------------------------------------
--travel_info
create table bd(
	boardnum		number			primary key,	--글번호
	id				varchar2(20)	not null,		--작성자 ID
	travelPlace		varchar2(100)	not null,
	content			varchar2(4000)	not null,		--글내용
	photo			varchar2(100),
	views			number			default 0,
	liked			number			default 0,
	inputdate		date			default	sysdate,--작성날짜
	map				varchar2(500),
	address			varchar2(500),
	foreign key(id) references client(id)
);

create sequence bd_seq start with 1 increment by 1;

--리플
create table re(
	rplynum		number	primary key,
	boardnum	number		not null,
	id			varchar(20)	not null,
	content		varchar(2000)	not null,
	inputdate	date	default sysdate,
	foreign key(boardnum) references bd(boardnum) on delete cascade 
);

create sequence re_seq;

--------------------------------------------------------------









