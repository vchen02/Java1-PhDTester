/** 	NetId: Victor, Chen 
 * Time spent: 03 hours, 37 minutes.
 * An instance maintains info about the PhD of a person.
 * 
 */

/** An instance of a person with an PhD */
public class PhD {

	private String name;	//name of the person with a PhD, a length of name > 0
	private int year;		//year PhD was awarded
	private int month;		//month the PhD was awarded. In range 1..12, with 1 meaning January, etc
	private char gender;	//'M' means male and 'F' means female 
	private PhD firstAdvisor;//The first PhD advisor of this person —null if unknown
	private PhD secondAdvisor;/*The second advisor of this person
							  -null if unknown or if the person had only one advisor
							  -if the first-advisor field is null, 
							  the second advisor field must be null */
	private int numOfAdvisees; //number of PhD advisees of this person
	
	/** Constructor: an instance for a person with name n, gender g, PhD year y, 
	 * and PhD month m. Its advisors are unknown, and it has no advisees.
	 * 
	 * Precondition: n has at least 1 character, m is in 1..12, and g is 'M' for male 
	 * or 'F' for female.
	 */
	PhD(String n, char g, int y, int m) {
		
		//Check Preconditions
		assert n.length() > 0;
		assert g == 'M' || g == 'F';
		assert m > 0 || m < 13;
		
		//Initialize instance variables
		name = n;
		year = y;
		month = m;
		gender = g;
		firstAdvisor = null;
		secondAdvisor = null;
		numOfAdvisees = 0;
	}

	/** Constructor: a PhD with name n, gender g, PhD year y, PhD month m, first
	 * advisor adv, and no second advisor.
	 * 
	 * Precondition: n has at least 1 char, g is 'F' for female or 'M' for male, m is in
	 * 1..12, and adv is not null.
	 */
	PhD(String n, char g, int y, int m, PhD adv) {
		//Call above constructor to set name, gender, year, and month values
		this(n, g, y, m);
		
		//Check extra precondition
		assert adv != null;
		
		firstAdvisor = adv;
		adv.numOfAdvisees++;
	}
	
	/** Constructor: a PhD with name n, gender g, PhD year y, PhD month m, first
	 * advisor adv1, and second advisor adv2.
	 * 
	 * Precondition: n has at least 1 char, g is 'F' for female or 'M' for male, m is in
	 * 1..12, adv1 and adv2 are not null, and adv1 and adv2 are different.
	 */
	PhD(String n, char g, int y, int m, PhD adv1, PhD adv2) {
		//Call above constructor to set name, gender, year, month, and first advisor values
		this(n, g, y, m, adv1);
		
		//Check extra precondition
		assert adv2 != null && adv1 != adv2;
		
		secondAdvisor = adv2;
		adv2.numOfAdvisees++;
	}
	
	/** Return this person's name. */
	public String getName() {
		return name;
	}
	
	/** Return the year this person got their PhD */
	public int getYear() {
		return year;
	}
	
	/** Return the month this person got their PhD */
	public int getMonth() {
		return month;
	}
	
	/** Return the value of the sentence "this person is a male.” */
	public boolean isMale() {
		return (gender == 'M');
	}
	
	/** Return this PhD's first advisor, null if unknown */
	public PhD getFirstAdvisor() {
		return firstAdvisor;
	}
	
	/** Return this PhD's second advisor, null if unknown or nonexistent */
	public PhD getSecondAdvisor() {
		return secondAdvisor;
	}
	
	/** Return the number of PhD advisees of this person */
	public int numAdvisees() {
		return numOfAdvisees;
	}
	
	/** Add p as this person's first PhD advisor.
	 *  Precondition: this person's first advisor is unknown and p is not null.
	 */
	public void addFirstAdvisor(PhD p) {
		assert p != null && firstAdvisor == null;
		firstAdvisor = p;
		p.numOfAdvisees++;
	}
	
	/** Add p as this persons second advisor.
	 * 
	 *  Precondition: This person's first advisor is known, their second 
	 *  advisor is unknown, p is not null, and p is different from this person's first advisor.
	 */
	public void addSecondAdvisor(PhD p) {
		assert p != null && p != firstAdvisor && secondAdvisor == null && firstAdvisor != null ;
		secondAdvisor = p;
		p.numOfAdvisees++;
	}	
	
	/** Return value of "this person got their PhD after p did."
	 * 
	 * Precondition: p is not null.
	 */
	public boolean isYoungerThan(PhD p) {
		//test  precondition
		assert p != null;
		
		return (year == p.getYear() && month > p.getMonth()) || year > p.getYear(); 
	}
	
	/** Return value of "this person and p are intellectual siblings.”
	 * 
	 * Note: if p is null, they are not siblings.
	 */
	public boolean isPhDSibling(PhD p) {
		
		return ( p == null ? false : 
				( (firstAdvisor == p || secondAdvisor == p) ? true :
				( numOfAdvisees != 0 ? p.getFirstAdvisor() == this || p.getSecondAdvisor() == this : false )));	
	}
	
}
