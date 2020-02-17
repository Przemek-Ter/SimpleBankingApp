import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customerArrayList;


    // Constructors

    public Branch(String name) {
        this.branchName = name;
        this.customerArrayList = new ArrayList<>();
    }

    // Getters

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    // New Methods :   ============================================================================================


    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customerArrayList.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }


    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existCustomer = findCustomer(customerName);
        if (existCustomer != null) {
            existCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }


    public Customer findCustomer(String name) {
        for(int i = 0 ; i < this.customerArrayList.size() ; i++) {
            Customer testCustomer = this.customerArrayList.get(i);
            if (testCustomer.getName().equals(name)) {
                return testCustomer;
            }
        }
        return null;
    }
}
