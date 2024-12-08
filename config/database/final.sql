DROP DATABASE IF EXISTS trade_journal;
CREATE DATABASE IF NOT EXISTS trade_journal;
USE trade_journal;

# instruments are another word for financial market securities. stocks are instruments. 
CREATE TABLE IF NOT EXISTS instruments (
    instrument_id INT NOT NULL AUTO_INCREMENT, 
    instrument_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(instrument_id)
);

INSERT INTO instruments (instrument_id, instrument_name) VALUES
(1, 'spy'),
(2, 'qqq'),
(3, 'nvda'),
(4, 'amzn'),
(5, 'goog');

CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT NOT NULL AUTO_INCREMENT, 
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY(user_id)
);

INSERT INTO users (user_id, name, password) VALUES
(1, 'test', '123abc'),
(2, 'mrNoTrades', '123abc');

CREATE TABLE IF NOT EXISTS trades (
    trade_id BIGINT NOT NULL AUTO_INCREMENT, 
    instrument_id INT NOT NULL,
    user_id BIGINT NOT NULL,
    date_time DATETIME NOT NULL,	
    buy_sell VARCHAR(4) NOT NULL,
    quantity DECIMAL(8,2) NOT NULL,
    price DECIMAL(12, 2) NOT NULL,
    commissions DECIMAL(8, 2) NOT NULL,
    pnl DECIMAL(15, 2),
    PRIMARY KEY(trade_id),
    FOREIGN KEY (instrument_id) REFERENCES instruments(instrument_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO trades (instrument_id, user_id, date_time, buy_sell, quantity, price, commissions, pnl) VALUES
(1, 1, '2024-11-01 06:33:00', 'buy', 1, 595.00, 1.00, null),
(1, 1, '2024-11-01 06:44:00', 'sell', 1, 600.00, 1.00, 3.0),
(2, 1, '2024-11-22 07:55:00', 'buy', 1, 490.00, 1.00, null),
(2, 1, '2024-11-22 07:59:00', 'sell', 1, 500.00, 1.00, 8.0),
(3, 1, '2024-12-07 08:00:00', 'buy', 1, 142.00, 1.00, null),
(3, 1, '2024-12-07 08:59:00', 'sell', 1, 132.00, 1.00, -12.0);
