package pacman;


public class Pacboy implements Jogo {

    private static final char PAREDE = '|';
    private static final char FRUTA = '*';
    private static final char VAZIO = ' ';
    private static final char JOGADOR = 'C';
    private static final char FANTASMA = 'M';
    private static final String SAIDA_VITORIA = "GANHOU!";
    private char [][] mapa;
    private int tamanho;

    private int pacboyX;
    private int pacboyY;

    private char posicaoAnteriorFantasma = FRUTA;
    private int fantasmaX;
    private int fantasmaY;

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
        if (verificarVitoria())
            return SAIDA_VITORIA;

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.tamanho; y++) {
            for (int x = 0; x < this.tamanho; x++)
                sb.append(this.mapa[y][x]);
            sb.append("\n");
        }

        return sb.toString();
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
        if (existeBloqueio(desejadoX, desejadoY))
            return;

        removerPacboy();

        pacboyX = desejadoX;
        pacboyY = desejadoY;
        this.mapa[pacboyY][pacboyX] = JOGADOR;
    }

    public void desceFantasma() {
        removerFantasma();
        fantasmaY = (fantasmaY + 1) % this.tamanho;

        posicaoAnteriorFantasma = this.mapa[fantasmaY][fantasmaX];
        this.mapa[fantasmaY][fantasmaX] = FANTASMA;
    }

    private void removerFantasma() {
        this.mapa[fantasmaY][fantasmaX] = posicaoAnteriorFantasma;
    }

    public void tick() {
        processaFantasma();
    }

    private void processaFantasma() {
        if (!fantasmaInicializado) {
            this.inicializarFantasma();
            fantasmaInicializado = true;
        } else {
            this.desceFantasma();
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
