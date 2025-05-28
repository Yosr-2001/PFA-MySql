# AWS API Gateway Configuration

Ce dossier contient la définition OpenAPI pour générer l'API Gateway via AWS.

Le fichier "openapi.yaml" décrit :

* Toutes les routes REST de tes microservices (product, inventory, order, payment) ;
* La méthode (GET, POST, etc.) pour chaque route ;
* L’URL réelle (IP + port) vers chaque service, via les blocs x-amazon-apigateway-integration ;
* Les schémas des requêtes JSON (requestBody) pour les POST/PUT.
