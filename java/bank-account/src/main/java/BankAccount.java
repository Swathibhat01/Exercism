class BankAccount {
    private int bankBalance;
    private String state = "closed";

    void open() {
        bankBalance = 0;
        state = "opened";
    }
    int getBalance() throws BankAccountActionInvalidException {
        if (state.equals("closed")) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return bankBalance;
    }

     void deposit(int n) throws BankAccountActionInvalidException {
        if (state.equals("closed")) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (n < 0) {
            throw new BankAccountActionInvalidException(
                "Cannot deposit or withdraw negative amount");
        }
         synchronized(this) {
             bankBalance = bankBalance + n;
         }

     }

     void withdraw(int n) throws BankAccountActionInvalidException {
        if (state.equals("closed")) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (bankBalance == 0) {
            throw new BankAccountActionInvalidException(
                "Cannot withdraw money from an empty account");
        }
        if (n > bankBalance) {
            throw new BankAccountActionInvalidException(
                "Cannot withdraw more money than is currently in the account");
        }
        if (n < 0) {
            throw new BankAccountActionInvalidException(
                "Cannot deposit or withdraw negative amount");
        }
        synchronized (this) {
            bankBalance = bankBalance - n;
        }
    }
    void close() {
        state = "closed";

    }
}
