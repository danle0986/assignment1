package Assignment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim implements Serializable
{
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNum;
    private List<String> documentList;
    private double claimAmount;
    private String status;
    private String receiverBankInfo;

    public Claim(String id, Date claimDate, String insuredPerson, String cardNum, double claimAmount, String receiverBankInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNum = cardNum;
        this.documentList = new ArrayList<>();
        this.claimAmount = claimAmount;
        this.status = "New";
        this.receiverBankInfo = receiverBankInfo;
    }

    public boolean compareID(String otherId) {
        return this.id.equals(otherId);
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("Claim " + this.getId() + ":");
        System.out.println("Date: " + this.claimDate.toString());
        System.out.println("Insured person: " + this.insuredPerson);
        System.out.println("Card number: " + this.cardNum);
        System.out.print("Documents: ");
        for (String document: documentList) {
            System.out.print(document);
        }
        System.out.println();
        System.out.format("Claim amount: $%.2f\n", this.claimAmount);
        System.out.println("Status: " + this.status);
        System.out.format("Receiver bank info: %s\n\n", this.receiverBankInfo);
    }

    public void updateStatus()
    {
        if (status.equals("New"))
        {
            status = "Processing";
        } else if (status.equals("Processing")) {
            status = "Done";
        }
    }

    public boolean addDocument(String document)
    {
        return documentList.add(document);
    }
}


