import java.util.*;
import java.time.LocalDate;

class User {
    private String username;
    private String password;
    private List<Account> accounts;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
        this.accounts=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}

class Account {
    private static int accountNumberCounter=1000;
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private List<Transaction> transactions;
    private LocalDate lastInterestDate;

    public Account(String accountHolderName, String accountType, double initialDeposit) {
        this.accountNumber=++accountNumberCounter;
        this.accountHolderName=accountHolderName;
        this.accountType=accountType;
        this.balance=initialDeposit;
        this.transactions=new ArrayList<>();
        this.lastInterestDate=LocalDate.now().minusMonths(1);
        logTransaction("Initial Deposit", initialDeposit);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getLastInterestDate() {
        return lastInterestDate;
    }

    public void setLastInterestDate(LocalDate date) {
        this.lastInterestDate=date;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance+=amount;
        logTransaction("Deposit", amount);
    }

    public boolean withdraw(double amount) {
        if(amount>balance) {
            System.out.println("Insufficient funds");
            return false;
        }
        balance-=amount;
        logTransaction("Withdrawal", amount);
        return true;
    }

    private void logTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount, LocalDate.now()));
    }

    public void printStatement() {
        System.out.printf("Statement for Account %d (%s account):\n", accountNumber, accountType);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.printf("Current Balance: %.2f\n", balance);
    }
}

class Transaction {
    private static int transactionCounter=10000;
    private int transactionId;
    private String type;
    private double amount;
    private LocalDate date;

    public Transaction(String type, double amount, LocalDate date) {
        this.transactionId=++transactionCounter;
        this.type=type;
        this.amount=amount;
        this.date=date;
    }

    @Override
    public String toString() {
        return String.format("Transaction ID: %d | Date: %s | Type: %s | Amount: %.2f", transactionId, date, type, amount);
    }
}

public class bankingApp {
    private static List<User> users=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        boolean running=true;
        while (running) {
            System.out.println("\nBANKING APPLICATION");
            System.out.println("-------------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
        System.out.println("\nTHANK YOU FOR USING THE APPLICATION");
        sc.close();
    }

    private static void registerUser() {
        System.out.println("\nREGISTER AS NEW USER");
        System.out.println("--------------------");
        System.out.print("Enter a username: ");
        String username=sc.nextLine();
        System.out.print("Enter a password: ");
        String password=sc.nextLine();

        for (User user : users) {
            if(user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please try another");
                return;
            }
        }

        users.add(new User(username, password));
        System.out.println("User registered successfully");
    }

    private static void loginUser() {
        System.out.println("\nUSER LOGIN");
        System.out.println("----------");
        System.out.print("Enter username: ");
        String username=sc.nextLine();
        System.out.print("Enter password: ");
        String password=sc.nextLine();

        User currentUser=null;
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser=user;
                break;
            }
        }

        if(currentUser == null) {
            System.out.println("Invalid credentials. Please try again");
            return;
        }

        System.out.println("Login successful");
        userMenu(currentUser);
    }

    private static void userMenu(User user) {
        boolean loggedIn=true;
        while (loggedIn) {
            System.out.println("\nUSER MENU");
            System.out.println("---------");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Print Account Statement");
            System.out.println("5. Check Account Balance");
            System.out.println("6. Add Monthly Interest");
            System.out.println("7. Logout");
            System.out.print("Select an option: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    openAccount(user);
                    break;
                case 2:
                    processDeposit(user);
                    break;
                case 3:
                    processWithdrawal(user);
                    break;
                case 4:
                    printAccountStatement(user);
                    break;
                case 5:
                    checkBalance(user);
                    break;
                case 6:
                    addMonthlyInterest(user);
                    break;
                case 7:
                    loggedIn=false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again");
            }
        }
    }

    private static void openAccount(User user) {
        System.out.println("\nOPEN ACCOUNT");
        System.out.println("------------");
        System.out.print("Enter account holder's name: ");
        String name=sc.nextLine();

        System.out.println("Enter account type: \n1: savings\n2: checking");
        int accType=Integer.parseInt(sc.nextLine());
        String type="";
        switch (accType) {
            case 1:
                type="savings";
                break;
            case 2:
                type="checking";
            default:
                break;
        }

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit=sc.nextDouble();
        sc.nextLine();

        Account newAccount=new Account(name, type, initialDeposit);
        user.addAccount(newAccount);
        System.out.printf("Account created successfully. Account Number: %d\n", newAccount.getAccountNumber());
    }

    private static void processDeposit(User user) {
        System.out.println("\nDEPOSIT MONEY");
        System.out.println("-------------");
        Account account=selectAccount(user);
        if(account == null) return;
        System.out.print("Enter deposit amount: ");
        double amount=sc.nextDouble();
        sc.nextLine();

        if(amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful");
    }

    private static void processWithdrawal(User user) {
        System.out.println("\nWITHDRAW MONEY");
        System.out.println("--------------");
        Account account=selectAccount(user);
        if(account == null) return;

        System.out.print("Enter withdrawal amount: ");
        double amount=sc.nextDouble();
        sc.nextLine();

        if(amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if(account.withdraw(amount)) {
            System.out.println("Withdrawal successful");
        }
    }

    private static void printAccountStatement(User user) {
        System.out.println("\nPRINT ACCOUNT STATEMENT");
        System.out.println("-----------------------");
        Account account=selectAccount(user);
        if(account == null) return;

        account.printStatement();
    }

    private static void checkBalance(User user) {
        System.out.println("\nCHECK ACCOUNT BALANCE");
        System.out.println("---------------------");
        Account account=selectAccount(user);
        if(account == null) return;

        System.out.printf("Current balance for Account %d: %.2f\n", account.getAccountNumber(), account.getBalance());
    }

    private static int calculateMonthsElapsed(LocalDate fromDate, LocalDate toDate) {
        int yearDiff=toDate.getYear()-fromDate.getYear();
        int monthDiff=toDate.getMonthValue()-fromDate.getMonthValue();
        return (yearDiff*12)+monthDiff;
    }

    public static void addMonthlyInterest(User user) {
        Account account=selectAccount(user);
        if(account.getAccountType().equalsIgnoreCase("savings")) {
            LocalDate currentDate=LocalDate.now();
            int monthsElapsed=calculateMonthsElapsed(account.getLastInterestDate(), currentDate);

            if(monthsElapsed > 0) {
                double totalInterest = 0;
                double lastBalance=account.getBalance();
                for(int i=0;i<monthsElapsed;i++) {
                    totalInterest+=lastBalance*(0.02);
                    lastBalance+=lastBalance*(0.02);
                }
                account.deposit(totalInterest);
                account.setLastInterestDate(currentDate);
                System.out.printf("Total interest of %.2f added for %d months.%n", totalInterest, monthsElapsed);
            }
            else {
                System.out.println("Interest has already been applied till the current month");
            }
        }
        else {
            System.out.println("Please select a savings account and try again");
        }
    }

    private static Account selectAccount(User user) {
        List<Account> accounts=user.getAccounts();
        if(accounts.isEmpty()) {
            System.out.println("No accounts available please create one and try again");
            return null;
        }

        System.out.println("Select an account:");
        for (Account account : accounts) {
            System.out.printf("Account Number: %d | Type: %s\n", account.getAccountNumber(), account.getAccountType());
        }

        int accountNumber=sc.nextInt();
        sc.nextLine();

        for (Account account : accounts) {
            if(account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        System.out.println("Invalid account number");
        return null;
    }
}
