package pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CapturadorDeTeclas {

    public static void main(String[] args) {
        Jogo jogo = new Pacboy();
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        button.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                e.getKeyCode();
            }
        });
        System.out.println(jogo.tela());
    }
}