package pacman;


public class Pacboy implements Jogo {

    public static final char CHAR_BLOCK = '|';
    public static final char CHAR_FRUIT = '*';
    public static final char CHAR_PLAYER = 'C';
    private char [][] state;
    private int size;

    int pacboyX;
    int pacboyY;
    char pacboyDirection = 'L'; // L = left; R = right; U = up; D = down

    public Pacboy() {
        this.pacboyX = 2;
        this.pacboyY = 2;

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
        return (x == 2 && y == 1) ||
                (x == 3 && y == 2) ||
                (x == 1 && y == 3);
    }

    public String tela() {
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
        this.state[pacboyY][pacboyX] = ' ';
    }

    public void direita() {
        int desiredX = (pacboyX + 1) % this.size;
        if (shouldBeABlock(desiredX, pacboyY)) {
            return;
        }

        deletePacboy();
        pacboyX = desiredX;

        this.state[pacboyY][pacboyX] = CHAR_PLAYER;
    }

    public void esquerda() {
        int desiredX = (pacboyX - 1) % this.size;
        if (desiredX < 0) {
            desiredX = 4;
        }
        if (shouldBeABlock(desiredX, pacboyY)) {
            return;
        }

        deletePacboy();
        pacboyX = desiredX;

        this.state[pacboyY][pacboyX] = CHAR_PLAYER;
    }

    public void sobe() {
        int desiredY = (pacboyY - 1) % this.size;
        if (desiredY < 0) {
            desiredY = 4;
        }
        if (shouldBeABlock(pacboyX, desiredY)) {
            return;
        }

        deletePacboy();
        pacboyY = desiredY;

        this.state[pacboyY][pacboyX] = CHAR_PLAYER;
    }

    public void desce() {
        int desiredY = (pacboyY + 1) % this.size;
        if (shouldBeABlock(pacboyX, desiredY)) {
            return;
        }
        deletePacboy();
        pacboyY = desiredY;

        this.state[pacboyY][pacboyX] = CHAR_PLAYER;
    }

    public void tick() {

    }
}
