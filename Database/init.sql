
-- Erstellen der Tabelle "users"
CREATE TABLE users (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role NVARCHAR(10) CHECK (role IN ('student', 'teacher')) NOT NULL
);

-- Erstellen der Tabelle "wallets"
CREATE TABLE wallets (
    wallet_address VARCHAR(42) PRIMARY KEY,
    user_id INT NOT NULL,
    private_key_enc TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Erstellen der Tabelle "rewards"
CREATE TABLE rewards (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    cost DECIMAL(18,8) NOT NULL
);
