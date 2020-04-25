package com.contamagica;

public class INVALID_OPER_EXCEPTION extends Exception{

    private int valor;

    public INVALID_OPER_EXCEPTION(int valor){
        super();
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nao foi possivel realizar a operacao com o valor " + this.valor;
    }

}