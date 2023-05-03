package compensation;


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
	private EReview riview = Reporting;
	private String type;
	public EReview m_Review;

	public Claim(){

	}

	public void finalize() throws Throwable {

	}

}