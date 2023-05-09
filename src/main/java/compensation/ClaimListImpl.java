package compensation;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ClaimListImpl extends UnicastRemoteObject implements ClaimList {

    private static final int PORT_NUMBER = 20622;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
            registry.bind("CLAIM_LIST", new ClaimListImpl());
            System.out.println("ClaimList is running!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
            System.out.println("Bind Failed!");
        }
    }

    private List<Claim> claimList;

    public ClaimListImpl() throws RemoteException {
        super();
        this.claimList = new ArrayList<>();
    }

    public boolean add(Claim claim) {
        for (Claim element : claimList) {
            if (element.getClaimId().equals(claim.getClaimId())) return false;
        }
        this.claimList.add(claim);
        return true;
    }


    public boolean remove(String claimId) {
        for (int idx = 0; idx < claimList.size(); idx++) {
            if (claimList.get(idx).getClaimId().equals(claimId)) {
                this.claimList.remove(idx);
                return true;
            }
        }
        return false;
    }


    public Claim retrieve(String claimId) {
        for (Claim element : claimList) {
            if (element.getClaimId().equals(claimId)) return element;
        }
        return null;
    }

    public boolean update(Claim claim) {
        for (int idx = 0; idx < claimList.size(); idx++) {
            if (claimList.get(idx).getClaimId().equals(claim.getClaimId())) {
                this.claimList.set(idx, claim);
                return true;
            }
        }
        return false;
    }

}