package Customer;

import FileOperations.FileReader;

public class Balance {
    private String ID;
    private String balance;

    public Balance() {

    }

    String getAccounts() throws Exception {

        new FileReader("Balance");
        for (Balance e:FileReader.balances){
            if (e.getID().equalsIgnoreCase(CustomerLoginPage.customerID)) {
                return e.getID() + "  " + e.getBalance();
            }
        }
        return null;
    }

    public String getID() {
        return ID;
    }

    public String getBalance() {
        return balance;
    }

    public Balance(String id, String balance){
        this.ID=id;
        this.balance=balance;
    }

}