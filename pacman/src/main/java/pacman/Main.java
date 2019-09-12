package pacman;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static final int KEY_CODE_RIGHT = 39;
    public static final int KEY_CODE_LEFT = 37;
    public static final int KEY_CODE_DOWN = 40;
    public static final int KEY_CODE_UP = 38;
    private static Jogo jogo;

    public static void main(String[] args) throws InterruptedException {
        jogo = new Pacboy();

        movementInitializer();

        while (true) {
            jogo.tick();
            render();
            Thread.sleep(1500);
        }
    }

    private static void render() throws InterruptedException {
        cleanScreen();
        System.out.println("-----");
        System.out.println(jogo.tela());
    }

    public static void cleanScreen() {
        System.out.print("\n\n\n\n\n");
    }

    private static void movementInitializer() {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        button.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    movementHandler(e);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private static void movementHandler(KeyEvent e) throws InterruptedException {
        switch (e.getKeyCode()) {
            case KEY_CODE_UP:
                jogo.sobe();
                break;

            case KEY_CODE_DOWN:
                jogo.desce();
                break;

            case KEY_CODE_LEFT:
                jogo.esquerda();
                break;

            case KEY_CODE_RIGHT:
                jogo.direita();
                break;
        }

        render();
    }
}
