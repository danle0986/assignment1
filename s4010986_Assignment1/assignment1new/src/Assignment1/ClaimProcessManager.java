package Assignment1;

import java.util.List;

public interface ClaimProcessManager
{
    public boolean add(Claim claim);
    public boolean update(Claim claim);
    public boolean delete(String claimId);
    public Claim getOne(String ClaimID);
    public List<Claim> getAll();
}
