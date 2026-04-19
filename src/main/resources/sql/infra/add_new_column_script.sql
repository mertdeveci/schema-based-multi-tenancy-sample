DO
$$
    DECLARE
        s TEXT;
    BEGIN
        FOR s IN
            SELECT schema_name
            FROM information_schema.schemata
            WHERE schema_name LIKE 'tenant_%'
            LOOP
                EXECUTE format('ALTER TABLE %I.member ADD COLUMN email VARCHAR(255)', s);
            END LOOP;
    END
$$;