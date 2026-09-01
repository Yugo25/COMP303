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
package designbook.solutions6;

import java.util.ArrayList;
import java.util.List;

class CommandProcessor2 {

	private final List<UndoableCommand> aExecutedCommands = new ArrayList<>();
	private final List<UndoableCommand> aUndoneCommands = new ArrayList<>();

	public void consume(UndoableCommand pCommand) {
		pCommand.execute();
		aExecutedCommands.add(pCommand);
	}

	public void undoLast() {
		assert !aExecutedCommands.isEmpty();
		UndoableCommand command = aExecutedCommands.removeLast();
		command.undo();
		aUndoneCommands.add(command);
	}

	public void redoLast() {
		assert !aUndoneCommands.isEmpty();
		UndoableCommand command = aUndoneCommands.removeLast();
		consume(command);
	}
}