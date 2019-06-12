package math;

public class ClockAngles {
	/*
	 * Given a time, calculate the angle between the hour and minute hands 
	 */

	
	public static void main(String[] args) {
		
	}
	
	
	static double angles(int hour, int minutes) {
		double minAngle = (360/60)*minutes;
		double hourAngle = (360/12)*hour + (minutes/2);
		return Math.abs(hourAngle - minAngle);
		
		// reduces to 30*hours - 5.5*minutes 
	}
}
