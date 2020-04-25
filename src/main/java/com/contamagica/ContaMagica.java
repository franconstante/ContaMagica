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
    
    public void setStatus(int operacao) { 

        switch(this.getStatus()){
            case this.SILVER:
            break;

            case this.GOLD:
            break;

            case this.PLATINUM:
            break;
        } 

        if ((this.getSaldo() >= 50000 && this.getStatus() == this.SILVER) || (this.getSaldo() < 100000 && this.getStatus() == this.PLATINUM)) { 
            this.status = this.GOLD; 
        } else if (this.getSaldo() >= 200000 && this.getStatus() == this.GOLD) { 
            this.status = this.PLATINUM; 
        } else if (this.getSaldo() < 25000 && this.getStatus() == this.GOLD) { 
            this.status = this.SILVER; 
        } else { 
        
        this.status = this.getStatus(); 
        
    } 

    //void deposito(int valor) throws INVALID_OPER_EXCEPTION;

    //void retirada(int valor) throws INVALID_OPER_EXCEPTION;

}