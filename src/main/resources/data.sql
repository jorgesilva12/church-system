INSERT INTO
    usuarios (id, nome, cpf, email, senha)
VALUES
    (
        1,
        'Administrador',
        '12345678901',
        'admin@local',
        '12345'
    ) ON CONFLICT (id) DO
UPDATE
SET
    nome = EXCLUDED.nome,
    cpf = EXCLUDED.cpf,
    email = EXCLUDED.email,
    senha = EXCLUDED.senha;