public class Board {

    int [][] state;
    int size;

    public Board() {
        this.size = 20;
        this.state = new int[size][size];
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; i++) {
                System.out.print(this.state[i][j]);
            }
            System.out.println();
        }
    }
}
