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

    @Test
    public void verificaCategoriaGold() {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(50000);
        Assertions.assertTrue((contamagica.getSaldo() >= 50000 && (contamagica.getSaldo() < 200000)) && (contamagica.getStatus() == GOLD));
    }

    @Test
    public void verificaCategoriaPlatinum() {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(200000);
        Assertions.assertTrue((contamagica.getSaldo() >= 200000) && (contamagica.getStatus() == PLATINUM));
    }

    @Test
    public void verificaAcrescimoSaldoSilver() {
        ContaMagica contamagica = new ContaMagica();
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1000) && (contamagica.getStatus() == SILVER));
    }

    @Test
    public void verificaAcrescimoSaldoGold() {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(50000);
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1010) && (contamagica.getStatus() == GOLD));
    }

    @Test
    public void verificaAcrescimoSaldoPlatinum() {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(200000);
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1025) && (contamagica.getStatus() == PLATINUM));
    }

    @Test
    public void verificaUpgradeSilver() {
        
    }

    @Test
    public void verificaUpgradeGold() {
        
    }

    @Test
    public void verificaUpgradePlatinum() {
        
    }

    @Test
    public void verificaDowngradeSilver() {
        
    }

    @Test
    public void verificaDowngradeGold() {
        
    }

    @Test
    public void verificaDowngradePlatinum() {
        
    }
}