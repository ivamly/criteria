SET search_path TO public;

INSERT INTO report (id, name)
VALUES
    ('550e8400-e29b-41d4-a716-446655440000', '0 Report'),
    ('550e8400-e29b-41d4-a716-446655440001', '1 Report')
    ON CONFLICT (id) DO NOTHING;