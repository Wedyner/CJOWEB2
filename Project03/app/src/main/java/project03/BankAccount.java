package project03;

public class BankAccount {

    // declaracao de atributos de instancia

    private int id;
    private String clientName;
    private double balance;

    //metodo contrutor
    public BankAccount(int id, String clientName, double balance){
        this.id = id;
        this.clientName = clientName;
        this.balance = balance;
    }

    public BankAccount(int id, String clientName){
        this(id, clientName, 0);
    }
    
    // mettodos acessadores
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

      public void setclientName(String clientName){
        this.clientName = clientName;
    }

    public String getclientName(){
        return clientName;
    }

      public void setbalance(Double balance){
        this.balance = balance;
    }

    public Double balance(){
        return balance;
    }

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
