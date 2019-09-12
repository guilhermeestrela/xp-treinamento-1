import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.Test;
import pacman.Jogo;
import pacman.Pacboy;

import static org.junit.Assert.assertEquals;


public class SimpleTest {

    @Test
    public void telaInicial(){
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());

    }

    @Test
    @Ignore
    public void testPacboyNaTela() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    public void testPacboyDireita() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "   C " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    public void testPacboyEsquerda() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                " C   " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    public void testPacboyBaixo() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" , jogo.tela());
    }

    @Test
    @Ignore
    public void testPacboyCima() {
        Jogo jogo = new Pacboy();
        assertEquals("     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n", jogo.tela());
    }

}
