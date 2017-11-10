package dkeep.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dkeep.logic.DragonsBane;
import dkeep.logic.Map;
import dkeep.logic.*;

public class PositionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test //a)
	public void testHeroToFreeCell() {
		DragonsBane game = new DragonsBane(0, 1);
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(2, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("w");
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(2, game.hero.getY());
		
		game.newTurn("a");
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
	}

	@Test //b)
	public void testHeroToWall() {
		DragonsBane game = new DragonsBane(0, 1);
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("w");
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("a");
		assertEquals(1, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(2, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("d");
		assertEquals(2, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(3, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(4, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(5, game.hero.getX());
		assertEquals(1, game.hero.getY());
		
		game.newTurn("d");
		assertEquals(5, game.hero.getX());
		assertEquals(2, game.hero.getY());
		
		game.newTurn("s");
		assertEquals(5, game.hero.getX());
		assertEquals(2, game.hero.getY());
	}
 
	@Test //c)
	public void testPickUpSword() {
		DragonsBane game = new DragonsBane(0, 2);
		assertEquals('H', game.hero.getTitle());
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(2, game.hero.getY());
		assertEquals('A', game.hero.getTitle());
	}
	
	@Test //d)
	public void testGameOver() {
		DragonsBane game = new DragonsBane(65000, 1);
		assertFalse(game.checkGameOver());
		game.newTurn("w");
		assertTrue(game.checkGameOver());
		
		DragonsBane game2 = new DragonsBane(65000, 1);
		assertFalse(game2.checkGameOver());
		game2.newTurn("a");
		assertTrue(game2.checkGameOver());
		
		DragonsBane game3 = new DragonsBane(65000, 1);
		assertFalse(game3.checkGameOver());
		game3.newTurn("s");
		assertTrue(game3.checkGameOver());
		
		DragonsBane game4 = new DragonsBane(65000, 1);
		assertFalse(game4.checkGameOver());
		game4.newTurn("d");
		assertTrue(game4.checkGameOver());
	}

	@Test //e)
	public void testDragonSlay() {
		DragonsBane game = new DragonsBane(1, 3);
		assertEquals('H', game.hero.getTitle());
		assertEquals(1, game.dragonsCount);
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(2, game.hero.getY());
		assertEquals('A', game.hero.getTitle());
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(3, game.hero.getY());
		assertEquals(0, game.dragonsCount);
	}
	
	@Test //f)
	public void testWinner() {
		DragonsBane game = new DragonsBane(1, 3);
		assertEquals('H', game.hero.getTitle());
		assertEquals(1, game.dragonsCount);
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(2, game.hero.getY());
		assertEquals('A', game.hero.getTitle());
		game.newTurn("d");
		assertEquals(1, game.hero.getX());
		assertEquals(3, game.hero.getY());
		assertEquals(0, game.dragonsCount);
		game.newTurn("s");
		assertEquals(2, game.hero.getX());
		assertEquals(3, game.hero.getY());
		assertFalse(game.checkWinner());
		game.newTurn("d");
		assertEquals(2, game.hero.getX());
		assertEquals(4, game.hero.getY());
		assertTrue(game.checkWinner());
	}
	
}
