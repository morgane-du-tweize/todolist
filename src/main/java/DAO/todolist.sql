CREATE TABLE td_users IF NOT EXISTS (
    u_id INT NOT NULL AUTO_INCREMENT,
    u_pseudo VARCHAR (25) NOT NULL,
    u_password VARCHAR (100) NOT NULL,
    PRIMARY KEY (u_id)) ;
    
INSERT INTO td_users (u_pseudo, u_password) VALUES ("parrain13", "pizza") ;
INSERT INTO td_users (u_pseudo, u_password) VALUES ("dexter", "omelette") ;
INSERT INTO td_users (u_pseudo, u_password) VALUES ("ripley", "alien") ;
INSERT INTO td_users (u_pseudo, u_password) VALUES ("jean kevin", "crevette") ;
INSERT INTO td_users (u_pseudo, u_password) VALUES ("julien a nouveau", "test") ;


CREATE TABLE td_taches IF NOT EXISTS (
    t_id INT NOT NULL AUTO_INCREMENT,
    t_description VARCHAR (250) NOT NULL,
    t_date_limite DATE,
    t_fk_users_id INT,
    PRIMARY KEY (t_id),
    CONSTRAINT t_fk_user_id FOREIGN KEY (t_fk_users_id) REFERENCES td_users (u_id));

INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("nourrir le poisson rouge", "2024-03-25", 2);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("test de Julien à nouveau", "2023-12-02", 1);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("recruter un stagiaire", "2024-08-21", 2);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("acheter du café", "2025-07-28", 5);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("rendez-vous Pole Emploi", "2025-01-19", 4);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("acheter une souris", "2025-04-13", 4);
INSERT INTO td_taches(t_description, t_date_limite, t_fk_users_id) VALUES ("faire garder le chat", "2025-02-18", 4);