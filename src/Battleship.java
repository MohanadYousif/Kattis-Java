import java.util.Scanner;

public class Battleship { // kattis - Battleship
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 0; t < testCaseCount; t++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int shots = scanner.nextInt();
            scanner.nextLine();

            char[][] playerOneMap = new char[height][width];
            char[][] playerTwoMap = new char[height][width];

            for (int i = 0; i < height; i++) {
                String line = scanner.nextLine();
                playerOneMap[i] = line.toCharArray();
            }

            for (int i = 0; i < height; i++) {
                String line = scanner.nextLine();
                playerTwoMap[i] = line.toCharArray();
            }
            int playerOneShips = countShips(playerOneMap);
            int playerTwoShips = countShips(playerTwoMap);
            int startShips = playerOneShips + playerTwoShips;

            for (int s = 0; s < shots; s++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine();


                if (playerTwoMap[y][x] == '#') {
                    playerTwoMap[y][x] = '_';
                }


                if (playerOneMap[y][x] == '#') {
                    playerOneMap[y][x] = '_';
                }
            }

            playerOneShips = countShips(playerOneMap);
            playerTwoShips = countShips(playerTwoMap);
            int reminShips = playerOneShips + playerTwoShips;

            if (reminShips == 0 || reminShips == startShips) {
                System.out.println("draw");
            } else if (playerOneShips > playerTwoShips) {
                System.out.println("player one wins");
            } else if (playerOneShips < playerTwoShips){
                System.out.println("player two wins");
            } else {
                System.out.println("draw");
            }
        }

        scanner.close();
    }

    static int countShips(char[][] map) {
        int count = 0;
        for(char[] i : map){
            for(char j :i){
                if(j == '#'){
                    count++;
                }
            }
        }
        return count;
    }
}