![learnrussian](https://user-images.githubusercontent.com/99363563/154224118-b7a8410d-1a40-4763-9213-540c749c98bb.jpg)

LearnRussian est une application Web inspirée du site internet openrussian.org. 
Le projet a pour but de recréer en partant de zéro ce site, il a été développé sous Spring avec l'outil de template Thymeleaf.
La base de données utilisée est PostgreSQL, elle est conténeurisé par facilité de déploiement grâce à Docker.

**Fonctionalités**

Générations de phrases russes aléatoires avec leurs traductions piochées dans une base de données avec plus de 400 000 entrées
![lr-project1](https://user-images.githubusercontent.com/99363563/154224893-fa45036f-4ae5-4ae3-92cd-66c498d10478.jpg)

Système d'authentification sécurisé via Spring Security qui inclût une notion de privilèges.
![lr-project2](https://user-images.githubusercontent.com/99363563/154224957-a2ded4b2-b6ae-4564-87c8-e1dd28771d91.jpg)

Outils de flashcard où on peut ajouter et retirer des mots qu'on souhaite apprendre.
L'outil va ensuite sélectionner une phrase aléatoire en piochant aussi de manière aléatoire dans la liste des mots qu'on a sélectioné.

![lr-project3](https://user-images.githubusercontent.com/99363563/154225210-ad4214a7-cf63-4dba-a6b4-143b05dd06db.jpg)
