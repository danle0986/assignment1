package Assignment1;

/**
 * @author <Le Duc Anh Pham - s4010986>
 */

import java.io.*;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String args[]) throws Exception {
        Date expiredDate = new Date(2022, 8, 2);
        InsuranceCard card = new InsuranceCard("1823675748", "Dan Pham", "Dan Pham", expiredDate);
        System.out.println(card.toString());

        PolicyHolder holder1 = new PolicyHolder("c12354379", "Dan Pham", card, null);
        System.out.println(holder1);

        Dependant dependant1 = new Dependant("c12354379", "Dan Pham", card, null);
        System.out.println(dependant1);

        //getters
        System.out.print("Holder1 ID: ");
        System.out.println(holder1.getId());


        System.out.println("Test reading Data from populated files");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("policyHolder.dat"));
        List<PolicyHolder> holderDuplicate = (List<PolicyHolder>) in.readObject();
        in.close();

        for (PolicyHolder policyHolder : holderDuplicate)
        {
            System.out.println(policyHolder);
        }
    }
}
