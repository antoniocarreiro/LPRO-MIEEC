package dkeep.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dkeep.logic.DragonsBane;

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
		DragonsBane game = new DragonsBane(0);
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
		DragonsBane game = new DragonsBane(0);
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
		DragonsBane game = new DragonsBane(0);
		game.hero.setPosition(game.sword.getPosition());
		assertTrue(game.sword.pickedUp);
		assertSame("A", game.hero.getTitle());
	}
	
	@Test //d)
	public void testGameOver() {
		DragonsBane game = new DragonsBane(65000);
		assertFalse(game.checkGameOver());
		game.newTurn("d");
		assertTrue(game.checkGameOver());
	}

}
