package pacman;


public class Pacboy implements Jogo {

    private char [][] state;
    private int size;

    int pacboyX;
    int pacboyY;

    int ghostX;
    int ghostY;
    char pacboyDirection = 'L'; // L = left; R = right; U = up; D = down

    private boolean ghostInitialized = false;

    public Pacboy() {
        this.pacboyX = 2;
        this.pacboyY = 2;

        this.ghostX = 0;
        this.ghostY = 0;

        this.size = 5;
        this.state = new char[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.state[i][j] = '*';
            }
        }

        this.state[pacboyX][pacboyY] = 'C';
    }

    public String tela() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                sb.append(this.state[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void deletePacboy() {
        this.state[pacboyY][pacboyX] = ' ';
    }

    public void direita() {
        deletePacboy();
        pacboyX = (pacboyX + 1) % this.size;

        this.state[pacboyY][pacboyX] = 'C';
    }

    public void esquerda() {
        deletePacboy();
        pacboyX = (pacboyX - 1) % this.size;
        if (pacboyX < 0) {
            pacboyX = 4;
        }

        this.state[pacboyY][pacboyX] = 'C';
    }

    public void sobe() {
        deletePacboy();
        pacboyY = (pacboyY - 1) % this.size;
        if (pacboyY < 0) {
            pacboyY = 4;
        }

        this.state[pacboyY][pacboyX] = 'C';
    }

    public void desce() {
        deletePacboy();
        pacboyY = (pacboyY + 1) % this.size;

        this.state[pacboyY][pacboyX] = 'C';
    }

    public void desceGhost() {
        deleteGhost();
        ghostY = (ghostY + 1) % this.size;

        this.state[ghostY][ghostX] = 'M';
    }

    private void deleteGhost() {
        this.state[ghostY][ghostX] = '*';
    }

    public void tick() {
        if (!ghostInitialized) {
            this.inicializarFantasmaSeNecessario();
            ghostInitialized = true;
        } else {
            this.desceGhost();
        }
    }


    private void inicializarFantasmaSeNecessario() {
        this.state[ghostY][ghostX] = 'M';
    }
}
