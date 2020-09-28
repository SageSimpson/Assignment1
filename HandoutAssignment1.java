import stanford.karel.SuperKarel;

public class HandoutAssignment1 extends SuperKarel {
	
	/* This is the start of my program. So far, I know
	 * the first steps are to move Karel one space, then 
	 * check the status of the voting boxes
	 */

	public void run() {
		move();
		checkBallot();		
	}
	
	/* There's going to be two scenarios: either a ballot is
	 * legitimate or false. Karel can tell by checking if
	 * a ballot is present in the middle of the voting
	 * boxes
	 * 
	 */
	
	
	private void checkBallot() {
		if (beepersPresent()) {
			fullBallot();         // removes all potential excess ballots, replace
		} else {
			clearBallot();       // removes all ballots, leave empty
		}
	}
	
	private void fullBallot() {             // lines 32-45 involve clearing out ballots (in case of more than one ballot)
		while (beepersPresent()) {
			pickBeeper();
		}
		turnLeft();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		move();
		while (beepersPresent()) {
				pickBeeper();
		}
		turnAround();                    // lines 46-60 involve replacing with ballots and positioning for new Voting Box
		putBeeper();
		move();
		putBeeper();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();
		move();
		if (frontIsClear()) {
			move();
			checkBallot();
		}
	}
	
	private void clearBallot() {          // lines 63-73 involves picking up faulty ballots
		turnLeft();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();                     // lines 74-82 involve positioning for new Voting Box
		move();
		turnRight();
		move();
		if (frontIsClear()) {
			move();
			checkBallot();
		}
	}        
		
}
	
	
