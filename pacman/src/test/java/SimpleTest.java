

import org.junit.jupiter.api.Test;
import spikes.Jogo;
import spikes.Pacboy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    Jogo jogo = new Pacboy();

    @Test
    void telaInicial(){

        assertEquals("                    " + "\n" +
                "                    " + "\n" +
                "                    " + "\n" +
                "                    " + "\n" +
                "                    " + "\n", jogo.tela());

    }
}
