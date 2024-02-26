SELECT * FROM CATEGORY;
SELECT * FROM PRODUCT;
use shoppingmall;
#제품별 카테고리를 조회, 카테고리 제품을 조회
SELECT  
	CA_NAME AS "카테고리",PR_TITLE AS "제품명" 
FROM 
	CATEGORY 
		JOIN 
		PRODUCT ON CA_NUM = PR_CA_NUM;
#기타 카테고리에 포함된 모든 제품을 조회
SELECT
	CA_NAME AS 카테고리 , PR_TITLE AS 제품명
    FROM
    CATEGORY
		JOIN
        PRODUCT ON CA_NUM = PR_CA_NUM
        WHERE
			CA_NAME="기타";

#ABC123 회원이 주문한 제품목록을 조회
select or_me_id as 회원,pr_title as 제품명 from `order` join product on or_pr_code = pr_code where or_me_id = "abc123";

#제품별 판매수량을 조회하는 쿼리
select pr_title as 제품명, or_amount as 판매량 from `order` join product on or_pr_code = pr_code;
select product.*, ifnull(sum(or_amount),0) as "판매수량"
from
	`order`
		right join
	product on pr_code = or_pr_code
group by pr_code;
#인기제품조회, 인기제품은 누적판매량을 기준으로 상위 5개 제품
select pr_title as 제품명, or_amount as 판매량 from `order` join product on or_pr_code = pr_code;
select product.*, ifnull(sum(or_amount),0) as "판매수량"
from
	`order`
		right join
	product on pr_code = or_pr_code
where or_state not in('반품','환불') or or_state is null
group by pr_code;

#가격이 제일 비싼 제품을 조회하는 쿼리
select * from product order by pr_price desc limit 1;