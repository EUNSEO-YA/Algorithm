SELECT GRADE, ID, EMAIL
FROM (
    SELECT
        CASE
            WHEN (D.SKILL_CODE & S.FE_SUM) <> 0
                 AND (D.SKILL_CODE & S.PYTHON_CODE) <> 0 THEN 'A'
            WHEN (D.SKILL_CODE & S.CS_CODE) <> 0 THEN 'B'
            WHEN (D.SKILL_CODE & S.FE_SUM) <> 0
                 AND (D.SKILL_CODE & S.PYTHON_CODE) = 0
                 AND (D.SKILL_CODE & S.CS_CODE) = 0 THEN 'C'
        END AS GRADE,
        D.ID,
        D.EMAIL
    FROM DEVELOPERS D
    CROSS JOIN (
        SELECT
            BIT_OR(CASE WHEN CATEGORY = 'Front End' THEN CODE END) AS FE_SUM,
            MAX(CASE WHEN NAME = 'Python' THEN CODE END)            AS PYTHON_CODE,
            MAX(CASE WHEN NAME = 'C#' THEN CODE END)                AS CS_CODE
        FROM SKILLCODES
    ) S
) T
WHERE GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC;