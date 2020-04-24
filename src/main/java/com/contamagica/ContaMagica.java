package com.contamagica;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    private double saldo;
    private int status;

    public ContaMagica(){
        this.saldo = 0;
        this.status = SILVER;
    }
    
    public double getSaldo(){
        return this.saldo;
    };
	
    public int getStatus(){
        return this.status;
    };
	
    //void deposito(int valor) throws INVALID_OPER_EXCEPTION;

    //void retirada(int valor) throws INVALID_OPER_EXCEPTION;

}