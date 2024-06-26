package test;

/**
 * @author <Le Duc Anh Pham - s4010986>
 */

import Assignment1.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testSerialization {
    static public void main(String args[]) throws Exception
    {
        Date expiredDate = new Date(2022,8,2);

        InsuranceCard card = new InsuranceCard("1823675748", "Dan Pham", "Dan Pham", expiredDate);
        System.out.println(card.toString());


        PolicyHolder holder1 = new PolicyHolder("c12354379", "Dan Pham", card, null);
        System.out.println(holder1);

        List<PolicyHolder> policyHolderList = new ArrayList<>();
        policyHolderList.add(holder1);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("policyHolder.dat"));
        out.writeObject(policyHolderList);
        out.close();


        ObjectInputStream in = new ObjectInputStream(new FileInputStream("policyHolder.dat"));
        List<PolicyHolder> holderDuplicate = (List<PolicyHolder>) in.readObject();
        in.close();

        for (PolicyHolder policyHolder : holderDuplicate)
        {
            System.out.println(policyHolder);
        }
    }
}
