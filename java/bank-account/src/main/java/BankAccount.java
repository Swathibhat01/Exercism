class BankAccount {

    private int bankBalance;
    private String state = "closed";

    void open() {
        bankBalance = 0;
        state = "opened";
    }

    int getBalance() throws BankAccountActionInvalidException {
        handleAccountValidation(state.equals("closed"), "Account closed");
        return bankBalance;
    }

    void deposit(int n) throws BankAccountActionInvalidException {
        handleAccountValidation(state.equals("closed"), "Account closed");
        handleAccountValidation(n < 0, "Cannot deposit or withdraw negative amount");
        addToBalance(n);
    }

    void withdraw(int n) throws BankAccountActionInvalidException {
        handleAccountValidation(state.equals("closed"), "Account closed");
        handleAccountValidation(bankBalance == 0, "Cannot withdraw money from an empty account");
        handleAccountValidation(n > bankBalance,
            "Cannot withdraw more money than is currently in the account");
        handleAccountValidation(n < 0, "Cannot deposit or withdraw negative amount");
        addToBalance(-n);
    }

    void close() {
        state = "closed";
    }

    private void handleAccountValidation(boolean closed, String s)
        throws BankAccountActionInvalidException {
        if (closed) {
            throw new BankAccountActionInvalidException(s);
        }
    }

    private void addToBalance(int amount) {
        synchronized (this) {
            bankBalance += amount;
        }
    }
}
