package hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/bomber-man/problem?isFullScreen=true
 */
class Result {

    static final int BOMB_INIT = 0;
    static final int BOMB_FULL = 1;
    static final int BOMB_SEC_PLUS = 2;
    static final int BOMB_EXPLOSION = 3;
    static final int BOMB_FINISH = 4;


    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */
    public static List<String> bomberMan(int r, int c, int t, List<String> grid) {
        // Write your code here

        grid = setBomb(grid, BOMB_INIT);
        testPrint(grid,1);


        if (t != 1) {
            t = t % 4;

            if (t == 1) {
                t = 5;
            }
        }
        for (int time = 2; time < t + 1; time++) {
            grid = setBomb(grid, BOMB_SEC_PLUS);
            if (time % 2 == 0) grid = setBomb(grid, BOMB_FULL);
            grid = setBomb(grid, BOMB_EXPLOSION);
            testPrint(grid,time);
        }

        grid = setBomb(grid, BOMB_FINISH);
        testPrint(grid,t);
        return grid;
    }

    public static void testPrint(List<String> grid, int sec) {
        for (int i = 0; i < grid.size(); i++) {
            System.out.println(grid.get(i));
        }

        System.out.println(sec);
        System.out.println(" ");
    }

    /**
     * Bomb Status Change
     *
     * @param grid
     * @param cmd
     * @return
     */
    public static List<String> setBomb(List<String> grid, int cmd) {

        switch (cmd) {
            case BOMB_INIT: {
                for (int i = 0; i < grid.size(); i++) {
                    grid.set(i, grid.get(i).replace("O", "2"));
                    grid.set(i, grid.get(i).replace(".", "0"));
                }
                break;
            }
            case BOMB_FULL: {
                for (int i = 0; i < grid.size(); i++) {
                    grid.set(i, grid.get(i).replace("0", "1"));
                }
                break;
            }
            case BOMB_SEC_PLUS: {
                for (int i = 0; i < grid.size(); i++) {
                    grid.set(i, grid.get(i).replace("3", "4"));
                    grid.set(i, grid.get(i).replace("2", "3"));
                    grid.set(i, grid.get(i).replace("1", "2"));
                }
                break;
            }
            case BOMB_EXPLOSION: {
                for (int i = 0; i < grid.size(); i++) {

                    for (int j = 0; j < grid.get(i).length(); j++) {
                        int check = Integer.parseInt(String.valueOf(grid.get(i).charAt(j)));
                        if (check > 3) {
                            grid = bombExplosion(grid, i, j);
                        }
                    }
                }
                break;
            }
            case BOMB_FINISH: {
                for (int i = 0; i < grid.size(); i++) {
                    grid.set(i, grid.get(i).replace("0", "."));
                    grid.set(i, grid.get(i).replace("1", "O"));
                    grid.set(i, grid.get(i).replace("2", "O"));
                    grid.set(i, grid.get(i).replace("3", "O"));
                }
                break;
            }
        }

        return grid;
    }

    /**
     * Explosion up/down/left/righgt
     *
     * @param grid
     * @param r
     * @param c
     * @return
     */
    public static List<String> bombExplosion(List<String> grid, int r, int c) {


        StringBuffer sb = new StringBuffer();

        sb.append(grid.get(r));
        sb.replace(c, c + 1, "0");
        grid.set(r, sb.toString());


        // up
        if (r > 0) {
            sb = new StringBuffer();
            sb.append(grid.get(r - 1));
            int val = Integer.parseInt(String.valueOf(sb.charAt(c)));
            if (val < 3) {
                sb.replace(c, c + 1, "0");
            }
            grid.set(r - 1, sb.toString());
        }

        // down
        if (r < grid.size() - 1) {
            sb = new StringBuffer();
            sb.append(grid.get(r + 1));

            int val = Integer.parseInt(String.valueOf(sb.charAt(c)));

            if (val < 3) {
                sb.replace(c, c + 1, "0");
            }
            grid.set(r + 1, sb.toString());
        }

        // left
        if (c > 0) {
            sb = new StringBuffer();
            sb.append(grid.get(r));
            int val = Integer.parseInt(String.valueOf(sb.charAt(c - 1)));
            if (val < 3) {
                sb.replace(c - 1, c, "0");
            }

            grid.set(r, sb.toString());
        }

        // right
        if (c < grid.get(r).length() - 1) {
            sb = new StringBuffer();
            sb.append(grid.get(r));
            int val = Integer.parseInt(String.valueOf(sb.charAt(c + 1)));
            if (val < 3) {
                sb.replace(c + 1, c + 2, "0");
            }

            grid.set(r, sb.toString());
        }

        return grid;
    }

}

public class HackerRank_TheBombermanGame {
    public static void main(String[] args) throws IOException {


        //BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\test1.txt")));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\test1.txt")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.bomberMan(r, c, n, grid);

//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
