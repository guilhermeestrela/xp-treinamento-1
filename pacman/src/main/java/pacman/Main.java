package pacman;

import base.JogoCanvas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final int KEY_CODE_RIGHT = 39;
    public static final int KEY_CODE_LEFT = 37;
    public static final int KEY_CODE_DOWN = 40;
    public static final int KEY_CODE_UP = 38;

    private static Jogo jogo;
    private static JogoCanvas _canvas;
    private static Map<Character, BufferedImage> mapa =  new HashMap<Character, BufferedImage>();;

    public static void main(String[] args) throws InterruptedException, IOException {
        jogo = new Pacboy();
        mapa.put('*', ImageIO.read(new FileInputStream("i1.jpg")));

        movementInitializer();

        while (true) {
            jogo.tick();
            render();
            exibeTelaGrafica();
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
        _canvas = new JogoCanvas(mapa);
        _canvas.setFocusable(true);

        frame.add(_canvas);
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

    public static void exibeTelaGrafica() {
        _canvas.atualizaTela(jogo.tela().split("\n"));
    }
}
