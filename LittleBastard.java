package competicao;
import robocode.*;
import java.awt.Color;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * LittleBastard - a robot by (Vinicios, Ítalo e Gustavo)
 */
public class LittleBastard extends Robot
{
	int dist = 50; // Distance to move when hit by a bullet
	/**
	 * run: LittleBastard's default behavior
	 */
	public void run() {


		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:


		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
       setBodyColor(Color.red);
		setGunColor(Color.black);
		setRadarColor(Color.yellow);
		setBulletColor(Color.green);
		setScanColor(Color.green);
		



     //ajusta o radar com o canhão 
	while (true) {
			turnGunRight(5);
		}
		}


		// Robot main loop
		public void onScannedRobot(ScannedRobotEvent e) {
		// If the other robot is close by, and we have plenty of life,
		// fire hard!
		if (e.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		} // otherwise, fire 1.
		else {
			fire(2);
		}
		// Call scan again, before we turn the gun
		scan();
	}

	/**
	 * Reacts to being hit by turning perpendicular to the incoming bullet and moving
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

		ahead(dist);
		dist *= -1;
		scan();
	}

	/**
	 * Targets and fires at robots that collide with this robot
	 */
	public void onHitRobot(HitRobotEvent e) {
		double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());

		turnGunRight(turnGunAmt);
		fire(2);
	}
}
