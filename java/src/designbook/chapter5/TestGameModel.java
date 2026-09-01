/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2026 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.chapter5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class TestGameModel {
	
	static class StubStrategy implements PlayingStrategy {
		
		private boolean aExecuted = false;
		
		public boolean hasExecuted() { 
			return aExecuted; 
		}
		
		@Override
		public Move computeNextMove(GameModelView pModelView) {
			aExecuted = true;
			return new NullMove();
		}
	}
	
	@Test
	void testTryToAutoPlay() {
		try {
			Field strategyField = GameModel.class.getDeclaredField("aPlayingStrategy");
			strategyField.setAccessible(true);
			StubStrategy strategy = new StubStrategy();
			GameModel model = GameModel.instance();
			strategyField.set(model, strategy);
			model.tryToAutoPlay();
			assertTrue(strategy.hasExecuted());
		}
		catch (ReflectiveOperationException e) {
			fail();
		}
	}
}