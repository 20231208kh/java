# 사용자가 아이디가 abc123, 비번이 asd123으로 회원가입 진행
insert into member values 
	("abc123","asd123","USER"),
    ("qwe123","qweqwe","USER");
    
insert into member value("admin","admin","ADMIN");
select * from member;

#사용자가 아이디가 qwe123, 비번이 qweqwe로 회원가입 진행

#cgv에서 영화 웡카를 관리자가 등록하려고 한다. 이때 해야하는 쿼리르 순서대로

#1. 폴킹, 티모시 살라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 charater에 추가
insert into `character`(ch_name,ch_birthday,ch_detail,ch_na_name) values
("폴킹","1997-03-28","폴킹","영국"),
("티모시 살라메","1997-03-28","티모시 살라메","영국"),
("칼라 레인","1997-03-28","칼라 레인","미국"),
("올리비아 콜맨","1997-03-28","올리비아 콜맨","영국"),
("톰 데이비스","1997-03-28","톰 데이비스","미국"),
("휴 그랜트","1997-03-28","휴 그랜트","미국"),
("셀리 호킨","1997-03-28","셀리 호킨","영국");

select * from `character`;

#2. 폴킹, 티모시 살라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 movie_person에 추가(1에서 추가한 정보 이용)


insert into movie_person(mp_role,mp_ch_num) values
("배우",8),
("배우",9),
("배우",10),
("배우",11),
("배우",12),
("배우",13),
("배우",14);
select * from movie_person;

#3. 영화 정보를 이용하여 영화를 등록(movie 테이블)
insert into movie(mo_title,mo_date,mo_content,mo_running,mo_ag_name) values
("웡카","2024-01-31","윌리웡카",120,"12세 이상 관람가");
select * from movie;
#4. 폴킹, 티모시 살라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 join 테이블에 추가(2,3에서 추가한 정보 이용), 배역을 모르면""
insert into `join`(jo_casting,jo_mo_num,jo_mp_num) values
("",1,8),
("웡카",1,9),
("누들",1,10),
("여배우",1,11),
("",1,12),
("움파룸파",1,13),
("",1,14);
select * from `join`;
#5. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 판타지, 코미디, 로맨스, 스릴러, 공포,멜로)
insert into genre values("액션"),("범죄"),("SF"),("드라마"),("판타지"),("코미디"),("로맨스"),("스릴러"),("공포"),("멜로");
SELECT * FROM GENRE;
#6. 모든 연령을 AGE 테이블에 추가(전체관람가, 12세 이상 관람가, 15세 이상 관람가, 청소년 관람불가, 제한관람가)
insert into age values
("전체관람가"),("12세 이상 관람가"),("15세 이상 관람가"),("청소년 관람불가"),("제한관람과");
#7. 모든 국가를 nation 테이블에 추가(한국, 미국,영국,일본,중국)
insert into `nation` values
("한국"),("미국"),("영국"),("일본"),("중국");
select * from nation;
#8. 트레일러 정보를 추가. 파일명은 임의로 정해서 추가, 트레일러3개 스틸컷4개
INSERT INTO MOVIE_FILE(mf_filename,mf_type,mf_mo_num) values
("abc.avi","트레일러1",1),("qwe.avi","트레일러2",1),("zxc.avi","트레일러3",1),
("abc.jpg","스틸컷1",1),("qwe.jpg","스틸컷2",1),("zxc.jpg","스틸컷3",1),("fgc.jpg","스틸컷4",1);
#9. 영화 제작에 영화와 제작 국가 정보를 추가
insert into `production_nation` values
(1,"영국",1);
select * from production_nation;
#10. 장르 포함에 영화와 장르를 추가
insert into genre_include values
(1,"판타지",1);

select*from genre_include;
select*from `character`;

