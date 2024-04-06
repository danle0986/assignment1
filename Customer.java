package Assignment1;

import java.util.List;

public abstract class Customer {
    private String id;
    private String fullName;
    private InsuranceCard card;
    private List<Claim> claimList;

    //default constructor
    public Customer() {
        this.id = null;
        this.fullName = null;
        this.card = null;
        this.claimList = null;
    }

    Customer(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        this.id = id;
        this.fullName = fullName;
        this.card = card;
        this.claimList = claimList;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getCard() {
        return card;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", card=" + card +
                ", claimList=" + claimList +
                '}';
    }
}
