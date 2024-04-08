package Assignment1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PopulateData {
    public static void main(String args[]) throws Exception
    {
        List<PolicyHolder> policyHolderList = new ArrayList<>();

        List<Dependant> dependantList = new ArrayList<>();

        Date date1 = new Date(2024, 5, 10);

        //empty claim list
        List<Claim> emptyClaimList = new ArrayList<>();

        //Insurance card
        InsuranceCard card1 = new InsuranceCard("3012681117", "Princess Mcfarland", "Princess Mcfarland", date1);
        InsuranceCard card2 = new InsuranceCard("9847472812", "Holly Hammond", "Holly Hammond", date1);
        InsuranceCard card3 = new InsuranceCard("2591376988", "Daniel Radcliff", "Holly Hammond", date1);

        //policy holder
        PolicyHolder holder1 = new PolicyHolder("c1234562", "Princess Mcfarland", card1, emptyClaimList);
        PolicyHolder holder2 = new PolicyHolder("c1829391", "Holly Hammond", card2, emptyClaimList);

        policyHolderList.add(holder1);
        policyHolderList.add(holder2);

        //dependant
        Dependant dependant1 = new Dependant("c1657328", "Daniel Radcliff", card3, emptyClaimList);

        dependantList.add(dependant1);

        //saveData
        ObjectOutputStream outPolicy = new ObjectOutputStream(new FileOutputStream("policyHolder.dat"));
        outPolicy.writeObject(policyHolderList);
        outPolicy.close();

        ObjectOutputStream outDependant = new ObjectOutputStream(new FileOutputStream("dependant.dat"));
        outDependant.writeObject(dependantList);
        outDependant.close();
    }
}
