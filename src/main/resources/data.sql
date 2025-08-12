INSERT INTO users (id, full_name, password, role, username)
SELECT 1, 'admin', '$2b$12$42E79mkRmw.jilDJ1G1x8.Bc7hrRBI4CgPe6MZWar6NO0HCFfjIgy', 'admin', 'admin'
    WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'admin'
);
