package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public class InsuranceReviewList implements InsuranceReviewListImpl {

	private List<InsuranceReview> insuranceReviewList;
	public InsuranceReview m_InsuranceReview;

	public InsuranceReviewList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean add(InsuranceReview insuranceReview){
		return false;
	}

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean remove(InsuranceReview insuranceReview){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public InsuranceReview retrieve(String id){
		return null;
	}

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean update(InsuranceReview insuranceReview){
		return false;
	}

}