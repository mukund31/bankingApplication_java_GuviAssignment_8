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
src/
│
├── User.java              # Represents a user with credentials and a list of accounts
├── Account.java           # Represents a bank account with attributes and methods for operations
├── Transaction.java       # Represents a transaction with ID, type, date, and amount
├── bankingApp.java        # Main class containing the entry point and menu-driven interface
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