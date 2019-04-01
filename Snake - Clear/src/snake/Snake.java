package snake;

import snake.Command.Command;
import snake.Iterator.PointIterator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Snake {

    public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

    private int size;
    private int dx;
    private int dy;

    public ArrayList<Point> snakeParts;
    public int tailLength;
    public Point head;
    public int direction, currDirection;

    private PointIterator iterator;
    private static int standardSize = 25;

    public static Snake uniqueInstance;

    private Snake(int x, int y, int size) {
        head = new Point(x, y);
        direction = DOWN;
        dy = size;
        tailLength = 1;
        snakeParts = new ArrayList<Point>();
        iterator = new PointIterator(snakeParts);
        this.size = size;
    }

    public static Snake getInstance(){
        if(uniqueInstance == null) uniqueInstance = new Snake(10 * standardSize, 10 * standardSize, standardSize);
        return uniqueInstance;
    }

    public int getHeadSize() {
        return size;
    }

    private boolean checkSelfCollision() {

        iterator.resetPosition();
        while(iterator.hasNext()) {
            Point bodyPart = iterator.next();
            if(getNextLocation().equals(bodyPart)) {
                return true;
            }
        }
        return false;
    }

    public void eatCherry() {
        tailLength++;

    }

    public boolean updateSnake() {
        if (checkSelfCollision())
            return false;
        snakeParts.add(new Point(head.x + dx, head.y + dy));
        head.x += dx;
        head.y += dy;
        direction = currDirection;
        if (iterator.getSize() > tailLength) {
            iterator.remove(0);
        }
        iterator = new PointIterator(snakeParts);
        return true;
    }

    public Point getNextLocation() {
        return new Point(head.x + dx, head.y + dy);
    }

    public boolean collision(Point p) {
        iterator.resetPosition();

        while(iterator.hasNext()){
            Point point = iterator.next();

            if(p.equals(point)){
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        Color tmp = g.getColor();
        g.setColor(Color.white);
        iterator.resetPosition();

        while(iterator.hasNext()){
          Point p = iterator.next();
          g.fillRect((int) p.getX(), (int) p.getY(), size, size);
        }
        g.fillRect((int) head.getX(), (int) head.getY(), size, size);
        g.setColor(tmp);
    }

    public void setDirection(int direction, Command command) {
        if (this.direction <= DOWN && direction <= DOWN || this.direction > DOWN && direction > DOWN)
            return;
        command.execute(this);
        currDirection = direction;
    }

    public void setDxDy(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx(){
        return dx;
    }

    public int getDy(){
        return dy;
    }

}