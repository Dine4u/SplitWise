package com.myimplementation.splitwise.commanddesignpattern;

import com.myimplementation.splitwise.exceptions.InvalidCommandException;

public interface Command {
    void execute(String input) throws InvalidCommandException;
}
