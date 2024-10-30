WITH HeavyUsers AS (
    -- 총 대여 횟수가 5회 이상인 자동차를 먼저 필터링
    SELECT 
        CAR_ID
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
    GROUP BY 
        CAR_ID
    HAVING 
        COUNT(*) >= 5
),
RentalCounts AS (
    -- 5회 이상 대여된 자동차들에 대해서 월별 대여 횟수를 계산
    SELECT 
        CAR_ID,
        EXTRACT(MONTH FROM START_DATE) AS MONTH,
        COUNT(*) AS RECORDS
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
        AND CAR_ID IN (SELECT CAR_ID FROM HeavyUsers)  -- 헤비 유저만 포함
    GROUP BY 
        CAR_ID, EXTRACT(MONTH FROM START_DATE)
)
-- 최종 결과 출력: 월별 오름차순, 같은 월에서는 자동차 ID 내림차순
SELECT 
    MONTH,
    CAR_ID,
    RECORDS
FROM 
    RentalCounts
ORDER BY 
    MONTH ASC, 
    CAR_ID DESC;
