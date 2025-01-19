# Rapport Développement Mobile - ENSICAEN

## Introduction
Ce dépôt GitLab présente le rapport du projet de la discipline **Développement Mobile**, réalisé par **Vinicius MOREIRA NASCIMENTO**, étudiant en deuxième année d’ingénierie informatique à l’ENSICAEN pour l’année universitaire 2024-2025.

Ce projet inclut deux applications : une **calculatrice mobile** et une **application RSS**. Vous trouverez ci-dessous un tableau récapitulatif des activités menées, suivi de détails techniques et critiques sur les projets.

## Activités du Projet

| Nr  | Activité                                                                 |
|-----|--------------------------------------------------------------------------|
| 1   | Indications de ce qui est fait                                           |
| 2   | Principes UX - Joel Marsh                                                |
| 3   | Rapport GitLab Pages                                                     |
| 4   | Modes Vertical/Horizontal                                                |
| 5   | Robustesse et gestion des erreurs                                        |
| 6   | Déploiement mobile                                                       |
| 7   | Gestion des ressources via des threads                                   |
| 8   | Utilisation du moteur JavaScript                                         |
| 9   | Utilisation de Retrofit et Picasso                                       |
| 10  | Utilisation de DOM                                                       |
| 11  | Collaboration                                                            |
| 12  | Recherches personnelles                                                  |
| 13  | Architecture MVVM                                                        |
| 14  | Critique travail                                                         |

## Détails Techniques

### 1. Principes UX
L'interface de la calculatrice mobile applique des concepts clés inspirés de Joel Marsh dans *UX Design Principles* :
- **Clarté visuelle et hiérarchie** : Boutons espacés et regroupés par fonction.
- **Simplicité fonctionnelle** : Actions essentielles accessibles en un clic.
- **Accessibilité** : Taille des boutons adaptée à une utilisation intuitive sur écran tactile.

**Référence** : Marsh, Joel. *UX Design Principles: Improve Your User Experience Design Fast*. O'Reilly Media.

### 2. Modes Vertical/Horizontal
Le projet supporte les modes vertical et horizontal. Cependant, en mode horizontal, la **calculatrice** perd son contexte, ce qui constitue une erreur majeure.

### 3. Robustesse et Gestion des Erreurs
L'application gère les erreurs grâce à des mécanismes de **catch**, empêchant les calculs incorrects et garantissant une stabilité exemplaire.

### 4. Déploiement Mobile
L'application a été déployée avec succès sur un téléphone Android, incluant une icône personnalisée et un nom adapté.

### 5. Gestion des Threads
L'application **RSS** utilise **RxJava** pour traiter les flux RSS de manière asynchrone avec `Schedulers.newThread()` et `AndroidSchedulers.mainThread()`.

### 6. Utilisation du Moteur JavaScript
Dans la **WebView**, le moteur JavaScript intégré a été activé (`setJavaScriptEnabled(true)`), avec support du **DOM Storage** (`setDomStorageEnabled(true)`).

### 7. Retrofit et Picasso
- **Retrofit** : Gestion des requêtes réseau et intégration avec RxJava.
- **Picasso** : Chargement des images avec effet **Shimmer**.

### 8. DOM et Données Structurées
La bibliothèque Retrofit avec SimpleXML a permis une analyse DOM des flux RSS. Le stockage DOM a également été activé dans la WebView.

### 9. Collaboration
Une collaboration étroite a été établie avec d'autres étudiants brésiliens :
- Raquel Maciel : Déploiement GitLab Pages et installation mobile.
- Luciana Adriao : Principes de design et mise en page.

Vinicius a assisté ses collègues dans l'intégration RSS et le développement de fonctionnalités.

### 10. Recherches Personnelles
Ajout d'une **NavigatorBar**, effet Shimmer pour les données RSS, et bouton de refresh.

### 11. Architecture MVVM
L'architecture **MVVM** a été partiellement implémentée dans l'application RSS.

## Critique du Travail

### Points à Améliorer
#### Calculatrice
- Absence de MVVM.
- Problèmes de contexte en mode horizontal.
- Fonctionnalités limitées.

#### Application RSS
- Superposition entre le bouton de refresh et la NavigatorBar.

### Points Positifs
- Intégration de concepts interconnectés.
- Exploration de nouvelles approches comme Retrofit et NavigatorBar.
- Adaptabilité aux contraintes du projet.

---

## Hébergement
Ce rapport est accessible via une **GitLab Pages** hébergée au sein du projet institutionnel de l’ENSICAEN.

---
Vinicius MOREIRA NASCIMENTO  
ENSICAEN, Année Universitaire 2024-2025