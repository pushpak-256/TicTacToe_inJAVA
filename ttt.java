public class Main {
	static ArrayList <Integer> playerPositions = new ArrayList<>();
	static ArrayList <Integer> botPositions = new ArrayList<>();
    public static void printGameBoard(char [][] gameBoard) {
    	System.out.println("-------------------");
    	for(char [] row : gameBoard ) {
   	    for(char c : row) {System.out.print(c);}
   	     System.out.println(); }
   	}//printGameBoard
     public static void placePiece (char [][] gameBoard,int pos , String user) {
    	 char symbol= user.equals("player") ?'x' : 'o';
    	 if(symbol=='x') {playerPositions.add(pos);}
    	 else {botPositions.add(pos);}
    	 switch (pos) {
    	 case 1 : gameBoard[0][0]= symbol; break;
    	 case 2 : gameBoard[0][2]= symbol; break;
    	 case 3 : gameBoard[0][4]= symbol; break;
    	 
    	 case 4 : gameBoard[2][0]= symbol; break;
    	 case 5 : gameBoard[2][2]= symbol; break;
    	 case 6 : gameBoard[2][4]= symbol; break;
    			 
    	 case 7 : gameBoard[4][0]= symbol; break;
    	 case 8 : gameBoard[4][2]= symbol; break;
    	 case 9 : gameBoard[4][4]= symbol; break;
    	 default :break;
    	 }   	 
     } // placePiece
     public static String checkWinner() {
    	 List toprow =  Arrays.asList(1,2,3);
    	 List midrow =  Arrays.asList(4,5,6);
    	 List btmrow =  Arrays.asList(7,8,9);
    	 List lowcol =  Arrays.asList(1,4,7);
    	 List midcol = Arrays.asList(2,5,8);
    	 List highcol =  Arrays.asList(3,6,9);
    	 List cross1 =  Arrays.asList(1,5,9);
    	 List cross2 =  Arrays.asList(7,5,8);
    	 ArrayList<List> winning = new ArrayList<List>();
    	 winning.add(toprow);
    	 winning.add(midrow);
    	 winning.add(btmrow);
    	 winning.add(lowcol);
    	 winning.add(midcol);
    	 winning.add(highcol);winning.add(cross1); winning.add(cross2);
    	 for(List l : winning ) {
    		 if(playerPositions.containsAll(l)){return " Congratulations you won ! ";}
    		 else if(botPositions.containsAll(l)) {return " sorry, bot won ";}
    		 else if( playerPositions.size()+botPositions.size() ==9 ) {return "tie";}
    	 }
    	 return "";
    	 }
	public static void main(String[] args) {
  char [][] gameBoard = {
		  {' ','|',' ','|',' '},
		  {'-','+','-','+','-'},
		  {' ','|',' ','|',' '}, 
		  {'-','+','-','+','-'},
		  {' ','|',' ','|',' '},};
   printGameBoard(gameBoard);
   while(true) {
	 Scanner sc = new Scanner (System.in);
	 int playerPos = sc.nextInt();
	 while(playerPositions.contains(playerPos) ||botPositions.contains(playerPos)) {
		 System.out.println("place alredy taken type another pos");
		 playerPos=sc.nextInt();
	 }
    placePiece(gameBoard, playerPos, "player");
    String res =checkWinner();
    if(res.length()>0) {
		 System.out.println(res);break;
	 }
    
    Random rand = new Random();
     int botMove = rand.nextInt(9)+1;
     while(playerPositions.contains(botMove) ||botPositions.contains(botMove)) {
    	 botMove = rand.nextInt(9)+1;	  
     }
     placePiece(gameBoard, botMove, "bot");
	 printGameBoard(gameBoard);
	 
	 res =checkWinner();
	 if(res.length()>0) {
		 System.out.println(res);break;
	 }
	 
   }//while
	 
	}//main
}//class1