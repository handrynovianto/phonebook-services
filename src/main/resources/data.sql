use contact;

CREATE TABLE contact (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         phone VARCHAR(15) NOT NULL,
                         email VARCHAR(100)
);

select * from contact;

CREATE TABLE hibernate_sequence (
                                    next_val BIGINT
);

INSERT INTO hibernate_sequence VALUES (1);