package Assignment1;

public abstract class Customer {
    private String id;
    private String fullName;
    private String cardNum;

    //private ArrayList<Claim>;

    public Customer()
    {
        this.id = null;
        this.fullName = null;
        this.cardNum = null;
    }
    Customer(String id, String fullName, String cardNum)
    {
        this.id = id;
        this.fullName = fullName;
        this.cardNum = cardNum;
    }
}
