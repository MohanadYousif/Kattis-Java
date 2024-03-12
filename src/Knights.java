import java.util.*;

public class Knights { //Kattis - Knight's Marathon
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();

        System.out.println(minKnightMoves(n, m, startX, startY, endX, endY));
    }

    public static int minKnightMoves(int n, int m, int startX, int startY, int endX, int endY) {
        int[][] moves = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        int[][] distance = new int[n][m];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return distance[x][y];
            }

            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && distance[newX][newY] == Integer.MAX_VALUE) {
                    queue.offer(new int[]{newX, newY});
                    distance[newX][newY] = distance[x][y] + 1;
                }
            }
        }

        return -1;
    }
}