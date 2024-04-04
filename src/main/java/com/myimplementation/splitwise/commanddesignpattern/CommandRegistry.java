package com.myimplementation.splitwise.commanddesignpattern;

import com.myimplementation.splitwise.exceptions.InvalidCommandException;

import java.util.HashMap;

public class CommandRegistry {

     private HashMap<CommandTypes,Command> map;

     private CommandRegistry(){
         map=new HashMap<CommandTypes,Command>();
     }

     private static CommandRegistry commandRegistry=null;

     public static CommandRegistry getInstance(){
         if(commandRegistry==null){
             synchronized (CommandRegistry.class){
                 if(commandRegistry==null){
                     commandRegistry=new CommandRegistry();
                 }
             }
         }

         return commandRegistry;
     }

     public void addCommand(CommandTypes commandTypes,Command command){
         this.map.put(commandTypes,command);
     }

     public Command getCommand(String input) throws InvalidCommandException {
         if(input.toLowerCase().contains("register")){
             if(map.containsKey(CommandTypes.REGISTER)){
                 return map.get(CommandTypes.REGISTER);
             }

             throw new InvalidCommandException("Expected Command feature currently not available");
         }

         throw new InvalidCommandException("Invalid Command");
     }
}
