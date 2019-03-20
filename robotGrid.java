package robotgrid;
import java.util.Arrays;
import java.util.HashMap;
class Point{
	int r,c;
	public Point(int r,int c) {
		this.r =r;
		this.c = c;
	}
}

//The Robot Grid Using DP
class RobotGrid{
public static boolean isReachable(boolean[][] maze,int r,int c,HashMap<Point,Boolean> points) {
	Point P = new Point(r,c);
	if(r==0 && c==0) {
		return true;
	}
	if(r<0 || c<0) {
		points.put(P, false);
	}
	if(points.containsKey(P)) {
		return points.get(P);
	}
	else {
		if(isReachable(maze,r-1,c,points)||isReachable(maze,r,c-1,points)) {
			points.put(P,true);
		}
	}
	return points.get(P);
}

public static void main(String[] args) {
	boolean[][] maze = new boolean[4][4];
	for(int i = 0;i<maze.length;i++) {
		for(int j = 0;i<maze.length;i++) {
			maze[i][j] = true;
		}
	}
	maze[0][1] = false;
	maze[1][0] = false;
	HashMap<Point,Boolean> points= new HashMap<Point,Boolean>();
	System.out.println(isReachable(maze,maze.length-1,maze[0].length-1,points));
}
}
