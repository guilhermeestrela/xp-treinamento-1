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
        jogo.tela();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.pacboy());
    }

    @Test
    @Ignore
    public void testPacboyDireita() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "   C " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.direita());
    }

    @Test
    @Ignore
    public void testPacboyEsquerda() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                " C   " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.esquerda());
    }

    @Test
    @Ignore
    public void testPacboyBaixo() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        assertEquals("     " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" , jogo.desce());
    }

    @Test
    @Ignore
    public void testPacboyCima() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        assertEquals("     " + "\n" +
                "  C  " + "\n" +
                "     " + "\n" +
                "     " + "\n" +
                "     " + "\n" , jogo.sobe());
    }

    @Test
    @Ignore
    public void testJogoComBolinhas() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        assertEquals("*****" + "\n" +
                "*****" + "\n" +
                "*****" + "\n" +
                "*****" + "\n" +
                "*****" + "\n", jogo.adicionarBolinhas());
    }

    @Test
    @Ignore
    public void testJogoComBolinhasEPacboy() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.adicionarBolinhas();
        assertEquals("*****" + "\n" +
                "*****" + "\n" +
                "**C**" + "\n" +
                "*****" + "\n" +
                "*****" + "\n", jogo.pacboy());
    }

    @Test
    @Ignore
    public void testJogoIniciarComPotuacaoZerada() {
        Jogo jogo = new Pacboy();
        jogo.iniciar();
        assertEquals(0, jogo.pegarPontuacao());
    }

    @Test
    @Ignore
    public void testJogoIniciarComPotuacaoZerada() {
        Jogo jogo = new Pacboy();
        jogo.iniciar();
        assertEquals(0, jogo.pegarPontuacao());
    }

}
