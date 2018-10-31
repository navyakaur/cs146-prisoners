package sjsu.kaur.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

//this is testing the PrisonerCircle Class and making sure it is finding the winner properly
public class PrisonerCircleTest {

	@Test
	public void testSetUp() {
		PrisonerCircle prisoners = new PrisonerCircle();

	    assertTrue(prisoners.isEmpty()); //checking if list is empty

	    assertEquals(0, prisoners.size()); //checking if size is 0

	    prisoners.insert(new Node(5));

	    assertFalse(prisoners.isEmpty()); //checking if list is not empty after insertion

	    assertEquals(1,prisoners.size()); //checking size is 1
	}
	
	@Test
	public void testFindWinner() {
		PrisonerCircle prisoners = new PrisonerCircle();
		
		Node winner = new Node(1);
		
		prisoners.insert(winner);
	
		//testing if method works if prisoners is size 1
		assertEquals(winner,prisoners.findWinner(prisoners.getFirst(), 9));
		
		prisoners.insert(new Node(2));
		prisoners.insert(new Node(3));
		prisoners.insert(new Node(4));
		prisoners.insert(new Node(5));
		prisoners.insert(new Node(6));
		
		Node found = prisoners.findWinner(prisoners.getFirst(), 2);

		assertEquals(winner,found);
	}
	
	public void testFindWinner1() {
		PrisonerCircle prisoners = new PrisonerCircle();
	
		
		prisoners.insert(new Node(1));
		prisoners.insert(new Node(2));
		prisoners.insert(new Node(3));
		Node winner = new Node(4);
		prisoners.insert(winner);
		prisoners.insert(new Node(5));
		prisoners.insert(new Node(6));
		prisoners.insert(new Node(7));
		
		Node found = prisoners.findWinner(prisoners.getFirst(), 7);
		
		assertEquals(winner,found);
	}
	
	public void testFindWinner2() {
		PrisonerCircle prisoners = new PrisonerCircle();
	
		
		prisoners.insert(new Node(1));
		Node winner = new Node(2);
		prisoners.insert(winner);
		
		Node found = prisoners.findWinner(prisoners.getFirst(), 8);
		
		assertEquals(winner,found);
	}

	public void testFindWinner3() {
		PrisonerCircle prisoners = new PrisonerCircle();
	
		
		prisoners.insert(new Node(1));
		prisoners.insert(new Node(2));
		Node winner = new Node(3);
		prisoners.insert(winner);
		prisoners.insert(new Node(4));
		prisoners.insert(new Node(5));
		
		Node found = prisoners.findWinner(prisoners.getFirst(), 1);
		
		assertEquals(winner,found);
	}
}
