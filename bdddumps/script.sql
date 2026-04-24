-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : lun. 20 avr. 2026 à 14:13
-- Version du serveur : 8.0.44
-- Version de PHP : 8.3.30


/*On créé la bdd si elle n'existe pas*/;
CREATE DATABASE IF NOT EXISTS codecase;
USE codecase;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `codecase`
--
-- --------------------------------------------------------

--
-- Structure de la table `Epingler`
--

CREATE TABLE `Epingler` (
  `idUser` int NOT NULL,
  `idPost` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Post`
--

CREATE TABLE `Post` (
  `idPost` int NOT NULL,
  `titrePost` varchar(100) NOT NULL,
  `contenuPost` text NOT NULL,
  `dateCreation` datetime NOT NULL,
  `descriptionPost` varchar(250) DEFAULT NULL,
  `idTag` int NOT NULL,
  `idUser` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Tags`
--

CREATE TABLE `Tags` (
  `idTag` int NOT NULL,
  `intituleTag` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Tags`
--

INSERT INTO `Tags` (`idTag`, `intituleTag`) VALUES
(3, 'CSS'),
(4, 'HTML'),
(2, 'Java'),
(6, 'Php'),
(1, 'Python'),
(5, 'Ruby');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUser` int NOT NULL,
  `pseudoUser` varchar(20) NOT NULL,
  `passwordUser` varchar(50) NOT NULL,
  `signupDateUser` date NOT NULL,
  `lastSignInUser` date NOT NULL,
  `emailUser` varchar(150) NOT NULL,
  `avatarUser` varchar(250) DEFAULT NULL,
  `Role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUser`, `pseudoUser`, `passwordUser`, `signupDateUser`, `lastSignInUser`, `emailUser`, `avatarUser`, `Role`) VALUES
(1, 'Anonyme', 'Anonyme', '2026-04-15', '2026-04-15', 'anonyme@test.fr', 'avatar.png', 'USER');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Epingler`
--
ALTER TABLE `Epingler`
  ADD PRIMARY KEY (`idUser`,`idPost`),
  ADD KEY `idPost` (`idPost`);

--
-- Index pour la table `Post`
--
ALTER TABLE `Post`
  ADD PRIMARY KEY (`idPost`),
  ADD KEY `idTag` (`idTag`),
  ADD KEY `idUser` (`idUser`);

--
-- Index pour la table `Tags`
--
ALTER TABLE `Tags`
  ADD PRIMARY KEY (`idTag`),
  ADD UNIQUE KEY `intituleTag` (`intituleTag`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `pseudoUser` (`pseudoUser`),
  ADD UNIQUE KEY `emailUser` (`emailUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Post`
--
ALTER TABLE `Post`
  MODIFY `idPost` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Tags`
--
ALTER TABLE `Tags`
  MODIFY `idTag` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUser` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Epingler`
--
ALTER TABLE `Epingler`
  ADD CONSTRAINT `epingler_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`),
  ADD CONSTRAINT `epingler_ibfk_2` FOREIGN KEY (`idPost`) REFERENCES `Post` (`idPost`);

--
-- Contraintes pour la table `Post`
--
ALTER TABLE `Post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`idTag`) REFERENCES `Tags` (`idTag`),
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
