package Assignment1;

import java.util.List;
import java.util.Set;

public class PolicyHolder extends Customer
{
    private Set<Dependant> dependantList;

    //constructor for testing without dependantList
    public PolicyHolder(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        super(id, fullName, card, claimList);
    }
}
