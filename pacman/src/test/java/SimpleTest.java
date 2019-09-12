import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import pacman.Jogo;
import pacman.Pacboy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    void telaInicial(){
        Jogo jogo = new Pacboy();

        assertEquals("     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());

    }

    @Test
    @Ignore
    void testPacboyNaTela() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    void testPacboyDireita() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "   C " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    void testPacboyEsquerda() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                " C   " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    void testPacboyBaixo() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    void testPacboyCima() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n", jogo.tela());
    }

}
