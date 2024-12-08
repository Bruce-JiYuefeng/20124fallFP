DROP DATABASE IF EXISTS trade_journal;
CREATE DATABASE IF NOT EXISTS trade_journal;
USE trade_journal;

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

CREATE TABLE IF NOT EXISTS trades (
    trade_id BIGINT NOT NULL AUTO_INCREMENT, 
    instrument_id INT NOT NULL,
    date_time DATETIME NOT NULL,	
    buy_sell VARCHAR(4) NOT NULL,
    quantity DECIMAL(8,2) NOT NULL,
    price DECIMAL(12, 2) NOT NULL,
    commissions DECIMAL(8, 2) NOT NULL,
    pnl DECIMAL(15, 2),
    PRIMARY KEY(trade_id),
    FOREIGN KEY (instrument_id) REFERENCES instruments(instrument_id)
);

INSERT INTO trades (instrument_id, date_time, buy_sell, quantity, price, commissions, pnl) VALUES
(1, '2024-11-01 06:33:00', 'buy', 1, 595.00, 1.00, null),
(1, '2024-11-01 06:44:00', 'sell', 1, 600.00, 1.00, 3.0),
(2, '2024-11-22 07:55:00', 'buy', 1, 490.00, 1.00, null),
(2, '2024-11-22 07:59:00', 'sell', 1, 500.00, 1.00, 8.0);
