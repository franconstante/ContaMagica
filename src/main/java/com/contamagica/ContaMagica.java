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
                        this.status = GOLD; 
                }
            break;

            case GOLD:
               //checa upgrade
               if(operacao.equals("deposito")){
                    if(this.getSaldo() >= 200000){ 
                        //não pode ir direto de silver pra platinum
                        if(this.getStatus() == SILVER)
                            this.status = GOLD; 
                        else
                            this.status = PLATINUM; 
                    }
                }
                //checa downgrade
                else if(operacao.equals("retirada")){  
                   if(this.getSaldo() < 25000){ 
                        this.status = SILVER;  
                    }
                }
            break;

            case PLATINUM:
                //checa downgrade - so pode ir pra gold
                if(operacao.equals("retirada")){  
                    if(this.getSaldo() < 100000){ 
                        this.status = GOLD;  
                    }
                }
            break;
        
        }
    } 

    void deposito(int valor) throws INVALID_OPER_EXCEPTION{

            if(valor <= 0)
                throw(new INVALID_OPER_EXCEPTION(valor)); 

            switch(this.getStatus()){ 
                case SILVER:
                    this.setSaldo(valor);
                break;

                case GOLD:
                    this.setSaldo(valor*1.01);
                break;

                case PLATINUM:
                    this.setSaldo(valor*1.025); 
                break;
            } 
            this.setStatus("deposito");        
    }

    void retirada(int valor) throws INVALID_OPER_EXCEPTION{
        //garante que conta nao fica zerada
        if(this.getSaldo() < valor || valor <= 0)
            throw(new INVALID_OPER_EXCEPTION(valor));

        this.setSaldo(-valor);
        this.setStatus("retirada");
    }

}