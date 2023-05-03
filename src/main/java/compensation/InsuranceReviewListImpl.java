package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:59
 */
public interface InsuranceReviewListImpl {

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean add(InsuranceReview insuranceReview);

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean remove(InsuranceReview insuranceReview);

	/**
	 * 
	 * @param id
	 */
	public InsuranceReview retrieve(String id);

	/**
	 * 
	 * @param insuranceReview
	 */
	public boolean update(InsuranceReview insuranceReview);

}