public class BankAccount {

    // declaração de atribuitos / variáveis de instância
    private int id;
    private String clientName;
    private double balance;

    // métodos construtores
    public BankAccount(int id, String clientName, double balance){
        this.id = id;
        this.clientName = clientName;
        this.balance = balance;
    }

    public BankAccount(int id, String clientName){
        this(id, clientName, 0);
    }

    // métodos acessadores
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public String getClientName(){
        return clientName;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
    }

    public String toString(){
        return 
            "Dados da conta:" + 
            "\nCódigo: " + id +
            "\nNome do Cliente: " + clientName +
            "\nSaldo: R$ " + balance;
    }
}
