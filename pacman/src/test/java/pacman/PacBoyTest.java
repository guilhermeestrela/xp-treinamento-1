package pacman;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PacBoyTest {

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
    public void testePacboyDireita() {
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
    public void testePacboyEsquerda() {
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
    public void testePacboyBaixo() {
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
    public void testePacboyCima() {
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
    public void testePacboyComeBolinha() {
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
    public void testeFantasmaAparece() {
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
    public void testeFantasmaAndaParaBaixo() {
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
    public void testeGanhou(){
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
        assertEquals("GANHOU!", jogo.tela());

    }

    @Test
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

    @Test
    public void testeFantasmaNaoCriaBolinhas(){
        Jogo jogo = new Pacboy();
        jogo.sobe();
        jogo.esquerda();
        jogo.esquerda();
        jogo.direita();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        jogo.tick();
        assertEquals("M****" + "\n" +
                " C |*" + "\n" +
                "*| **" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

}
