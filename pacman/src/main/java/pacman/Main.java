package pacman;

import base.JogoCanvas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final int CODIGO_CHAVE_DIREITA = 39;
    public static final int CODIGO_CHAVE_ESQUERDA = 37;
    public static final int CODIGO_CHAVE_BAIXO = 40;
    public static final int CODIGO_CHAVE_ACIMA = 38;
    public static final int CODIGO_CHAVE_REINICIAR = 82;

    private static Jogo jogo;
    private static JogoCanvas canvas;
    private static Map<Character, BufferedImage> imagens;

    public static void main(String[] args) throws InterruptedException, IOException {
        iniciarJogo();
        carregarImagens();
        iniciarCapturaDeMovimentos();

        while (true) {
            jogo.tick();
            renderizar();
            exibirTelaGrafica();
            Thread.sleep(403);
        }
    }

    private static void iniciarJogo() {
        jogo = new Pacboy();
    }

    private static void carregarImagens() throws IOException {
        imagens = new HashMap<Character, BufferedImage>();
        imagens.put('C', ImageIO.read(new FileInputStream("pacboy.png")));
        imagens.put('M', ImageIO.read(new FileInputStream("fantasma.png")));
        imagens.put('*', ImageIO.read(new FileInputStream("food.png")));
        imagens.put('|', ImageIO.read(new FileInputStream("neon.png")));
        imagens.put('P', ImageIO.read(new FileInputStream("game_over.jpg")));
        imagens.put('G', ImageIO.read(new FileInputStream("you_win.jpg")));
    }

    private static void renderizar() throws InterruptedException {
        limparTela();
        System.out.println("-----");
        System.out.println(jogo.tela());
    }

    public static void limparTela() {
        System.out.print("\n\n\n\n\n");
    }

    private static void iniciarCapturaDeMovimentos() {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(340, 340));

        canvas = new JogoCanvas(imagens);
        canvas.setFocusable(true);
        frame.add(canvas);

        button.addKeyListener(new KeyAdapter() { @Override public void keyPressed(KeyEvent e) {
            try {
                acionarMovimentos(e);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }});
    }

    private static void acionarMovimentos(KeyEvent e) throws InterruptedException {
        if (e.getKeyCode() == CODIGO_CHAVE_ACIMA)      jogo.sobe();
        if (e.getKeyCode() == CODIGO_CHAVE_BAIXO)      jogo.desce();
        if (e.getKeyCode() == CODIGO_CHAVE_ESQUERDA)   jogo.esquerda();
        if (e.getKeyCode() == CODIGO_CHAVE_DIREITA)    jogo.direita();
        if (e.getKeyCode() == CODIGO_CHAVE_REINICIAR)  iniciarJogo();
    }

    public static void exibirTelaGrafica() {
        canvas.atualizaTela(jogo.tela().split("\n"));
    }
}
