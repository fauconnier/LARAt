# LARAt


**LARAt** (*Layout Annotation for Relationship Acquisition tool* / *Logiciel d’Acquisition de Relations par l’Annotation de textes*), prononcé /la&#x0281;a/, est un outil dédié à l'annotation de segments textuels au sein de documents au format HTML. LARAt permet la prise en compte de la mise en forme des textes, exprimée préalablement par balises HTML.


![Alt text](./resources/pics/front_end.png?raw=true "LARAt interface") 


### Caractéristiques :
* Cross-plateformes : Linux, Windows et Mac,
* Sélection graphique des segments textuels,
* Sauvegarde XML des annotations,
* Permet les annotations imbriquées,
* Support UTF-8 et ISO-8859-1,
* Déploiement Ant (pour Windows et Linux).


### Utilisation

    # distribution courante
    java -jar /dist/LARAt_1.1.x.rar
    
    # générer une nouvelle distribution
    ant dist
    java -jar /dist/LARAt_1.1.x.jar


