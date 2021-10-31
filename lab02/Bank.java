public class Bank {
    public static double EURO = 4.6;
    public static double USD = 3.95;
    public static double PLN = 1;
    private final Account[] accounts = new Account[2];
    private final String BankId;
    public static int BANKS;

    {
        BANKS++;
        BankId = "" + BANKS;
    }
    
    public void addAccount(Account acc){
        for( int i=0; i <accounts.length; i++) {
            if(accounts[i] == null){
                acc.setAccountNum(BankId + (100+ (int) (Math.random() * ((999- 100) + 1))));
                accounts[i] = acc;
                break;
            }
        }
    }

    public void printAccounts() {
        System.out.print("[ ");
        for (Account account : accounts) {
            System.out.print(account + ", ");
        }
        System.out.print(" ]\n");
    }

    public Account findAccount(String accNumber) {

        for (Account acc : accounts) {
            if(accNumber.equals(acc.getNumber())){
                return acc;
            }
        }

        if(BankId.charAt(0) != accNumber.charAt(0)) {
             System.out.println("Cannot transfer, wrong bank");
             return null;
         }

        System.out.println("Could not find given account");
        return null;
    }

    public void transferToDifferentCurrency(String accNum, String currency){
        Account tmpAccount = findAccount(accNum);
        if (tmpAccount == null) return;
        double p = exchanger(tmpAccount.getCurrency(), currency);
        tmpAccount.setBalance(tmpAccount.getBalance() * p);
        tmpAccount.setCurrency(currency);
    }

    public double exchanger(String from, String to){
        if(from.equals("USD") && to.equals("EURO")) return USD/EURO;
        if(from.equals("EURO") && to.equals("USD")) return EURO/USD;
        if(from.equals("PLN") && to.equals("EURO")) return PLN/EURO;
        if(from.equals("EURO") && to.equals("PLN")) return EURO/PLN;
        if(from.equals("USD") && to.equals("PLN")) return USD/PLN;
        if(from.equals("PLN") && to.equals("USD")) return PLN/USD;
        return 1.;
    }

    public void transfer(String f, String s, double amount) {
        transfer(f, s, amount,this);
    }

    public void transfer(String f, String s, double amount, Bank bank) {
        Account first = this.findAccount(f);
        Account second = bank.findAccount(s);
        if (first == null || second == null) {
            return;
        }
        first.setBalance(first.getBalance() - amount);
        second.setBalance(second.getBalance() + amount * exchanger(first.getCurrency(), second.getCurrency()));
    }
}