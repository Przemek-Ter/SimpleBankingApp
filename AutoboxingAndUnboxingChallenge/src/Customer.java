import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionsArrayList;


    // Constructors

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactionsArrayList =new ArrayList<>();
        addTransaction(initialAmount);
    }

    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionsArrayList() {
        return transactionsArrayList;
    }

    // Methods :

    // Add Transaction

    public boolean addTransaction(double amount) {
        if (amount > 0) {
            this.transactionsArrayList.add(amount);
            return true;
        }
        return false;
    }

}
