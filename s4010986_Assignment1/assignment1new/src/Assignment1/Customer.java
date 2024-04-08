package Assignment1;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class Customer implements Serializable, ClaimProcessManager {
    private String id;
    private String fullName;
    private InsuranceCard card;
    private List<Claim> claimList;

    //default constructor
    public Customer() {
        this.id = null;
        this.fullName = null;
        this.card = null;
        this.claimList = null;
    }

    Customer(String id, String fullName, InsuranceCard card, List<Claim> claimList) {
        this.id = id;
        this.fullName = fullName;
        this.card = card;
        this.claimList = claimList;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getCard() {
        return card;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public boolean compareID(String otherId) {
        return this.id.equals(otherId);
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean add(Claim otherClaim) {
        boolean exist = false;
        for (Claim claim : claimList) {
            if (claim.compareID(otherClaim.getId())) {
                exist = true;
                break;
            }
        }
        if (exist) {
            System.out.println("Claim existed");
            return false;
        } else {
            return claimList.add(otherClaim);
        }
    }

    @Override
    public boolean update(Claim otherClaim) {
        boolean exist = false;
        for (Claim claim : claimList) {
            if (claim.compareID(otherClaim.getId())) {
                exist = true;
                claim = otherClaim;
                break;
            }
        }
        if (!exist) {
            System.out.println("Claim does not exist");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(String claimId) {
        boolean exist = false;
        for (Claim claim : claimList) {
            if (claim.compareID(claimId)) {
                exist = true;
                claimList.remove(claim);
                break;
            }
        }
        if (!exist) {
            System.out.println("Claim does not exist");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Claim getOne(String ClaimID) {
        Iterator<Claim> it = claimList.iterator();
        while (it.hasNext()) {
            Claim claim = it.next();
            if (claim.getId().equals(ClaimID))
            {
                return claim;
            }
        }
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return claimList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", card=" + card +
                ", claimList=" + claimList +
                '}';
    }
}
