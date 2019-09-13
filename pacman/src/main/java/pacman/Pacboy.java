package pacman;


import java.util.ArrayList;
import java.util.List;

public class Pacboy implements Jogo {

    private static final char PAREDE = '|';
    private static final char FRUTA = '*';
    private static final char VAZIO = ' ';
    private static final char JOGADOR = 'C';
    private static final char FANTASMA = 'M';
    private static final String SAIDA_VITORIA = "G";
    private static final String SAIDA_PERDEU = "P";
    public static final String SENTIDO_LINHA = "linha";
    public static final String SENTIDO_COLUNA = "coluna";
    private char [][] mapa;
    private int tamanho;

    private int pacboyX;
    private int pacboyY;

    private boolean perdeu;
    private long countTick = 0;

    private char posicaoAnteriorFantasma = FRUTA;
    private int fantasmaX;
    private int fantasmaY;
    private String fantasmaProxMovimento = SENTIDO_LINHA;
    private boolean fantasmaInicializado = false;


    public Pacboy() {
        this.pacboyX = 2;
        this.pacboyY = 2;

        this.fantasmaX = 0;
        this.fantasmaY = 0;

        this.tamanho = 5;
        initMapa();

        this.mapa[pacboyX][pacboyY] = JOGADOR;
    }

    private void initMapa() {
        mapa = new char[tamanho][tamanho];
        for (int y = 0; y < this.tamanho; y++) {
            for (int x = 0; x < this.tamanho; x++) {
                mapa[y][x] = FRUTA;
                if (existeBloqueio(x, y))
                    mapa[y][x] = PAREDE;
            }
        }
    }

    private boolean existeBloqueio(int x, int y) {
        return
                (x == 3 && y == 1) ||
                (x == 1 && y == 2) ||
                (x == 2 && y == 3);
    }

    public String tela() {
        if (perdeu) {
            return SAIDA_PERDEU;
        }
        if (verificarVitoria()) {
            return SAIDA_VITORIA;
        }

        List<String> linhas = new ArrayList<>();
        for (int y = 0; y < this.tamanho; y++) {
            StringBuilder linha = new StringBuilder();
            for (int x = 0; x < this.tamanho; x++) {
                linha.append(this.mapa[y][x]);
            }
            linhas.add(linha.toString());
        }

        return String.join("\n", linhas);
    }

    private void removerPacboy() {
        this.mapa[pacboyY][pacboyX] = VAZIO;
    }

    public void direita()  { movePacboyDelta( 1,  0); }
    public void esquerda() { movePacboyDelta(-1,  0); }
    public void sobe()     { movePacboyDelta( 0, -1); }
    public void desce()    { movePacboyDelta( 0,  1); }

    private void movePacboyDelta(int dx, int dy) {
        int desejadoX = (pacboyX + dx + tamanho) % tamanho;
        int desejadoY = (pacboyY + dy + tamanho) % tamanho;
        movePacBoy(desejadoX, desejadoY);
    }

    private void movePacBoy(int desejadoX, int desejadoY) {
        if (existeBloqueio(desejadoX, desejadoY) || perdeu)
            return;

        removerPacboy();

        pacboyX = desejadoX;
        pacboyY = desejadoY;
        this.mapa[pacboyY][pacboyX] = JOGADOR;
    }

    public void moveFantasmaSegue() {
        if (fantasmaProxMovimento.equals(SENTIDO_LINHA)) {
            fantasmaProxMovimento = SENTIDO_COLUNA;
            if (pacboyX == fantasmaX) {
                return;
            }
            int desejadoX = -1;
            if (pacboyX - fantasmaX > 0) {
                desejadoX = 1;
            }
            desejadoX += fantasmaX;
            if (existeBloqueio(desejadoX, fantasmaY)) {
                return;
            }
            removerFantasma();
            fantasmaX = desejadoX;
            posicaoAnteriorFantasma = this.mapa[fantasmaY][fantasmaX];
            this.mapa[fantasmaY][fantasmaX] = FANTASMA;

            return;
        }

        fantasmaProxMovimento = SENTIDO_LINHA;
        if (pacboyY == fantasmaY) {
            return;
        }
        int desejadoY = -1;
        if (pacboyY - fantasmaY > 0) {
            desejadoY = 1;
        }
        desejadoY += fantasmaY;
        if (existeBloqueio(fantasmaX, desejadoY)) {
            return;
        }

        removerFantasma();
        fantasmaY = desejadoY;
        posicaoAnteriorFantasma = this.mapa[fantasmaY][fantasmaX];
        this.mapa[fantasmaY][fantasmaX] = FANTASMA;
    }

    private void removerFantasma() {
        this.mapa[fantasmaY][fantasmaX] = posicaoAnteriorFantasma;
    }

    public void tick() {
        if (!perdeu || !verificarVitoria()) {
            processaFantasma();
        }

        processaPerda();
        countTick++;
    }

    private void processaPerda() {
        perdeu = pacboyX == fantasmaX && pacboyY == fantasmaY;
    }

    private void processaFantasma() {
        if (!fantasmaInicializado) {
            this.inicializarFantasma();
            fantasmaInicializado = true;
            return;
        }
        if (countTick % 4 == 0) {
            this.moveFantasmaSegue();
        }
    }

    private boolean verificarVitoria() {
        for (int y = 0; y < this.tamanho; y++)
            for (int x = 0; x < this.tamanho; x++)
                if (this.mapa[y][x] == FRUTA)
                    return false;

        return true;
    }

    private void inicializarFantasma() {
        this.mapa[fantasmaY][fantasmaX] = FANTASMA;
    }
}
