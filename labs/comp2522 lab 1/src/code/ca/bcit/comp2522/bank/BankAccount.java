package ca.bcit.comp2522.bank;

/**
 * Represents a Bank Account.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class BankAccount {
    /*
     * TODO:
     *  - overloaded withdraw methods
     *  - has a client
     *  - account number (6-7) chars
     *  - has a date for accountOpened
     *  - date for accountClosed
     *  - getDetails -> String "Albert Einstein had $900 USD in account #abc123 which he opened on
     *  on Monday January 1, 1900 and closed Saturday October 14, 1950."
     */


    private static final int MIN_PIN_LEN = 4;
    private static final double MIN_BALANCE_USD = 0.0;

    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private Date accountClosed;

    private double balanceUsd;
    private final int pin;

    /**
     * Constructor for a BankAccount.
     *
     * @param client this bank accounts client
     * @param balanceUsd the account's balance
     * @param pin the bank account's PIN
     */
    BankAccount(final BankClient client,
                final double balanceUsd,
                final int pin)
    {
        validateBalanceUsd(balanceUsd);
        validateClient(client);
        validatePin(pin);

        this.accountNumber = client.getClientID();
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountOpened = client.getSignUpDate();
    }



    /*
     * Throws an error if the balance is less than the required minimum.
     */
    private static void validateBalanceUsd(final double balanceToCheck)
    {
        if (balanceToCheck < MIN_BALANCE_USD)
        {
            throw new IllegalArgumentException("ERROR: Balance cannot be less than" + MIN_BALANCE_USD);
        }
    }

    /*
     * Throws an error if the bank client is null.
     */
    private static void validateClient(final BankClient clientToCheck)
    {
        if (clientToCheck == null)
        {
            throw new IllegalArgumentException("ERROR: Bad client entry.");
        }
    }

    /*
     * Throws an error if the pin is smaller than minimum pin length.
     *
     * @param pinToCheck the PIN to check
     */
    private static void validatePin(final int pinToCheck)
    {
        final String pinToString = pinToCheck + "";

        if (pinToString.length() < MIN_PIN_LEN)
        {
            throw new IllegalArgumentException("ERROR: PIN is too weak, must be greater than " +
                    MIN_PIN_LEN);
        }
    }

    /**
     * Checks if the account is closed
     *
     * @return true if account is closed, false otherwise
     */
    private boolean isAccountClosed()
    {
        if (accountClosed != null)
        {
            return true;
        }
        return false;
    }

    /**
     * Returns client details.
     *
     * @return client details
     */
    public BankClient getClient()
    {
        return client;
    }

    /**
     * Returns account number.
     *
     * @return account number
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Returns the date when the account was opened.
     *
     * @return date of when the account was opened
     */
    public Date getAccountOpened()
    {
        return accountOpened;
    }

    /**
     * Returns the date when the account was closed.
     *
     * @return date of when the account was closed
     */
    public Date getAccountClosed()
    {
        return accountClosed;
    }

    /**
     * Returns the balance in USD.
     *
     * @return balanceUsd
     */
    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     * Returns the PIN.
     * @return pin
     */
    public int getPin()
    {
        return pin;
    }

    /**
     * Closes the bank account.
     *
     * @param accountClosed the Date the bank account is closed
     */
    public void closeAccount(final Date accountClosed)
    {
        if (isAccountClosed())
        {
            System.out.println("ERROR: Account closed. Access denied.");
            return;
        }
        this.accountClosed = accountClosed;
    }

    /**
     * Deposits an amount of money to the account.
     *
     * @param amountUsdToDeposit the amount to deposit
     */
    public void deposit(final double amountUsdToDeposit)
    {
        if (!isAccountClosed())
        {
            validateBalanceUsd(amountUsdToDeposit);

            balanceUsd += amountUsdToDeposit;

            System.out.println("SUCCESS: $" + amountUsdToDeposit + " deposited to account. " +
                    "New account balance: $" + balanceUsd);
        }
        else
        {
            System.out.println("ERROR: Access denied.");
        }
    }

    /**
     * Takes an amount of money from the account with no PIN needed.
     *
     * @param amountUsdToWithdraw the amount to withdraw
     */
    public void withdraw(final double amountUsdToWithdraw)
    {
        if (!isAccountClosed())
        {
            if (amountUsdToWithdraw > MIN_BALANCE_USD && amountUsdToWithdraw <= balanceUsd)
            {

                balanceUsd -= amountUsdToWithdraw;

                System.out.println("SUCCESS: $" + amountUsdToWithdraw + " withdrawn from account. " +
                        "New account balance: $" + balanceUsd);
            }
            else
            {
                System.out.println("ERROR: Withdrawal was unsuccessful.");
            }
        }
        else
        {
            System.out.println("ERROR: Access denied.");
        }
    }

    /**
     * Takes an amount of money from the account with a required PIN.
     *
     * @param amountUsdToWithdraw the amount
     * @param pinToMatch
     */
    public void withdraw(final double amountUsdToWithdraw,
                         final int pinToMatch)
    {
        if (this.pin == pinToMatch)
        {
            withdraw(amountUsdToWithdraw);
        }
        else
        {
            System.out.println("ERROR: Incorrect PIN. Withdrawal was unsuccessful.");
        }
    }

    /**
     * Concatenates all bank account information in a formatted sentence.
     *
     * @return client name, balance, account number and opened Date as a String
     */
    public String getDetails()
    {
        final StringBuilder accountDetails;
        accountDetails = new StringBuilder();

        accountDetails.append(client.getName().getFullName());
        accountDetails.append(" had $");
        accountDetails.append(balanceUsd);
        accountDetails.append(" USD in account #");
        accountDetails.append(accountNumber);
        accountDetails.append(" which he opened on ");
        accountDetails.append(accountOpened.getDateFormatted());

        if (isAccountClosed())
        {
            accountDetails.append(" and closed on ");
            accountDetails.append(accountClosed.getDateFormatted());
        }
        else
        {
            accountDetails.append(" and is still open.");
        }

        return accountDetails.toString();
    }

}
