package snake;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {

    public static Window uniqueInstance;

    protected Window(){
    }

    public static Window getInstance(){
        if(uniqueInstance == null) uniqueInstance = new Window();
        return uniqueInstance;
    }

    public void startGame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        initAndStart(dim);
    }

    private void initAndStart(Dimension dim) {
        Game game = Game.getInstance();
        JFrame frame = new JFrame("Snake!");
        frame.setSize(800, 700); // should not be hard coded
        game.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(game);
        frame.add(game);
        frame.pack();
        frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
        game.gameStart();
    }

}