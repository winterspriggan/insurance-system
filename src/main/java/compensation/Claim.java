package compensation;


import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:57
 */
public class Claim {

	private String claimId;
	private int compensation;
	private String customerId;
	private Date date;
	private String description;
	private List<File> documents;
	private String employeeId;
	private boolean isPaid;
	private String location;
	private File report;
	private String reviewer;
	private Review riview = Review.Reviewing;
	private String type;

	public Claim(){

	}

	public void finalize() throws Throwable {

	}

}