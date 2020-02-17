import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branchArrayList;


    //Constructors

    public Bank(String name) {
        this.name = name;
        this.branchArrayList = new ArrayList<>();
    }

    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranchArrayList() {
        return branchArrayList;
    }

    // New Methods :

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            this.branchArrayList.add(new Branch(name));
            return true;
        }
        return false;
    }


    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }


    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        Customer customer = branch.findCustomer(customerName);
        if (branch != null) {
            if (customer != null) {
                return branch.addCustomerTransaction(customerName,amount);
            }
            return false;
        }
        return false;
    }


    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer detail for branch " + branch.getBranchName() + " : ");
            ArrayList<Customer> branchCustomers = branch.getCustomerArrayList();
            for (int i = 0 ; i < branchCustomers.size() ; i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println((i + 1) + ". Customer: " + branchCustomer.getName());
                if (showTransactions) {
                    System.out.println("====Transactions :");
                    ArrayList<Double> transactions = branchCustomer.getTransactionsArrayList();
                    for (int j = 0 ; j < transactions.size() ; j++) {
                        System.out.println("      " + (j + 1) + ". " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }


    public Branch findBranch(String name) {
        for(int i = 0 ; i < this.branchArrayList.size() ; i++) {
            Branch branch = this.branchArrayList.get(i);
            if (branch.getBranchName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

}
