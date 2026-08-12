package project03;

public class BankAccount {

    // declaracao de atributos de instancia

    int id;
    String clientName;
    double balance;
    
    public void deposit(double amount){
        balance += amount;

    }
    public void withdraw(double amout){
        if(balance >= amout){
            balance -= amout;
        }
    }

    public void displaiDetails(){
        System.out.println("Dados da conta");
        System.out.println("Codigo" + id);
        System.out.println("Nome do Cliente: " + clientName);
        System.out.println("Saldo: R$" + balance);
    }

}
