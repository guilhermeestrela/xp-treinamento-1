import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.Test;
import pacman.Jogo;
import pacman.Pacboy;

import static org.junit.Assert.assertEquals;


public class SimpleTest {

    @Test
    public void telaInicial(){
        Jogo jogo = new Pacboy();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }


    @Test

    public void testPacboyDireita() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.direita();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*| C*" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test

    public void testPacboyEsquerda() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.sobe();
        jogo.esquerda();
        assertEquals("*****" + "\n" +
                "*C |*" + "\n" +
                "*| **" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test

    public void testPacboyBaixo() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.direita();
        jogo.desce();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*|  *" + "\n" +
                "**|C*" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test

    public void testPacboyCima() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.sobe();
        assertEquals("*****" + "\n" +
                "**C|*" + "\n" +
                "*| **" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test

    public void testPacboyComeBolinha() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.direita();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*| C*" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    @Ignore
    public void testFanasmaAparece() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.tick();
        assertEquals("M****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    @Ignore
    public void testFanasmaAndaParaBaixo() {
        Jogo jogo = new Pacboy();
        jogo.tela();
        jogo.tick();
        jogo.tick();
        assertEquals("*****" + "\n" +
                "M**|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    @Ignore
    public void testePacboyNaoAtravessaParede(){
        Jogo jogo = new Pacboy();
        jogo.esquerda();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

    @Test
    @Ignore
    public void testeGameOver(){
        Jogo jogo = new Pacboy();
        jogo.direita();
        jogo.direita();
        jogo.sobe();
        jogo.sobe();
        jogo.esquerda();
        jogo.esquerda();
        jogo.desce();
        jogo.esquerda();
        jogo.sobe();
        jogo.esquerda();
        jogo.desce();
        jogo.desce();
        jogo.desce();
        jogo.desce();
        jogo.direita();
        jogo.sobe();
        jogo.desce();
        jogo.direita();
        jogo.direita();
        jogo.direita();
        jogo.sobe();
        jogo.esquerda();
        //assertEquals("     " + "\n" +
        //        "   | " + "\n" +
        //        " | C " + "\n" +
        //        "  |  " + "\n" +
        //        "     " + "\n", jogo.tela());
        assertEquals("GAME OVER", jogo.tela());

    }

    @Test
    @Ignore
    public void testeFantasmaAtravessaParede(){
        Jogo jogo = new Pacboy();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        assertEquals("M****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

}
