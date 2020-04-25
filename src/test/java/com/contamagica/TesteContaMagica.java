package com.contamagica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteContaMagica {

    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;

    @Test
    public void verificaCategoriaSilver() {
        ContaMagica contamagica = new ContaMagica();
        Assertions.assertTrue((contamagica.getSaldo() < 50000) && (contamagica.getStatus() == SILVER));
    }
}