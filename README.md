# ContaMagica
Tarefa Teste Unitário

Casos de teste
Foram utilizadas as técnicas de Particionamento do espaço de entrada e valor limite.

VerificaCategoria: Saldo < 50.000,00; Status = Silver
	               Saldo >= 50.000,00; Status = Gold
	               Saldo >= 200.000,00; Status = Platinum
	
VerificaSaldo: Saldo = 10.000,00; Depósito = 1.000,00 / Saldo = 11.000,00; Status = Silver
	           Saldo = 60.000,00; Depósito = 1.000,00 / Saldo = saldo + 1.010,00; Status = Gold
	           Saldo = 250.000,00; Depósito = 1000,00 / Saldo = saldo + 1.025,00; Status = Platinum
	
VerificaUpgrade: Saldo = 0,00; Depósito = 50.000,50 / Saldo > 50.000,00; Status = Silver
	             Saldo = 30.000,00; Depósito = 200.000,00 / Saldo > 200.000,00; Status = Silver
	
VerificaDowngrade: Saldo = 200.000,00; Saque = 150.000,00 / Saldo < 100.000,00; Status = Gold
	               Saldo = 50.000,00; Saque = 30.000,00 / Saldo < 25.000,00; Status = Silver
	               Saldo = 150.000,00; Saque = 130.000,00 / Saldo < 25.000,00; Status = Gold
	               Saldo = 20.000,00; Saque = 5.000,00 / Saldo < 25.000,00; Status = Silver
	               Saldo = 15.000,00; Saque = 15.001,00 / Saldo < 0; Status = Erromvn 

Relatórios de defeitos (até que todos foram eliminados)

Análise de cobertura do código

Novos casos de teste acrescentados (com justificativa) ou justificativa para a não necessidade de acrescentar casos de teste.