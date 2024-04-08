package Assignment1;

import java.io.Serializable;
import java.util.List;

public class Dependant extends Customer implements Serializable
{
    public Dependant(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        super(id, fullName, card, claimList);
    }

    @Override
    public String toString() {
        return "Dependant{} " + super.toString();
    }

    public void display()
    {
        System.out.format("Dependant %s:\n",this.getId());
        System.out.println("Fullname: " + this.getFullName() + "\n" +
                "Insurance Card: " + this.getCard().getCardNum() + "\n" +
                "Claims: \n");
        for (Claim claim: getClaimList())
        {
            System.out.print("\t");
            claim.display();
        }
    }
}
