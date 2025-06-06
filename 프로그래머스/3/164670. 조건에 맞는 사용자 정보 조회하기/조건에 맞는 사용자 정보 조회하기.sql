-- 코드를 입력하세요
SELECT A.USER_ID, A.NICKNAME,
CONCAT(A.CITY,' ',A.STREET_ADDRESS1,' ',A.STREET_ADDRESS2) AS 전체주소, 
CONCAT(SUBSTRING(A.TLNO, 1, 3), '-', SUBSTRING(A.TLNO, 4, 4), '-', SUBSTRING(A.TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_USER A
JOIN (SELECT WRITER_ID
     FROM USED_GOODS_BOARD
     GROUP BY WRITER_ID
     HAVING COUNT(*) >= 3) B 
ON A.USER_ID = B.WRITER_ID
ORDER BY A.USER_ID DESC;