package pacman;


public class Pacboy implements Jogo {

    public static final char CHAR_BLOCK = '|';
    public static final char CHAR_FRUIT = '*';
    public static final char CHAR_EMPTY = ' ';
    public static final char CHAR_PLAYER = 'C';
    public static final char CHAR_GHOST = 'M';
    private char [][] state;
    private int size;

    private int pacboyX;
    private int pacboyY;

    private char ghostPreviousElement = CHAR_FRUIT;
    private int ghostX;
    private int ghostY;

    private boolean ghostInitialized = false;

    public Pacboy() {
        this.pacboyX = 2;
        this.pacboyY = 2;

        this.ghostX = 0;
        this.ghostY = 0;

        this.size = 5;
        this.state = new char[size][size];
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.state[y][x] = CHAR_FRUIT;
                if (shouldBeABlock(x, y)) {
                    this.state[y][x] = CHAR_BLOCK;
                }
            }
        }

        this.state[pacboyX][pacboyY] = CHAR_PLAYER;
    }

    private boolean shouldBeABlock(int x, int y) {
        return (x == 3 && y == 1) ||
                (x == 1 && y == 2) ||
                (x == 2 && y == 3);
    }

    public String tela() {
        if (checkGameOver()) {
            return "GAME OVER";
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                sb.append(this.state[y][x]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void deletePacboy() {
        this.state[pacboyY][pacboyX] = CHAR_EMPTY;
    }

    public void direita() {
        int desiredX = (pacboyX + 1) % this.size;
        movePacBoy(desiredX, pacboyY);
    }

    public void esquerda() {
        int desiredX = (pacboyX - 1) % this.size;
        movePacBoy(desiredX, pacboyY);
    }

    public void sobe() {
        int desiredY = (pacboyY - 1) % this.size;
        movePacBoy(pacboyX, desiredY);
    }

    public void desce() {
        int desiredY = (pacboyY + 1) % this.size;
        movePacBoy(pacboyX, desiredY);
    }

    private void movePacBoy(int desiredX, int desiredY) {
        desiredX = normalizeMovement(desiredX);
        desiredY = normalizeMovement(desiredY);

        if (shouldBeABlock(desiredX, desiredY)) {
            return;
        }
        deletePacboy();

        pacboyX = desiredX;
        pacboyY = desiredY;
        this.state[pacboyY][pacboyX] = CHAR_PLAYER;
    }

    private int normalizeMovement(int value) {
        if (value < 0) {
            return 4;
        }

        return value;
    }


    public void desceGhost() {
        deleteGhost();
        ghostY = (ghostY + 1) % this.size;

        ghostPreviousElement = this.state[ghostY][ghostX];
        this.state[ghostY][ghostX] = CHAR_GHOST;
    }

    private void deleteGhost() {
        this.state[ghostY][ghostX] = ghostPreviousElement;
    }

    public void tick() {
        if (!ghostInitialized) {
            this.inicializarFantasmaSeNecessario();
            ghostInitialized = true;
        } else {
            this.desceGhost();
        }
    }

    private boolean checkGameOver() {
        boolean gameOver = true;
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                if (this.state[y][x] == CHAR_FRUIT) {
                    gameOver = false;
                }
            }
        }

        return gameOver;
    }


    private void inicializarFantasmaSeNecessario() {
        this.state[ghostY][ghostX] = 'M';
    }
}
