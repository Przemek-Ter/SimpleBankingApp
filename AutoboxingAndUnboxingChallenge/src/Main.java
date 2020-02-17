import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("NBP");

    public static void main(String[] args) {


        boolean flag = true;

        startApp();
        printMenu();

        while(flag) {
            System.out.println("###Enter what action you want to process : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    customersInBranch();
                    break;
                case 2:
                    showBranchList();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    addBranch();
                    break;
                case 5:
                    transactionToExistingCustomer();
                    break;
                case 6:
                    System.out.println("Quiting application...");
                    flag = false;
                    break;

            }
        }


    }

    // Start application

    private static void startApp() {
        System.out.println("Starting application...");
    }


    // 0 Menu

    private static void printMenu() {
        System.out.println("Press 0 if you want to see Menu.");
        System.out.println("press 1 if you want to see Customers(and Transactions) in Branch.");
        System.out.println("press 2 if you want to see Branches.");
        System.out.println("press 3 if you want to add Customer.");
        System.out.println("press 4 if you want to add Branch.");
        System.out.println("press 5 if you want to add transaction to existing customer.");
        System.out.println("Press 6 if you want to exit app.");
    }

    // 1 Show customers of branch

    private static void customersInBranch() {
        System.out.println("Enter branch name : ");
        String name = scanner.nextLine();

        System.out.println("Show Transactions? (y/n)");
        String decision = scanner.nextLine();
        Boolean verdict = false;
        if (decision.equals("y")){
            verdict = true;
        }

        if (bank.listCustomers(name,verdict)) {
        }else {
            System.out.println("Action failed!");
        }

    }

    // 2 Show Branches

    private static void showBranchList() {
        for(int i = 0 ; i < bank.getBranchArrayList().size() ; i++) {
            System.out.println((i + 1) + ". " + bank.getBranchArrayList().get(i).getBranchName());
        }
    }

    // 3 Add customer

    private static void addCustomer() {
        System.out.println("Enter branch name : ");
        String branchName = scanner.nextLine();

        System.out.println("Enter customer name : ");
        String customerName = scanner.nextLine();

        System.out.println("Enter initial amount : ");
        double initialAmount = scanner.nextDouble();
        scanner.nextLine();

        if(bank.addCustomer(branchName,customerName,initialAmount)) {
            System.out.println("Customer " + customerName + " added with initial amount (" + initialAmount + ")");
        }else {
            System.out.println("Action failed!");
        }
    }

    // 4 Add branch

    private static void addBranch() {
        System.out.println("Enter branch name : ");
        String name = scanner.nextLine();

        if (bank.addBranch(name)) {
            System.out.println("Branch " + name + " have bean added.");
        }else {
            System.out.println("Action failed!");

        }
    }

    // 5 Transaction to existing customer

    private static void transactionToExistingCustomer() {
        System.out.println("Enter branch name : ");
        String branchName = scanner.nextLine();

        System.out.println("Enter customer name : ");
        String customerName = scanner.nextLine();

        System.out.println("Enter amount : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (bank.addCustomerTransaction(branchName,customerName,amount)){
            System.out.println("Customer " + customerName + " get transaction " + amount);
        }else {
            System.out.println("Action failed!");
        }
    }

}
