package pacman;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PacBoyTest {

    Jogo jogo = new Pacboy();

    @Test
    public void telaInicial(){
        tela(
            "*****",
            "***|*",
            "*|C**",
            "**|**",
            "*****");
    }

    private void tela(String... linhasEsperadas) {
        String esperada =
                linhasEsperadas[0] + "\n" +
                linhasEsperadas[1] + "\n" +
                linhasEsperadas[2] + "\n" +
                linhasEsperadas[3] + "\n" +
                linhasEsperadas[4] + "\n";
        assertEquals(esperada, jogo.tela());
    }

    @Test
    public void testePacboyDireita() {
        direita();
        assertEquals(
                "*****" + "\n" +
                "***|*" + "\n" +
                "*| C*" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    private void direita() {
        jogo.direita();
    }

    @Test
    public void testePacboyEsquerda() {
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
        direita();
        desce();
        tela("*****",
             "***|*",
             "*|  *",
             "**|C*",
             "*****");
    }

    private void desce() {
        jogo.desce();
    }

    @Test
    public void testePacboyCima() {
        jogo.sobe();
        assertEquals(
                "*****" + "\n" +
                "**C|*" + "\n" +
                "*| **" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    public void testePacboyComeBolinha() {
        jogo.direita();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*| C*" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    public void testeFantasmaAparece() {
        jogo.tick();
        assertEquals("M****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());
    }

    @Test
    public void testeFantasmaAndaParaBaixo() {
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
        jogo.esquerda();
        assertEquals("*****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

    @Test
    public void testeGanhou(){
        jogo.direita();
        jogo.direita();
        jogo.sobe();
        jogo.sobe();
        jogo.esquerda();
        jogo.esquerda();
        desce();
        jogo.esquerda();
        jogo.sobe();
        jogo.esquerda();
        desce();
        desce();
        desce();
        desce();
        jogo.direita();
        jogo.sobe();
        desce();
        jogo.direita();
        jogo.direita();
        jogo.direita();
        jogo.sobe();
        jogo.esquerda();
        assertEquals("GANHOU!", jogo.tela());

    }

    @Test
    public void testeFantasmaAtravessaParede(){
        tick(6);
        assertEquals(
                "M****" + "\n" +
                "***|*" + "\n" +
                "*|C**" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

    private void tick(int quantos) {
        for (int i = 0; i < quantos; i++)
            jogo.tick();
    }

    @Test
    public void testeFantasmaNaoCriaBolinhas(){
        jogo.sobe();
        jogo.esquerda();
        jogo.esquerda();
        jogo.direita();
        tick(6);
        assertEquals(
                "M****" + "\n" +
                " C |*" + "\n" +
                "*| **" + "\n" +
                "**|**" + "\n" +
                "*****" + "\n", jogo.tela());

    }

}
