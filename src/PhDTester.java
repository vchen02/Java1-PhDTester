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
		//create 4 PhDs
		PhD grad1 = new PhD("Jacob", 'M', 1989, 6);
		PhD grad2 = new PhD("Annie", 'F', 1992, 7);
		PhD grad3 = new PhD("Frank", 'M', 1990, 10);
		PhD grad4 = new PhD("Bentsy", 'F', 1985, 1);
		
		grad1.addFirstAdvisor(grad2);
		grad1.addSecondAdvisor(grad3);	
		grad2.addFirstAdvisor(grad3);
		grad2.addSecondAdvisor(grad4);
		grad3.addFirstAdvisor(grad4);
		
		assertEquals(grad1.getFirstAdvisor(), grad2);
		assertEquals(grad1.getSecondAdvisor(), grad3);
		assertEquals(grad2.getFirstAdvisor(), grad3);
		assertEquals(grad2.getSecondAdvisor(), grad4);
		assertEquals(grad3.getFirstAdvisor(), grad4);
		assertEquals(grad4.getFirstAdvisor(), null);
		
		assertEquals(grad2.numAdvisees(), 1);
		assertEquals(grad3.numAdvisees(), 2);
		assertEquals(grad4.numAdvisees(), 2);	
	}
	
	@Test
	public void testConstructorC() {
		PhD gradA1 = new PhD("Jacob", 'M', 1989, 6);
		PhD gradA2 = new PhD("Betty", 'F', 1988, 12);
		PhD gradC1 = new PhD("Billy", 'M', 1985, 3, gradA1 );
		PhD gradC2 = new PhD("Westley", 'M', 1984, 1, gradA1, gradA2);
		
		assertEquals(gradC1.getName(), "Billy");
		assertEquals(gradC1.getYear(), 1985);
		assertEquals(gradC1.getMonth(), 3);
		assertEquals(gradC1.isMale(), true);
		assertEquals(gradC1.getFirstAdvisor(), gradA1);
		assertEquals(gradC1.getSecondAdvisor(), null);
		assertEquals(gradC1.numAdvisees(), 0);
		
		assertEquals(gradC2.getName(), "Westley");
		assertEquals(gradC2.getYear(), 1984);
		assertEquals(gradC2.getMonth(), 1);
		assertEquals(gradC2.isMale(), true);
		assertEquals(gradC2.getFirstAdvisor(), gradA1);
		assertEquals(gradC2.getSecondAdvisor(), gradA2);
		assertEquals(gradC2.numAdvisees(), 0);
		
		assertEquals(gradA1.numAdvisees(), 2);
		assertEquals(gradA2.numAdvisees(), 1);
	}
	
	@Test
	public void testYoungerPhD() {
		//create 3 PhDs
		PhD grad1 = new PhD("Jacob", 'M', 1989, 6);
		PhD grad2 = new PhD("Annie", 'F', 1992, 7);
		PhD grad3 = new PhD("Frank", 'M', 1992, 10);
		
		assertEquals(grad1.isYoungerThan(grad2), false);
		assertEquals(grad2.isYoungerThan(grad1), true);
		assertEquals(grad3.isYoungerThan(grad2), true);
		assertEquals(grad2.isYoungerThan(grad3), false);
	}
	
	@Test
	public void testPhDSibling() {
		//create 4 PhDs
		PhD grad1 = new PhD("Jacob", 'M', 1989, 6);
		PhD grad2 = new PhD("Annie", 'F', 1992, 7);
		PhD grad3 = new PhD("Frank", 'M', 1990, 10);
		PhD grad4 = new PhD("Bentsy", 'F', 1985, 1);
				
		grad1.addFirstAdvisor(grad2);
		grad1.addSecondAdvisor(grad3);	
		grad2.addFirstAdvisor(grad3);
		grad2.addSecondAdvisor(grad4);
		grad3.addFirstAdvisor(grad4);
		
		assertEquals(grad1.isPhDSibling(grad2), true);
		assertEquals(grad1.isPhDSibling(grad3), true);
		assertEquals(grad1.isPhDSibling(grad4), false);

		assertEquals(grad2.isPhDSibling(grad3), true);
		assertEquals(grad2.isPhDSibling(grad4), true);
		assertEquals(grad2.isPhDSibling(grad1), true);
		
		assertEquals(grad3.isPhDSibling(grad4), true);
		assertEquals(grad3.isPhDSibling(grad1), true);
		assertEquals(grad3.isPhDSibling(grad2), true);
		
		assertEquals(grad4.isPhDSibling(grad1), false);
		assertEquals(grad4.isPhDSibling(grad2), true);
		assertEquals(grad4.isPhDSibling(grad3), true);
		
		assertEquals(grad1.isPhDSibling(grad1), false);
		assertEquals(grad2.isPhDSibling(grad2), false);
		assertEquals(grad3.isPhDSibling(grad3), false);
		assertEquals(grad4.isPhDSibling(grad4), false);
	}
}
