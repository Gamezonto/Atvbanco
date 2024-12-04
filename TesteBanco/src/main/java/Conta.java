import java.util.*;

public class Conta {
    int numero_conta;
    String titular_conta;
    double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial) {
        this.titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000);
    }

    public void VerSaldo() {
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O nome do titular é: " + titular_conta);
        System.out.println("O saldo da conta é: " + saldo);
    }

    public void Saque(double valor_saque) {
        if (saldo >= valor_saque) {
            saldo -= valor_saque;
            System.out.println("Seu saldo atual é de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void Deposito(double valor_depositado) {
        if (valor_depositado <= 0) {
            System.out.println("Valor insuficiente!");
        }else{
            this.saldo = saldo + valor_depositado;
            System.out.println("Depósito realizado");
            System.out.println("Seu saldo agora é de: " + saldo);
        }
    }

    public void Emprestimo(double valor_emprestimo) {
        if (valor_emprestimo <= 0) {
            System.out.println("Valor insuficiente!");
        } else {
            this.saldo += valor_emprestimo;
            System.out.println("Empréstimo aprovado");
            System.out.println("Seu saldo agora é de: " + saldo);
        }
    }

    public void PagarBoleto(double valor_boleto) {
        if (valor_boleto <= 0) {
            System.out.println("Valor inválido!");
        } else if (saldo >= valor_boleto) {
            saldo -= valor_boleto;
            System.out.println("Pagamento realizado");
            System.out.println("Seu saldo agora é de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void Iniciar() {
        int opcao;
        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        } while (opcao != 6);
    }
    public void Exibir_menu() {
        System.out.println("Bem-vindo ao banco X");
        System.out.println("Escolha sua opção");
        System.out.println("1 - Ver Saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Fazer Empréstimo");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Finalizar");
    }

    public void Escolher_funcao(int opcao) {
        double valor;
        switch (opcao) {
            case 1:
                VerSaldo();
                break;
            case 2:
                System.out.println("Digite o valor a ser sacado:");
                valor = entrada.nextDouble();
                Saque(valor);
                break;
            case 3:
                System.out.println("Digite o valor a ser depositado:");
                valor = entrada.nextDouble();
                Deposito(valor);
                break;
            case 4:
                System.out.println("Digite o valor do empréstimo:");
                valor = entrada.nextDouble();
                Emprestimo(valor);
                break;
            case 5:
                System.out.println("Digite o valor do boleto a ser pago:");
                valor = entrada.nextDouble();
                PagarBoleto(valor);
                break;
            case 6:
                System.out.println("Operação Finalizada");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void main(String[] args) {
        Conta conta = new Conta("William", 1000.0);
        conta.Iniciar();
    }
}


