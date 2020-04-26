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
    public void verificaCategoriaGold() throws INVALID_OPER_EXCEPTION {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(50000);
        Assertions.assertTrue((contamagica.getSaldo() >= 50000 && (contamagica.getSaldo() < 200000)) && (contamagica.getStatus() == GOLD));
    }

    @Test
    public void verificaCategoriaPlatinum() throws INVALID_OPER_EXCEPTION {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(150000);
        contamagica.deposito(50000);
        Assertions.assertTrue((contamagica.getSaldo() >= 200000) && (contamagica.getStatus() == PLATINUM));
    }

    @Test
    public void verificaAcrescimoSaldoSilver() throws INVALID_OPER_EXCEPTION {
        ContaMagica contamagica = new ContaMagica();
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1000) && (contamagica.getStatus() == SILVER));
    }

    @Test
    public void verificaAcrescimoSaldoGold() throws INVALID_OPER_EXCEPTION {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(50000);
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1010) && (contamagica.getStatus() == GOLD));
    }

    @Test
    public void verificaAcrescimoSaldoPlatinum() throws INVALID_OPER_EXCEPTION {
        ContaMagica contamagica = new ContaMagica();
        contamagica.deposito(150000); 
        contamagica.deposito(50000);
        double saldoEmConta = contamagica.getSaldo();
        contamagica.deposito(1000);
        double saldoAposDeposito = contamagica.getSaldo();
        Assertions.assertTrue((saldoAposDeposito - saldoEmConta == 1025) && (contamagica.getStatus() == PLATINUM));
    }

    @Test
    public void verificaSaldoNegativo() throws INVALID_OPER_EXCEPTION {
        ContaMagica contaMagica = new ContaMagica();
        contaMagica.deposito(10000);
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.retirada(20000);
        }); 
    }

    @Test
    public void verificaOperacaoDepositoNegativa() {
        ContaMagica contaMagica = new ContaMagica();
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.deposito(-10000);
        });
    }
    
    @Test
    public void verificaOperacaoRetiradaNegativa() {
        ContaMagica contaMagica = new ContaMagica();
        Assertions.assertThrows(INVALID_OPER_EXCEPTION.class, () -> {
            contaMagica.retirada(-10000);
        });
    }



}