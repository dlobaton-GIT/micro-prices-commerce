DROP TABLE IF EXISTS Prices;
DROP TABLE IF EXISTS Chain;

CREATE TABLE Chain (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) NOT NULL
);
CREATE TABLE Prices (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        brand_id INT NOT NULL,
                        FOREIGN KEY (brand_id) REFERENCES CHAIN(id),
                        start_date datetime NOT NULL,
                        end_date datetime NOT NULL,
                        price_list INT NOT NULL,
                        product_id INT NOT NULL,
                        priority INT NOT NULL,
                        price DECIMAL(65,2) NOT NULL,
                        currency VARCHAR(50) NOT NULL
);