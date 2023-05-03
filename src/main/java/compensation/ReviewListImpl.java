package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:50:00
 */
public interface ReviewListImpl {

	/**
	 * 
	 * @param review
	 */
	public boolean add(EReview review);

	/**
	 * 
	 * @param reviewId
	 */
	public boolean remove(String reviewId);

	/**
	 * 
	 * @param reviewId
	 */
	public EReview retrieve(String reviewId);

	/**
	 * 
	 * @param review
	 */
	public boolean update(EReview review);

}