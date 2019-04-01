-**Projeto Original**: 
- *Como executar*: Deve-se fazer o download do .zip do repositório, extrair os arquivos e importar o projeto para a IDE que estiver ultilizando,
para iniciar o programa é necessário apenas dar "run" na classe "Window", assim executando sua Main e iniciando o jogo.



-**Projeto Refatorado**:
- *Como executar*: Da mesma maneira que o original, deve-se fazer o download do .zip e importar o projeto para sua IDE, para iniciar o programa deve-se apenas dar run na classe SnakeGameFacade, 
assim executando sua Main e iniciando o jogo.

- **Padrões**: Singleton, Iterator, Command e Facade.

- **Classes e Métodos afetados**:
  - **Singleton**:
    - **Classe(s)**: Snake, Game e Window.
    - **Método(s)**: Game.initGame() e Window.initAndStart().
    
  - **Iterator**:
    - **Classe(s)**: Snake.
    - **Método(s)**: Snake.Snake(), Snake.checkSelfCollision(), Snake.updateSnake(), Snake.getNextLocation() e Snake.draw().
    
  - **Command**:
    - **Classe(s)**: Snake e Game.
    - **Método(s)**: Snake.setDirection() e Game.keyPressed().
    
  - **Facade**:
    - **Classe(s)**: Window.
    - **Métodos(s)**: Window.Main().
    
- **Funcionalidade(s) afetada(s)**:
  - **Singleton**: A funcionalidade de iniciar o jogo é afetada, de forma que agora eles instanciam a intância única das Classes Snake e Game.
    
  - **Iterator**: Varias funcionalidades foram afetadas por esse padrão, sendo elas: Checar se a cobra colidiu com alguma parte de seu corpo; Atualizar a cobra ao comer a fruta; 
  Checagem de colisões em geral e Na hora de desenhar a cobra na tela. Elas todas foram alteradas na maneira de se percorrer o corpo da cobra, onde no original era feito diretamente no ArrayList, agora é feita no Iterator.
    
  - **Command**: A funcionalidade de ler e interpretar a tecla pressionada foi alterada, sendo removido um Switch no método Snake.setDirection() e substituido por apenas a execução de um método da classe criada, Command.
    
  - **Facade**: A funcionalidade de setar as dimensões da janela e iniciar o jogo foram alteradas, sendo retirada a Main da classe Window e colocando-a em uma nova classe criada exclusivamente para iniciar o programa.  
