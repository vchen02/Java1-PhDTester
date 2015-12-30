import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhDTester {
	
	@Test
	public void testConstructorA() {
		//Test male PhD constructor
		PhD male_grad = new PhD("Jacob", 'M', 1989, 6);
		assertEquals(male_grad.getName(), "Jacob");
		assertEquals(male_grad.getYear(), 1989);
		assertEquals(male_grad.getMonth(), 6);
		assertEquals(male_grad.isMale(), true);
		assertEquals(male_grad.getFirstAdvisor(), null);
		assertEquals(male_grad.getSecondAdvisor(), null);
		assertEquals(male_grad.numAdvisees(), 0);
		
		//Test female PhD constructor
		PhD female_grad = new PhD("Betty", 'F', 1988, 12);
		assertEquals(female_grad.getName(), "Betty");
		assertEquals(female_grad.getYear(), 1988);
		assertEquals(female_grad.getMonth(), 12);
		assertEquals(female_grad.isMale(), false);
		assertEquals(female_grad.getFirstAdvisor(), null);
		assertEquals(female_grad.getSecondAdvisor(), null);
		assertEquals(female_grad.numAdvisees(), 0);
	}
	
	@Test
	public void testAdvisorSetterMethodsB() {
		//create 6 PhDs
		PhD grad1 = new PhD("Jacob", 'M', 1989, 6);
		PhD grad2 = new PhD("Bentsy", 'F', 1985, 1);
		PhD grad3 = new PhD("Annie", 'F', 1992, 7);
		PhD grad4 = new PhD("Frank", 'M', 1990, 10);
		PhD grad5 = new PhD("Chris", 'M', 1987, 11);
		PhD grad6 = new PhD("Noah", 'M', 1982, 3);
		
		grad1.addFirstAdvisor(grad2);
		grad1.addSecondAdvisor(grad3);
		assertEquals(grad1.getFirstAdvisor(), grad2);
		assertEquals(grad1.getSecondAdvisor(), grad3);
		assertEquals(grad2.numAdvisees(), 1);
		assertEquals(grad3.numAdvisees(), 1);
		
		grad2.addFirstAdvisor(grad3);
		assertEquals(grad3.numAdvisees(), 2);
	}	
}
