import java.io.*;
import java.util.*;
class TicTacToe
{
	static ArrayList<Integer> playerPositions=new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions=new ArrayList<Integer>();
	public static void main(String[] args) 
	{


		char gameboard[][]={
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}
		};

		printGameboard(gameboard);

		while(true)
		{
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Your Position(1-9):");
			int playerPos=scan.nextInt();
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions))
			{
				System.out.println("Position Taken ");
				playerPos=scan.nextInt();
			}	

			printPos(gameboard,playerPos,"player");
			String result=checkWinner();
			if(result.length() > 0)
			{
				System.out.println(result);
				printGameboard(gameboard);

				break;
			}

			Random rand=new Random();
			int cpuPos=rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
			{
				//System.out.println("Position Taken ");
				cpuPos=rand.nextInt(9) + 1;
			}	
			System.out.println();

			printPos(gameboard,cpuPos,"cpu");

			printGameboard(gameboard);

			result=checkWinner();
			System.out.println(result);
			if(result.length() > 0)
			{
				System.out.println(result);
				printGameboard(gameboard);

				break;
			}
			System.out.println(result);
		}
	}

	public static void printGameboard(char gameboard[][])
	{
		for(char row[] : gameboard)
		{
			for(char col : row)
			{
				System.out.print(col);
			}
			System.out.println();
		}

	}

	public static void  printPos(char gameboard[][],int pos,String user)
	{
		char symbol=' ';
		if(user.equals("player"))
		{
			symbol='X';
			playerPositions.add(pos);
		}
		else if(user.equals("cpu"))
		{
			symbol='O';
			cpuPositions.add(pos);
		}

		switch(pos)
		{
			case 1: gameboard[0][0]=symbol;
			break;
			case 2: gameboard[0][2]=symbol;
			break;
			case 3: gameboard[0][4]=symbol;
			break;
			case 4: gameboard[2][0]=symbol;
			break;
			case 5: gameboard[2][2]=symbol;
			break;
			case 6: gameboard[2][4]=symbol;
			break;
			case 7: gameboard[4][0]=symbol;
			break;
			case 8: gameboard[4][2]=symbol;
			break;
			case 9: gameboard[4][4]=symbol;
			break;
			default: System.out.print("You Entered Wrong");
			break;
		}

	}

	public static String checkWinner()
	{
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List downRow=Arrays.asList(7,8,9);
		List topCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,5,8);
		List downcol=Arrays.asList(3,6,9);
		List diag1=Arrays.asList(1,5,9);
		List diag2=Arrays.asList(3,5,7);


		List<List> winner=new ArrayList<List>();
		winner.add(topRow);
		winner.add(midRow);
		winner.add(downRow);
		winner.add(topCol);
		winner.add(midCol);
		winner.add(downcol);
		winner.add(diag1);
		winner.add(diag2);

		for (List l : winner ) 
		{
			if (playerPositions.containsAll(l)) 
			{
				return "Congratulation Bacchhee You Won Manpreet Ka Aishrwad Tha tere Pe";	
			}
			else if(cpuPositions.containsAll(l))
			{
				return "Computer Win Yaar Computer Tere Se Accha hai";
			}
			else if(playerPositions.size() + cpuPositions.size() ==9)
			{
				return "Draw" ;
			}
		}

		
		return "";
	}
}