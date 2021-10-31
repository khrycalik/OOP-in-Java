public class Account {
    private final String name;
    private final String lastName;
    private String currency;
    private double balance;
    private String accountNumber = "Not assigned to any bank";
    public static int NUMBER_OF_CREATED_ACCOUNTS;

    public Account(String name, String lastName, String currency) {
        this.name = name;
        this.lastName = lastName;
        this.currency = currency;
        NUMBER_OF_CREATED_ACCOUNTS++;
    }

    public Account(String name, String lastName, double balance, String currency) {
        this(name, lastName, currency);
        this.balance = balance;
    }

    @Override
    public String toString() {
        // Account{firstName='Jan', lastName='Kownacki', number='Not assigned to any bank', balance=100.0}
        return "Account{firstName='" + this.name + "', lastName='" + this.lastName + "', number='" + this.accountNumber + "', balance=" + this.balance + "}";
    }

    public String getOwner(){
        return this.name + " " + this.lastName;
    }

    
    public String getAccountBalance(){
        return this.balance + " " + this.currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if (other == null || !getClass().equals(other.getClass())) return false;
        Account tmp = (Account) other;
        return this.name.equals(tmp.name) && this.lastName.equals(tmp.lastName) && this.currency.equals(tmp.currency) && this.balance == tmp.balance && this.accountNumber.equals(tmp.accountNumber);
    }

    public void setAccountNum(String accNum) {
        this.accountNumber = accNum;
    }

    public String getNumber() {
        return this.accountNumber;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return this.balance;
    }
}