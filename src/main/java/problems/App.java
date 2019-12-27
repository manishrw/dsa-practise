package problems;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        H149 solution = new H149(true);
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int result = solution.maxPoints(points);
        System.out.println(result);
    }
}
