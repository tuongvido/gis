UPDATE cell_tower ct
SET region_id = r.id
FROM region r
WHERE ST_Contains(
    r.geom,
    ST_SetSRID(ST_MakePoint(ct.lon, ct.lat), 4326)
);

