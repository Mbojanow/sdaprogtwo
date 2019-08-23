package pl.sdacademy.prog;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgApplicationTests {

    @Test
    public void contextLoads() {
        assertEquals(1, 1);
        assertThat("Michal").startsWith("Mich");
    }

}
