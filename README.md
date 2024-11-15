# Java Console Banking Application
## Overview
This project is a simple Java console-based banking application that simulates basic banking functionalities, such as user registration, login, account management, transactions, and statement generation. It is designed to help understand object-oriented programming concepts, handling user input, data structures, and date manipulation in Java.

## Features
1. **User Registration & Login**
    - Allows users to register by providing a unique username and password.
    - Provides a login feature that validates user credentials for secure access.
2. **Account Creation**
    - Users can create a new bank account (savings or checking) after logging in.
    - Each account has a unique account number, account holder's name, type, and an initial deposit amount.
3. **Transaction Processing**
    - Users can perform deposits and withdrawals on their accounts.
    - Includes validation to prevent withdrawals that exceed the current balance.
    - Logs each transaction with a unique ID, date, type (deposit/withdrawal), and amount.
4. **Statement Generation**
    - Displays the transaction history for any user account, including transaction details and the current account balance.
5. **Interest Calculation**
    - Applies a fixed interest rate to savings accounts. Interest is calculated monthly and can be applied once per month.
6. **Balance Inquiry**
    - Users can view the current balance of any account.

## Project Structure
```bash
├── User class              # Represents a user with credentials and a list of accounts
├── Account class           # Represents a bank account with attributes and methods for operations
├── Transaction class       # Represents a transaction with ID, type, date, and amount
├── bankingApp class        # Main class containing the entry point and menu-driven interface
```

## How to Run the Application
Compile the source files:

```bash
javac bankingApp.java
```

## Run the compiled program:

```bash
java bankingApp
```

## Usage
- Register: Select the option to register a new user by providing a username and password.
- Login: Log in with valid credentials to access the user menu.
- User Menu Options:
    - Open Account: Create a savings or checking account with an initial deposit.
    - Deposit: Add funds to an existing account.
    - Withdraw: Withdraw funds, ensuring there are sufficient funds.
    - Print Statement: View the transaction history and balance.
    - Add Monthly Interest: Apply interest to savings accounts (fixed rate, calculated monthly).
    - Check Balance: Display the current account balance.
    - Logout: Log out of the current session.

## Key Classes and Methods
1. **User Class:**
    - Attributes: username, password, list of accounts.
    - Methods: getUsername(), getPassword(), addAccount(), etc.
2. **Account Class:**
    - Attributes: accountNumber, accountHolderName, accountType, balance, transactions, lastInterestDate.
    - Methods: deposit(), withdraw(), printStatement(), logTransaction().
3. **Transaction Class:**
    - Attributes: transactionId, type, amount, date.
    - Methods: toString() for printing transaction details.
4. **bankingApp Class:**
    - Manages user registration, login, and the interactive menu interface.
    - Contains methods for user interactions, such as registerUser(), loginUser(), userMenu().

## Output Demo
```bash
BANKING APPLICATION       
-------------------
1. Register
2. Login
3. Exit
Select an option: 1

REGISTER AS NEW USER
--------------------
Enter a username: mukund
Enter a password: mukund
User registered successfully

BANKING APPLICATION
-------------------
1. Register
2. Login
3. Exit
Select an option: 1

REGISTER AS NEW USER
--------------------
Enter a username: guvi
Enter a password: guvi
User registered successfully

BANKING APPLICATION
-------------------
1. Register
2. Login
3. Exit
Select an option: 2

USER LOGIN
----------
Enter username: mukund
Enter password: mukund
Login successful

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 1

OPEN ACCOUNT
------------
Enter account holder's name: Mukund
Enter account type:
1: savings
2: checking
1
Enter initial deposit amount: 10000
Account created successfully. Account Number: 1001

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 1

OPEN ACCOUNT
------------
Enter account holder's name: Mukund Keshan
Enter account type:
1: savings
2: checking
2
Enter initial deposit amount: 15000
Account created successfully. Account Number: 1002

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 2

DEPOSIT MONEY
-------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1001
Enter deposit amount: 18000
Deposit successful

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 3

WITHDRAW MONEY
--------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1001
Enter withdrawal amount: 5000
Withdrawal successful

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 5

CHECK ACCOUNT BALANCE
---------------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1001
Current balance for Account 1001: 23000.00

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 5

CHECK ACCOUNT BALANCE
---------------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1002
Current balance for Account 1002: 15000.00

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 4

PRINT ACCOUNT STATEMENT
-----------------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1001
Statement for Account 1001 (savings account):
Transaction ID: 10001 | Date: 2024-11-12 | Type: Initial Deposit | Amount: 10000.00
Transaction ID: 10003 | Date: 2024-11-12 | Type: Deposit | Amount: 18000.00
Transaction ID: 10004 | Date: 2024-11-12 | Type: Withdrawal | Amount: 5000.00
Current Balance: 23000.00

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 4

PRINT ACCOUNT STATEMENT
-----------------------
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1002
Statement for Account 1002 (checking account):
Transaction ID: 10002 | Date: 2024-11-12 | Type: Initial Deposit | Amount: 15000.00
Current Balance: 15000.00

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 6
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1002
Please select a savings account and try again

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 6
Select an account:
Account Number: 1001 | Type: savings
Account Number: 1002 | Type: checking
1001
Total interest of 460.00 added for 1 months.

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 7

BANKING APPLICATION
-------------------
1. Register
2. Login
3. Exit
Select an option: 2

USER LOGIN
----------
Enter username: guvi
Enter password: guvi
Login successful

USER MENU
---------
1. Open Account
2. Deposit Money
3. Withdraw Money
4. Print Account Statement
5. Check Account Balance
6. Add Monthly Interest
7. Logout
Select an option: 7

BANKING APPLICATION
-------------------
1. Register
2. Login
3. Exit
Select an option: 3

THANK YOU FOR USING THE APPLICATION
```