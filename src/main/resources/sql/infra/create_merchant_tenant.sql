-- ortak bir templates şemasından türetilmesi halinde
-- param: :schema

DO
$$
    DECLARE
        r RECORD;
    BEGIN
        FOR r IN
            SELECT tablename
            FROM pg_tables
            WHERE schemaname = 'templates'
            LOOP
                EXECUTE format(
                        'CREATE TABLE IF NOT EXISTS %I.%I (LIKE templates.%I INCLUDING ALL)',
                        :'schema',
                        r.tablename,
                        r.tablename
                        );
            END LOOP;
    END
$$;