Tarefa Teste Unitário

Casos de teste 
- Foram utilizadas as técnicas de Particionamento do espaço de entrada e valor limite: 

    VerificaCategoria: 

    1. verificaCategoriaGold: Saldo < 50.000,00; Status = Silver 
    2. verificaCategoriaGold: Saldo >= 50.000,00; Status = Gold 
    3. verificaCategoriaPlatinum: Saldo >= 200.000,00; Status = Platinum


    VerificaSaldoUpgrade: 

    4. verificaAcrescimoSaldoUpgradeSilver: Saldo = 10.000,00; Depósito = 1.000,00 / Saldo = 11.000,00; Status = Silver 
    5. verificaAcrescimoSaldoUpgradeGold: Saldo = 60.000,00; Depósito = 1.000,00 / Saldo = saldo + 1.010,00; Status = Gold 
    6. verificaAcrescimoSaldoUpgradePlatinum: Saldo = 250.000,00; Depósito = 1000,00 / Saldo = saldo + 1.025,00; Status = Platinum

    VerificaSaldoRetiradaDowngrade:

    7. verificaRetiradaDowngradeGoldSilver: Saldo = 75.000,00; Saque = 50.001,00: Status = Gold / Saldo = 24.999,00; Status = Silver
    8. verificaRetiradaDowngradePlatinumGold: Saldo = 200.000,00; Saque = 100.501,00: Status = Platinum / Saldo = 99.999,00; Status = Gold
    9. verificaRetiradaDowngradePlatinumSilver: Saldo = 200.000,00; Saque = 175.501,00: Status = Platinum / Status = Gold

    Extras:
    
    10. verificaUpgradeDiretoSilverPlatinum: Saldo = 1.000,00; Depósito = 250.000,00 / Status = Gold
    11. verificaOperacaoRetiradaNegativa: retirada = -1000 / trow INVALID_OPER_EXCEPTION 
    12. verificaOperacaoDepositoNegativa: deposito = -1 / trow INVALID_OPER_EXCEPTION
    13. verificaSaldoNegativo: Saldo = 1.000,00; retirada = 20.000,00 / trow INVALID_OPER_EXCEPTION 


Relatórios de defeitos (até que todos foram eliminados)

Na primeira bateria de testes implementados foram encontradas 3 falhas: 

[ERROR] Failures: 
[ERROR]   TesteContaMagica.verificaAcrescimoSaldoGold:48 expected: <true> but was: <false>
[ERROR]   TesteContaMagica.verificaAcrescimoSaldoPlatinum:58 expected: <true> but was: <false>
[ERROR]   TesteContaMagica.verificaCategoriaPlatinum:29 expected: <true> but was: <false>
[INFO] 
[ERROR] Tests run: 6, Failures: 3, Errors: 0, Skipped: 0

Erro 1: Assertions.assertTrue((contamagica.getSaldo() >= 200000) && (contamagica.getStatus() == PLATINUM));
Motivo: Teste estava errado, pois não pode ir diretamente de Silver para Platinum em um único depósito. 
Ação:  Corrigido teste com dois depósitos e foi ok:  contamagica.deposito(150000); contamagica.deposito(50000); 
Criado um novo teste para garantir que não vá direto de Silver para Platinum: verificaUpgradeDiretoPlatinum()

Erros 2 e 3: [ERROR]   TesteContaMagica.verificaAcrescimoSaldoGold:48 expected: <true> but was: <false>
                   [ERROR]   TesteContaMagica.verificaAcrescimoSaldoPlatinum:58 expected: <true> but was: <false>
Motivo: Erro de lógica, estava adicionando 10% e 25% respectivamente ao invés de 1% e 2,5%
Ação: corrigido código: this.setSaldo(valor*1.01); e this.setSaldo(valor*1.025);


Análise de cobertura do código

Analisando a cobertura de testes, verificou-se 97%, faltando cobertura para: 
1.                         //não pode ir direto de silver pra platinum
2.                         if(this.getStatus() == SILVER)
3.                             this.status = GOLD; 

Foi identificado erro de lógica, não precisa desse trecho de código visto que está em um case GOLD. Corrigido e assim obtivemos 100% de cobertura.

Novos casos de teste acrescentados (com justificativa) ou justificativa para a não necessidade de acrescentar casos de teste.

Durante a analise dos testes de acordo com especificacao foram identificados para adicionar: 

* A verificação de “upgrade” da conta se dá via operação de depósito, e não é possível que um cliente faça “upgrade” diretamente de “Silver” para “Platinum” em uma única operação.
    * verificaUpgradeDiretoSilverPlatinum: Saldo = 1.000,00; Depósito = 250.000,00 / Status = Gold 
    
* Observação: as contas nunca podem ficar negativas.
    * verificaSaldoNegativo: Saldo = 1.000,00; retirada = 20.000,00 / trow INVALID_OPER_EXCEPTION 

* Teste para integridade do sistema: 
    * verificaOperacaoRetiradaNegativa: retirada = -1000 / trow INVALID_OPER_EXCEPTION 
    * verificaOperacaoDepositoNegativa: deposito = -1 / trow INVALID_OPER_EXCEPTION









