package Assignment1;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class PolicyHolder extends Customer implements Serializable
{
    private Set<Dependant> dependantList;

    //constructor for testing without dependantList
    public PolicyHolder(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        super(id, fullName, card, claimList);
    }

    @Override
    public String toString() {
        return "PolicyHolder{} " + super.toString();
    }
}
