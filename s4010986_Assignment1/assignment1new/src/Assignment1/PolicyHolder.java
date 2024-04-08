package Assignment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PolicyHolder extends Customer implements Serializable
{
    private List<Dependant> dependantList;

    //constructor for testing without dependantList
    public PolicyHolder(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        super(id, fullName, card, claimList);
        this.dependantList = new ArrayList<>();
    }

    public void display()
    {
        System.out.format("Policy Holder %s:\n",this.getId());
        System.out.println("Fullname: " + this.getFullName() + "\n" +
                            "Insurance Card: " + this.getCard().getCardNum() + "\n" +
                            "Claims: \n");
        for (Claim claim: getClaimList())
        {
            System.out.print("\t");
            claim.display();
        }
    }

    public boolean addDependant(Dependant otherDependant) {
        boolean exist = false;
        for (Dependant dependant : dependantList) {
            if (dependant.equals(otherDependant))
            {
                exist = true;
            }
        }
        if (exist) {
            System.out.println("Dependant already exist. ");
            return false;
        } else {
            return dependantList.add(otherDependant);
        }
    }

    @Override
    public String toString() {
        return "PolicyHolder{" + this.dependantList +
                "} " + super.toString();
    }
}
