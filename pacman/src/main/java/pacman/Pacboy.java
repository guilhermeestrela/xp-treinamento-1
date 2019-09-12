package pacman;

public class Pacboy implements Jogo {

    char [][] state;
    int size;


    public Pacboy() {
        this.size = 5;
        this.state = new char[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.state[i][j] = ' ';
            }
        }
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

    public void direita() {

    }

    public void esquerda() {

    }

    public void sobe() {

    }

    public void desce() {

    }

    public void tick() {

    }
}
