use university;
# 컴퓨터 공학을 다니는 학생 정보 조회 (O)
select * 
from student
where st_major = '컴퓨터공학';

# 컴퓨터 공학을 다니는 1학년 학생 정보 조회 (O)
SELECT *
FROM STUDENT
WHERE ST_MAJOR = "컴퓨터공학" and st_grade=1;

# 컴퓨터공학 또는 화학 공학을 다니는 1학생 정보 조회 (O)
SELECT 
	*
FROM
	STUDENT
WHERE 
	(ST_MAJOR ="컴퓨터공학" or ST_MAJOR = "화학공학") and st_grade=1;
    
# 컴퓨터공학을 다니는 학생  수를 조회 (O)
SELECT ST_MAJOR AS "전공", COUNT(ST_MAJOR) AS "학생 수" FROM STUDENT WHERE ST_MAJOR="컴퓨터공학";
SELECT ST_MAJOR AS "전공", COUNT(*) AS "학생 수" FROM STUDENT GROUP BY ST_MAJOR HAVING ST_MAJOR="컴퓨터공학";
SELECT ST_MAJOR AS "전공", COUNT(ST_MAJOR) AS "학생 수" FROM STUDENT GROUP BY ST_MAJOR ORDER BY COUNT(ST_MAJOR) DESC;
SELECT ST_MAJOR AS "전공", COUNT(ST_MAJOR) AS "학생 수" FROM STUDENT GROUP BY ST_MAJOR ORDER BY COUNT(ST_MAJOR) ASC;

# 학생들이 등록된 학과를 조회 (O)
# DISTINCT 를 이용하여 중복제거 (X)
SELECT DISTINCT ST_MAJOR FROM STUDENT;

#학생들이 3명이상 등록된 학과들을 조회(0)
SELECT ST_MAJOR AS "전공", COUNT(*) AS "학생 수" FROM STUDENT GROUP BY ST_MAJOR HAVING COUNT(ST_MAJOR) >=3;


#컴퓨터 개론을 수강하는 학생 수를 조회(O)

SELECT LE_TITLE AS "강의", COUNT(*) AS "학생 수" FROM COURSE JOIN LECTURE ON CO_LE_NUM = LE_NUM WHERE CO_LE_NUM=1;

#각 강의별 수강하는 학생수를 조회, 강의명과 학생수를 조회
SELECT LE_TITLE AS "강의", COUNT(*) AS "학생 수" FROM COURSE JOIN LECTURE ON CO_LE_NUM = LE_NUM GROUP BY CO_LE_NUM 
																			ORDER BY COUNT(*) ASC;
                                                                            
#홍길동 학생이 수강하는 강의목록을 조회(O)
#LECTURE를 추가로 JOIN 하여 강의명까지 조회(X)
SELECT * FROM COURSE;
SELECT * FROM STUDENT;

SELECT ST_NAME AS "학생 이름", LE_TITLE AS "강의 명"
FROM COURSE 
JOIN 
	STUDENT ON CO_ST_NUM = ST_NUM
JOIN 
	LECTURE ON CO_LE_NUM = LE_NUM
WHERE ST_NAME ="홍길동"; 

#기계공학에 소속된 교수의 수
SELECT * FROM PROFESSOR;
SELECT PR_MAJOR AS "교수 전공", COUNT(*) AS "소속된 교수의 수" FROM PROFESSOR WHERE PR_MAJOR ="기계공학";
#김교수가 강의하는 강의명을 조회
SELECT * FROM LECTURE;

SELECT LE_TITLE AS "강의명", PR_NAME AS "강의 교수" FROM LECTURE JOIN PROFESSOR ON LE_PR_NUM = PR_NUM WHERE PR_NAME = "김교수";