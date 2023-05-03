package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public class InsuranceClaim {

	private String accidentType;
	private int compensation;
	private String customerId;
	private Date date;
	private String description;
	private List<File> documents;
	private String insuranceClaimId;
	private File investigationReport;
	private String invetigatorId;
	private String location;
	private List<String> progressList;

	public InsuranceClaim(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param date
	 * @param description
	 * @param documents
	 * @param id
	 * @param location
	 * @param type
	 */
	public InsuranceClaim InsuranceClaim(Date date, String description, List<File> documents, String id, String location, String type){
		return null;
	}

	/**
	 * 
	 * @param progress
	 */
	public boolean addProgress(String progress){
		return false;
	}

	public boolean informRecentProgress(){
		return false;
	}

	/**
	 * 
	 * @param compensation
	 */
	public boolean setCompensation(int compensation){
		return false;
	}

	/**
	 * 
	 * @param file
	 */
	public boolean setInvestigationFile(File file){
		return false;
	}

	/**
	 * 
	 * @param investigator
	 */
	public boolean setInvestigator(String investigator){
		return false;
	}

}