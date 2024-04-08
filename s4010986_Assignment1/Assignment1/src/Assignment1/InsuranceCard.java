package Assignment1;

/**
 * @author <Le Duc Anh Pham - s4010986>
 */

import java.io.Serializable;
import java.util.Date;

public class InsuranceCard implements Serializable
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

    public String getCardNum() {
        return this.cardNum;
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
