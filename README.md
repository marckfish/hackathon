Pour builder les images et les pousser sur dockerHub il suffit de taper la commande suivante 

    mvn compile jib:build
    
Pour builder les images localement, tapez la commande suivante 

    mvn compile jib:dockerBuild
    
Une fois que vous avez fini de builder, lancez la commande suivante 

    docker-compose up