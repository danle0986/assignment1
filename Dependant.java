package Assignment1;

import java.util.List;

public class Dependant extends Customer
{
    public Dependant(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        super(id, fullName, card, claimList);
    }
}
