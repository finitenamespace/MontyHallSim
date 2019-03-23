import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random(); //our random door picker
        boolean[] doors = new boolean[3]; //generate the doors
        int doorChoice; //our chosen door
        int goatDoor = 0; //the goat door
        int winCount = 0; //store out count of wins

        for(int i = 1; i < 10001; i++){
            //loop through the doors and populate with goats (false) and car (true)
            int x = rand.nextInt(3);
            System.out.println("Winning door: " + x);
            for(int j = 0; j < doors.length; j++){
                //noinspection RedundantIfStatement
                if(x == j){
                    doors[j] = true;
                }else{
                    doors[j] = false;
                }
            }

            //pick our winning door
            int y = rand.nextInt(3);
            System.out.println("We pick door: " + y);
            doorChoice = y;

            //reveal a goat
            for(int j = 0; j < doors.length; j++){
                if(j != y && !doors[j]){
                    //this is the goat
                    System.out.println("Revealing goat door: " + j);
                    goatDoor = j;
                }
            }

            //switch our door choice
            for(int j = 0; j < doors.length; j++){
                if(j != y && j != goatDoor){
                    System.out.println("Switching to door: " + j);
                    doorChoice = j; //our new door
                }
            }

            //check if we win
            if(doors[doorChoice]){
                System.out.println("Winner!");
                winCount++;
            }else{
                System.out.println("Loser!");
            }

            //stats
            System.out.println("Turn count: " + i + " | Win Count: " + winCount +
                    " | % Won: " + String.format("%.2f", ((double)winCount/i)*100)  + "\n" );
        }
    }
}
