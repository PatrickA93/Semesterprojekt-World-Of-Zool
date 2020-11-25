package commands;

import java.util.Scanner;

public class Parser 
{
    private CommandWords commands;
    private Scanner reader;

    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand(String inputLine)
    {
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next(); 
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    public String getWord(){
        System.out.print("> ");
        return reader.nextLine();
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
