# SELECT BIN(GENOTYPE) AS binary_value FROM ECOLI_DATA;

WITH RECURSIVE ecoliData AS (
    SELECT ID, PARENT_ID, GENOTYPE FROM ECOLI_DATA # WHERE ID = 5
),
seq AS (
    SELECT ID, PARENT_ID, GENOTYPE, BIN(GENOTYPE) AS bin_str, LENGTH(BIN(GENOTYPE)) AS len, 1 AS pos
      FROM ecoliData
     UNION ALL
    SELECT ID, PARENT_ID, GENOTYPE, bin_str, len, pos + 1
      FROM seq
     WHERE pos < len
),
genos AS (
    SELECT
          A.*
        , A.len - A.pos + 1 AS bit_position
        , B.ID as ID_B
        , B.PARENT_ID as PID_B
        , B.GENOTYPE as GENOTYPE_B
        , B.bin_str as bin_str_B
        , B.pos as pos_B
        , B.len - B.pos + 1 AS bit_position_B
      FROM seq as A
      JOIN seq as B
        ON A.parent_id = B.id
       AND A.len - A.pos + 1 = B.len - B.pos + 1
     WHERE SUBSTRING(A.bin_str, A.pos, 1) = '1'
       AND A.PARENT_ID IS NOT NULL
     ORDER BY A.ID
)
SELECT * FROM genos;