package pacman;


public class Pacboy implements Jogo {

    private static final char CHAR_PAREDE = '|';
    private static final char CHAR_FRUTA = '*';
    private static final char CHAR_VAZIO = ' ';
    private static final char CHAR_JOGADOR = 'C';
    private static final char CHAR_FANTASMA = 'M';
    private static final String SAIDA_VITORIA = "GANHOU!";
    private char [][] mapa;
    private int tamanho;

    private int pacboyX;
    private int pacboyY;

    private char posicaoAnteriorFantasma = CHAR_FRUTA;
    private int fantasmaX;
    private int fantasmaY;

    private boolean fantasmaInicializado = false;

    public Pacboy() {
        this.pacboyX = 2;
        this.pacboyY = 2;

        this.fantasmaX = 0;
        this.fantasmaY = 0;

        this.tamanho = 5;
        this.mapa = new char[tamanho][tamanho];
        for (int y = 0; y < this.tamanho; y++) {
            for (int x = 0; x < this.tamanho; x++) {
                this.mapa[y][x] = CHAR_FRUTA;
                if (existeBloqueio(x, y)) {
                    this.mapa[y][x] = CHAR_PAREDE;
                }
            }
        }

        this.mapa[pacboyX][pacboyY] = CHAR_JOGADOR;
    }

    private boolean existeBloqueio(int x, int y) {
        return (x == 3 && y == 1) ||
                (x == 1 && y == 2) ||
                (x == 2 && y == 3);
    }

    public String tela() {
        if (verificarVitoria()) {
            return SAIDA_VITORIA;
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.tamanho; y++) {
            for (int x = 0; x < this.tamanho; x++) {
                sb.append(this.mapa[y][x]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void removerPacboy() {
        this.mapa[pacboyY][pacboyX] = CHAR_VAZIO;
    }

    public void direita() {
        int desejadoX = (pacboyX + 1) % this.tamanho;
        movePacBoy(desejadoX, pacboyY);
    }

    public void esquerda() {
        int desejadoX = (pacboyX - 1) % this.tamanho;
        movePacBoy(desejadoX, pacboyY);
    }

    public void sobe() {
        int desejadoY = (pacboyY - 1) % this.tamanho;
        movePacBoy(pacboyX, desejadoY);
    }

    public void desce() {
        int desejadoY = (pacboyY + 1) % this.tamanho;
        movePacBoy(pacboyX, desejadoY);
    }

    private void movePacBoy(int desejadoX, int desejadoY) {
        desejadoX = normalizaMovimento(desejadoX);
        desejadoY = normalizaMovimento(desejadoY);

        if (existeBloqueio(desejadoX, desejadoY)) {
            return;
        }
        removerPacboy();

        pacboyX = desejadoX;
        pacboyY = desejadoY;
        this.mapa[pacboyY][pacboyX] = CHAR_JOGADOR;
    }

    private int normalizaMovimento(int valor) {
        if (valor < 0) {
            return 4;
        }

        return valor;
    }

    public void desceFantasma() {
        removerFantasma();
        fantasmaY = (fantasmaY + 1) % this.tamanho;

        posicaoAnteriorFantasma = this.mapa[fantasmaY][fantasmaX];
        this.mapa[fantasmaY][fantasmaX] = CHAR_FANTASMA;
    }

    private void removerFantasma() {
        this.mapa[fantasmaY][fantasmaX] = posicaoAnteriorFantasma;
    }

    public void tick() {
        if (!fantasmaInicializado) {
            this.inicializarFantasmaSeNecessario();
            fantasmaInicializado = true;
        } else {
            this.desceFantasma();
        }
    }

    private boolean verificarVitoria() {
        boolean venceu = true;
        for (int y = 0; y < this.tamanho; y++) {
            for (int x = 0; x < this.tamanho; x++) {
                if (this.mapa[y][x] == CHAR_FRUTA) {
                    venceu = false;
                }
            }
        }

        return venceu;
    }

    private void inicializarFantasmaSeNecessario() {
        this.mapa[fantasmaY][fantasmaX] = CHAR_FANTASMA;
    }
}
