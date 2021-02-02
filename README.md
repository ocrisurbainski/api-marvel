# api-marvel

Endpoints que foram implementados:

* `/v1/public/characters`
* `/v1/public/characters/{characterId}`
* `/v1/public/characters/{characterId}/comics`
* `/v1/public/characters/{characterId}/events`
* `/v1/public/characters/{characterId}/series`
* `/v1/public/characters/{characterId}/stories`

#### Compilar o projeto

Para compilar o projeto será necessário ter instalado o Java 15 e o Maven na máquina, execute o seguinte comando na pasta raiz do deste projeto:

> mvn clean install

#### Executando o projeto

Para executar o projeto na pasta raiz do projeto execute o seguinte comando:

> java -jar --enable-preview target/api-marvel-0.0.1-SNAPSHOT.jar

Como foi utilizado um novo recurso do java (`record`) será necessário habilitar o modo de preview do java para que o projeto possa ser executado com sucesso.