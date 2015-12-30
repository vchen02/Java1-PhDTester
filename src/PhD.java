/** 	NetId: Victor, Chen 
 * Time spent: hh hours, mm minutes.
 * An instance maintains info about the PhD of a person. 
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
	 *  Precondition: This person's first advisor is known, their second 
	 *  advisor is unknown, p is not null, and p is different from this person's first advisor.
	 */
	public void addSecondAdvisor(PhD p) {
		assert p != null && p != firstAdvisor && secondAdvisor == null && firstAdvisor != null ;
		secondAdvisor = p;
		p.numOfAdvisees++;
	}	
	
}
