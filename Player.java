import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Player 
{
	
	private String name;
	private Scanner input;
	private Room currentRoom;
	
	public Player(String name)
	{
		this.name = name;
		this.input = new Scanner(System.in);
		this.currentRoom = null;
	}
	
	public void setCurrentRoom(Room r)
	{
		this.currentRoom = r; 
	}
	
	public void displayToUser(String msg)
	{
		System.out.println(msg);
	}
	
	public void showPrompt()
	{
		System.out.print("> ");
		String userResponse = this.input.nextLine();
		System.out.println(userResponse);
		
		//*******
		//We need to process the players command to move to a new room
		if(userResponse.equalsIgnoreCase("look"))
		{
			this.currentRoom.displayDetailsToUser();
		}
		else if(userResponse.equals("create exit"))
		{
			this.displayToUser("***** Creating Exit *****");
			this.displayToUser("Please enter the name of the exit:" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String exitName = userResponse;
			
			this.displayToUser("Please enter the name of the return exit:" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String returnExit = userResponse;
			
			this.displayToUser("Please enter the name of the new Room" );
			System.out.print("> ");
			userResponse = this.input.nextLine();
			String newRoomName = userResponse;
			
			//Add the new room to our CaveCore
			int newRoomID = CaveCore.addRoomToCave(newRoomName, returnExit, this.currentRoom.getId());
			
			//finally add the exit that leads to the new room here!
			this.currentRoom.addExit(exitName, newRoomID);
			
			this.displayToUser("New Room Created");
			this.showPrompt();
		}
		else if(userResponse.equals("save"))
		{
			this.displayToUser("Saving the Cave");
			this.displayToUser(CaveCore.theCave.toJSON().exportToJSON());
			
			try {
				 File file = new File("C:\\Users\\Johann\\DiceRoller\\CaveCrawler\\src\\CaveJSON");
				    PrintStream ps = new PrintStream(file);
				    System.setOut(ps);
				    System.out.println(CaveCore.theCave.toJSON().exportToJSON());
			    } catch (IOException FileNotFoundException) {
			      System.out.println("There was a problem creating/writing to the temp file");
			      FileNotFoundException.printStackTrace();
			    }
			
			
		}
		else
		{
			this.currentRoom.takeExit(userResponse);
		}
		
	}
}