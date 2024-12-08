import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SimpleMovement extends JPanel implements ActionListener, KeyListener{
    private BufferedImage image; // object
    private int xPosition = 10; // start x position
    private int yPosition = 10; // start y position


    public SimpleMovement() {
        try {
            image = ImageIO.read(new File("C:\\Users\\New\\Downloads\\grass.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Добавляем слушателя для клавиатуры
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        // Проверяем, какая клавиша была нажата
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                increaseYPosition(); // Действие для 'W'
                break;
            case KeyEvent.VK_A:
                decreaseXPosition(); // Действие для 'A'
                break;
            case KeyEvent.VK_S:
                decreaseYPosition(); // Действие для 'S'
                break;
            case KeyEvent.VK_D:
                increaseXPosition(); // Действие для 'D'
                break;
            default:
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // Этот метод можно использовать для выполнения действия при отпускании клавиши, если это необходимо
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Этот метод можно оставить пустым, если не требуется дополнительной обработки
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        // Метод для обработки событий действий (но он не используется в текущем контексте)
    }

    // Метод для отрисовки изображения
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, xPosition, yPosition, this);
    }

    // Увеличение позиции по X
    public void increaseXPosition() {
        xPosition += 50;
        repaint();
    }

    // Уменьшение позиции по X
    public void decreaseXPosition() {
        xPosition -= 50;
        repaint();
    }

    // Увеличение позиции по Y
    public void increaseYPosition() {
        yPosition -= 50;
        repaint();
    }

    // Уменьшение позиции по Y
    public void decreaseYPosition() {
        yPosition += 50;
        repaint();
    }

}
