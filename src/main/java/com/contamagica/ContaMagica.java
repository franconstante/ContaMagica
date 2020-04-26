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
    }
	
    public int getStatus(){
        return this.status;
    }
    
    public void setStatus(String operacao) { 

        switch(this.getStatus()){
            case SILVER:
                //checa upgrade
                if(operacao.equals("deposito")){
                    if(this.getSaldo() >= 50000)
                        this.status = this.GOLD; 
                }
            break;

            case GOLD:
               //checa upgrade
               if(operacao.equals("deposito")){
                    if(this.getSaldo() >= 200000){ 
                        //não pode ir direto de silver pra platinum
                        if(this.getStatus() == this.SILVER)
                            this.status = this.GOLD; 
                        else
                            this.status = this.PLATINUM; 
                    }
                }
                //checa downgrade
                else if(operacao.equals("retirada")){  
                   if(this.getSaldo() < 25000){ 
                        this.status = this.SILVER;  
                    }
                }
            break;

            case PLATINUM:
                //checa downgrade
                if(operacao.equals("retirada")){  
                    if(this.getSaldo() < 100000){ 
                        this.status = this.GOLD;  
                    }
                }
            break;
        
        }
    }

	public void deposito(int i) {
	} 

    //void deposito(int valor) throws INVALID_OPER_EXCEPTION;

    //void retirada(int valor) throws INVALID_OPER_EXCEPTION;

}