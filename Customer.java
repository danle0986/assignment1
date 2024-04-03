package Assignment1;

import java.util.List;

public abstract class Customer {
    private String id;
    private String fullName;
    private InsuranceCard card;
    private List<Claim> claimList;

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
}
