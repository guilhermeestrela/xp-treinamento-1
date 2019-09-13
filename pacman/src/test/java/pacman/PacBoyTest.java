package pacman;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PacBoyTest {

    Jogo jogo = new Pacboy();

    @Test
    public void telaInicial() {
        tela(
            "*****",
            "***|*",
            "*|C**",
            "**|**",
            "*****");
    }

    @Test
    public void testePacboyDireita() {
        direita();
        tela(
            "*****",
            "***|*",
            "*| C*",
            "**|**",
            "*****");
    }

    @Test
    public void testePacboyEsquerda() {
        sobe();
        jogo.esquerda();
        tela(
            "*****",
            "*C |*",
            "*| **",
            "**|**",
            "*****");
    }

    @Test
    public void testePacboyBaixo() {
        direita();
        desce();
        tela(
            "*****",
            "***|*",
            "*|  *",
            "**|C*",
            "*****");
    }

    @Test
    public void testePacboyCima() {
        sobe();
        tela(
            "*****",
            "**C|*",
            "*| **",
            "**|**",
            "*****");
    }

    @Test
    public void testePacboyComeBolinha() {
        direita();
        tela(
            "*****",
            "***|*",
            "*| C*",
            "**|**",
            "*****");
    }

    @Test
    public void testeFantasmaAparece() {
        jogo.tick();
        tela(
            "M****",
            "***|*",
            "*|C**",
            "**|**",
            "*****");
    }

    @Test
    public void testeFantasmaAndaParaBaixo() {
        jogo.tick();
        jogo.tick();
        tela(
            "*****",
            "M**|*",
            "*|C**",
            "**|**",
            "*****");
    }

    @Test
    public void testePacboyNaoAtravessaParede() {
        esquerda();
        tela(
            "*****",
            "***|*",
            "*|C**",
            "**|**",
            "*****");

    }

    @Test
    public void testeGanhou() {
        direita();
        direita();
        sobe();
        sobe();
        esquerda();
        esquerda();
        desce();
        esquerda();
        sobe();
        esquerda();
        desce();
        desce();
        desce();
        desce();
        direita();
        sobe();
        desce();
        direita();
        direita();
        direita();
        sobe();
        esquerda();
        tela("GANHOU!");
    }

    @Test
    public void testeGameOver() {
        direita();
        direita();
        desce();
        desce();
        esquerda();
        esquerda();
        esquerda();
        esquerda();
        tick(5);
        tela("P");
    }

    @Test
    public void testeCacaFantasma() {
        tick(17);
        tela("P");
    }

    @Test
    public void testeFantasmaAtravessaParede() {
        tick(6);
        tela(
            "M****",
            "***|*",
            "*|C**",
            "**|**",
            "*****");

    }

    @Test
    public void testeFantasmaNaoCriaBolinhas() {
        sobe();
        esquerda();
        esquerda();
        direita();
        tick(6);
        tela(
            "M****",
            " C |*",
            "*| **",
            "**|**",
            "*****");

    }

    private void tick(int quantos) {
        for (int i = 0; i < quantos; i++)
            jogo.tick();
    }

    private void direita() {
        jogo.direita();
    }

    private void esquerda() {
        jogo.esquerda();
    }

    private void sobe() {
        jogo.sobe();
    }

    private void desce() {
        jogo.desce();
    }

    private void tela(String... linhasEsperadas) {

        String esperada = String.join(
                "\n",
                Arrays.asList(linhasEsperadas)
        );
        assertEquals(esperada, jogo.tela());
    }
}
