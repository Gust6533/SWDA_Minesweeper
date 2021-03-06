import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TEST_Board {
//Note for testing there is a mine at 1,1
	
	@Test
	void defaultStateNotClicked() {
		Board gameBoard = new Board(diffculty.Easy);
		assertEquals(false, gameBoard.beenClicked(0, 0), "default state of unclicked");
	}

	@Test
	void ClickedAfterSet() {
		Board gameBoard = new Board(diffculty.Easy);
		gameBoard.setClicked(0,0);
		assertEquals(true, gameBoard.beenClicked(0, 0), "retruns clicked after set");
	}
	
	@Test
	void ClickedOutOfBoundsTestNegtive() {
		Board gameBoard = new Board(diffculty.Meduim);
		assertEquals(false, gameBoard.beenClicked(-1, -1), "Negtive bounds been clicked");
	}	
	
	@Test
	void ClickedOutOfBoundsTestabove() {
		Board gameBoard = new Board(diffculty.Hard);
		assertEquals(false, gameBoard.beenClicked(200, 200), "too high bounds been clicked");
	}	
	
	@Test
	void IsMineTest11() {
		Board gameBoard = new Board(diffculty.Easy);
		assertEquals(true, gameBoard.isMine(1, 1), "Mine at 1,1");
	}	
	
	@Test
	void IsMineNegtiveBounds() {
		Board gameBoard = new Board(diffculty.Easy);
		assertEquals(false, gameBoard.isMine(-1, -1), " No Mine at -1,-1");
	}	
	
	@Test
	void IsMineHighBounds() {
		Board gameBoard = new Board(diffculty.Meduim);
		assertEquals(false, gameBoard.isMine(200, 200), " No Mine at 200,200");
	}	

	@Test
	void IsMinetestcode() {
		Board gameBoard = new Board(1);
		assertEquals(true, gameBoard.isMine(1, 1), " No Mine at 200,200");
	}	

	@Test
	void testcodeNextToMine00() {
		Board gameBoard = new Board(1);
		assertEquals(1, gameBoard.minesNextTo(0, 0), " checking 0,0 for mines next to");
	}	
	
	@Test
	void testcodeNextToMine11() {
		Board gameBoard = new Board(1);
		assertEquals(2, gameBoard.minesNextTo(1, 1), " checking 1,1 for mines next to");
	}	
	
	@Test
	void testcodeNextToMine21() {
		Board gameBoard = new Board(1);
		assertEquals(2, gameBoard.minesNextTo(2, 1), " checking 2,1 for mines next to");
	}	
	
	@Test
	void testcodeNextToMine31() {
		Board gameBoard = new Board(1);
		assertEquals(0, gameBoard.minesNextTo(3, 1), " checking 2,1 for mines next to");
	}	
	
	@Test
	void testcodeNextToMine01() {
		Board gameBoard = new Board(1);
		assertEquals(2, gameBoard.minesNextTo(0, 1), " checking 0,1 for mines next to");
	}
}
