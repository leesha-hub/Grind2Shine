SELECT BIN(GENOTYPE) AS binary_value FROM ECOLI_DATA;

WITH RECURSIVE ecoliData AS (
    SELECT ID FROM ECOLI_DATA
),
seq AS (
    SELECT ID, BIN(ID) AS bin_str, LENGTH(BIN(ID)) AS len, 1 AS pos
      FROM ecoliData
     UNION ALL
    SELECT ID, bin_str, len, pos + 1
      FROM seq
     WHERE pos < len
)
SELECT
    ed.ID,
    ed.GENOTYPE as gt,
    ed.PARENT_ID as pg,
    GENOTYPE,
    bin_str,
    len,
    pos,
    len - pos + 1 AS bit_position
  FROM seq
  JOIN ECOLI_DATA ed
    ON seq.ID = ed.PARENT_ID
 WHERE SUBSTRING(bin_str, pos, 1) = '1'
 ORDER BY ed.id