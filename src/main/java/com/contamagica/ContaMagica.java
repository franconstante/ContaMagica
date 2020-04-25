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
    
    public void setSaldo(double valor){
        this.saldo += valor;
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

    void deposito(int valor) throws INVALID_OPER_EXCEPTION{
            switch(this.getStatus()){ 
                case SILVER:
                    this.setSaldo(valor);
                break;

                case GOLD:
                    this.setSaldo(valor*1.1);
                break;

                case PLATINUM:
                    this.setSaldo(valor*1.25); 
                break;
            } 
            this.setStatus("deposito");        
    }

    void retirada(int valor) throws INVALID_OPER_EXCEPTION{
        this.setSaldo(-valor);
        this.setStatus("retirada");
    }

}