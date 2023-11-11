CREATE TABLE td_users IF NOT EXISTS (
    u_id INT NOT NULL AUTO_INCREMENT,
    u_pseudo VARCHAR (25) NOT NULL,
    u_password VARCHAR (25) NOT NULL,
    PRIMARY KEY (u_id)) ;
<
CREATE TABLE td_taches IF NOT EXISTS (
    t_id INT NOT NULL AUTO_INCREMENT,
    t_description VARCHAR (250) NOT NULL,
    t_date_limite DATE,
    t_fk_users_id INT,
    PRIMARY KEY (t_id),
    CONSTRAINT t_fk_user_id FOREIGN KEY (t_fk_users_id) REFERENCES td_users (u_id));