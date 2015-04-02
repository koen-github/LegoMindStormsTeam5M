package klasV1M.TI;

import java.util.LinkedList;

import klasV1M.TI.sensoren.MyColorSensor;
import klasV1M.TI.sensoren.MyLightSensor;
import klasV1M.TI.sensoren.MyUltraSonicSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorConstants;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;

/**
 * Provides global access to the sensors and motors.
 * TODO:
 * - Test if synchronized access is needed/change class into a Singleton?
 * @author Remco
 *
 */
public class Globals {
	/**
	 * Standard delay for updating.
	 */
	public static int StandardDelay = 200;
	
	public static int LongDelay = 10000;
	
	/**
	 * The threshold {@link MyLightSensor}'s and {@link MyColorSensor}'s values
	 * need to be equal or lower to, to be considered of the color black.
	 * Value needs to be between 0-100
	 */
	public static int BlackThreshold = 35;
	
	public static int LowSpeed = 20;
	public static int NormalSpeed = 2 * LowSpeed;
	public static int HighSpeed = 3 * LowSpeed;
	public static int MaxSpeed = 5 * LowSpeed;
	
	public static int TimeThreshold = 10000 / LowSpeed;
	
	/**
	 * The cone of vision in degrees of the {@link MyUltraSonicSensor}
	 */
	public static int ConeOfVision = 20;

	/**
	 * The {@link MyColorSensor} mounted on the front-right
	 */
	public static MyColorSensor MCS = new MyColorSensor(SensorPort.S1);//, SensorConstants.TYPE_LIGHT_ACTIVE);
	/**
	 * The {@link MyLightSensor} mounted on the front-left
	 */
	public static MyLightSensor MLS = new MyLightSensor(SensorPort.S2);
	/**
	 * The {@link MyUltraSonicSensor} mounted on the front
	 */
	public static MyUltraSonicSensor MUS = new MyUltraSonicSensor(SensorPort.S4);

	/**
	 * The right {@link NXTRegulatedMotor}
	 */
	public static NXTRegulatedMotor mRight = Motor.A;
	/**
	 * The middle {@link NXTRegulatedMotor}
	 */
	public static NXTRegulatedMotor mMiddle = Motor.B;
	/**
	 * The left {@link NXTRegulatedMotor}
	 */
	public static NXTRegulatedMotor mLeft = Motor.C;

	public static LinkedList<Float[]> angleAndCM = new LinkedList<Float[]>();

	public static void playSong() {
		Sound.setVolume(Sound.VOL_MAX);
		// NOTE: This tune was generated from a midi using Guy
		// Truffelli's Brick Music Studio www.aga.it/~guy/lego
		short[] note = { 2349, 115, 0, 5, 1760, 165, 0, 35, 1760, 28, 0, 13,
				1976, 23, 0, 18, 1760, 18, 0, 23, 1568, 15, 0, 25, 1480, 103,
				0, 18, 1175, 180, 0, 20, 1760, 18, 0, 23, 1976, 20, 0, 20,
				1760, 15, 0, 25, 1568, 15, 0, 25, 2217, 98, 0, 23, 1760, 88, 0,
				33, 1760, 75, 0, 5, 1760, 20, 0, 20, 1760, 20, 0, 20, 1976, 18,
				0, 23, 1760, 18, 0, 23, 2217, 225, 0, 15, 2217, 218 };
		for (int i = 0; i < note.length; i += 2) {
			final short w = note[i + 1];
			final int n = note[i];
			if (n != 0)
				Sound.playTone(n, w * 10);
			try {
				Thread.sleep(w * 2);
			} catch (InterruptedException e) {
			}
		}
		Sound.setVolume(0);
	}
}
