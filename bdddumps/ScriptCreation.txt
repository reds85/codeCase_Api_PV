create database codecase;

use codecase;

CREATE TABLE utilisateur(
   idUser INT AUTO_INCREMENT,
   pseudoUser VARCHAR(20) NOT NULL,
   passwordUser VARCHAR(50) NOT NULL,
   signupDateUser DATE NOT NULL,
   lastSignInUser DATE NOT NULL,
   emailUser VARCHAR(150) NOT NULL,
   avatarUser VARCHAR(250),
   Role VARCHAR(50) NOT NULL,
   PRIMARY KEY(idUser),
   UNIQUE(pseudoUser),
   UNIQUE(emailUser)
)ENGINE=InnoDB;

CREATE TABLE Tags(
   idTag INT AUTO_INCREMENT,
   intituleTag VARCHAR(25) NOT NULL,
   PRIMARY KEY(idTag),
   UNIQUE(intituleTag)
)ENGINE=InnoDB;

CREATE TABLE Post(
   idPost INT AUTO_INCREMENT,
   titrePost VARCHAR(100) NOT NULL,
   contenuPost TEXT NOT NULL,
   dateCreation DATETIME NOT NULL,
   descriptionPost VARCHAR(250),
   idTag INT NOT NULL,
   idUser INT NOT NULL,
   PRIMARY KEY(idPost),
   FOREIGN KEY(idTag) REFERENCES Tags(idTag),
   FOREIGN KEY(idUser) REFERENCES utilisateur(idUser)
)ENGINE=InnoDB;

CREATE TABLE Epingler(
   idUser INT,
   idPost INT,
   PRIMARY KEY(idUser, idPost),
   FOREIGN KEY(idUser) REFERENCES utilisateur(idUser),
   FOREIGN KEY(idPost) REFERENCES Post(idPost)
)ENGINE=InnoDB;

INSERT INTO codecase.utilisateur
(idUser, pseudoUser, passwordUser, signupDateUser, lastSignInUser, emailUser, avatarUser, `Role`)
VALUES(1, 'Anonyme', 'Anonyme', '2026-04-15', '2026-04-15', 'anonyme@test.fr', 'avatar.png', 'USER');

INSERT INTO codecase.utilisateur
(idUser, pseudoUser, passwordUser, signupDateUser, lastSignInUser, emailUser, avatarUser, `Role`)
VALUES(1, 'Anonyme', 'Anonyme', '2026-04-15', '2026-04-15', 'anonyme@test.fr', 'avatar.png', 'USER');

INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(3, 'CSS');
INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(4, 'HTML');
INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(2, 'Java');
INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(6, 'Php');
INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(1, 'Python');
INSERT INTO codecase.Tags (idTag, intituleTag) VALUES(5, 'Ruby');