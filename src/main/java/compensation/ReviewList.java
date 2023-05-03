package compensation;


/**
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:50:00
 */
public class ReviewList implements ReviewListImpl {

	private List<EReview> reviewList;
	public EReview m_Review;

	public ReviewList(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param review
	 */
	public boolean add(EReview review){
		return false;
	}

	/**
	 * 
	 * @param reviewId
	 */
	public boolean remove(String reviewId){
		return false;
	}

	/**
	 * 
	 * @param reviewId
	 */
	public EReview retrieve(String reviewId){
		return null;
	}

	/**
	 * 
	 * @param review
	 */
	public boolean update(EReview review){
		return false;
	}

}