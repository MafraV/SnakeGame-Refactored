import snake.Window;

public class SnakeGameFacade {

    private static Window mainWindow = Window.getInstance();

    public static void main(String[] args){
        mainWindow.startGame();
    }
}
