package seleniumWrapper.WebElement;

import java.util.HashMap;

import seleniumWrapper.Commands.CommandInterface;

public class Handler {
    private final HashMap<String, CommandInterface> commandMap = new HashMap<String, CommandInterface>();
    
    public void register(String commandName, CommandInterface command) {
        commandMap.put(commandName, command);
    }
    
    public void execute(String commandName) {
        CommandInterface command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("No command registered for the command: " + commandName);
        }
        command.execute();
    }
}