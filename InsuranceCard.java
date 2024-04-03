package Assignment1;

import java.util.Date;

public class InsuranceCard
{
    private String cardNum;
    private String cardHolder;
    private String policyHolder;
    private Date expireDate;

    public InsuranceCard() {
        this.cardNum = null;
        this.cardHolder = null;
        this.policyHolder = null;
        this.expireDate = null;
    }
    public InsuranceCard(String cardNum, String cardHolder, String policyHolder, Date expireDate) {
        this.cardNum = cardNum;
        this.cardHolder = cardHolder;
        this.policyHolder = policyHolder;
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNum='" + cardNum + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", policyHolder='" + policyHolder + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}

