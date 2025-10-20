SELECT BIN(GENOTYPE) AS binary_value FROM ECOLI_DATA;

WITH RECURSIVE ecoliData AS (
    SELECT ID, GENOTYPE FROM ECOLI_DATA -- where id = 8
),
seq AS (
    SELECT ID, BIN(GENOTYPE) AS bin_str, LENGTH(BIN(GENOTYPE)) AS len, 1 AS pos
      FROM ecoliData
     UNION ALL
    SELECT ID, bin_str, len, pos + 1
      FROM seq
     WHERE pos < len
)
# select * from seq;
SELECT
    ed.ID as ed_id
    ed.GENOTYPE as ed_gt,
    (select genotype from ECOLI_DATA  where id = ed.parent_id) as parent_genotype,
    bin_str,
    len,
    pos,
    len - pos + 1 AS bit_position,
    ed.parent_id
  FROM seq
  LEFT JOIN ECOLI_DATA ed
    ON seq.ID = ed.ID
 WHERE SUBSTRING(bin_str, pos, 1) = '1'
  -- AND ed.parent_id IS NOT NULL
 ORDER BY id, bin_str