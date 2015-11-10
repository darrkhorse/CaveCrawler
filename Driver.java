import java.io.File;
import java.util.Scanner;


public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/caveJSON"));
		String theJSON = "";
		while(input.hasNextLine())
		{
			theJSON = theJSON + input.nextLine();
		}
		System.out.println(theJSON);
		

		for(int i = 0; i < theJSON.length(); i++)
		{
			
			if(theJSON.charAt(i) == '{')
			{
				System.out.println("JSONObject start");
			}
			else if(theJSON.charAt(i) == '}')
			{
				System.out.println("JSONObject end");
			}
			else if(theJSON.charAt(i) == '[')
			{
				System.out.println("JSONArray start");
			}
			else if(theJSON.charAt(i) == ']')
			{
				System.out.println("JSONArray end");
			}
		}

		/*
		Room caveEntrance = new Room("The Cave Entrance");
		Room room2 = new Room("Room #2");
		caveEntrance.addExit("north", room2);
		room2.addExit("south", caveEntrance);
		
		Player thePlayer = new Player("The Follower");
		caveEntrance.addThePlayer(thePlayer);
		*/
	}
	
}