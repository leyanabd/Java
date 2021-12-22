/**
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.util.HashMap;
import java.util.Map;

public class TestCases extends CyclicIterator<Map<String, Configuration>> {

	public static String LEG_LEFTUPPER_BODY_JOINT_NAME = "leg leftupper body joint";
	public static String LEG_LEFTUPPER_MIDDLE_JOINT_NAME = "left leftupper middle joint";
	public static String LEG_LEFTUPPER_LOWER_JOINT_NAME = "left leftupper lower joint";
	
	public static String LEG_LEFTMIDDLE_BODY_JOINT_NAME = "leg leftmiddle body joint";
	public static String LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME = "left leftmiddle middle joint";
	public static String LEG_LEFTMIDDLE_LOWER_JOINT_NAME = "left leftmiddle lower joint";
	
	public static String LEG_LEFTLOWER_BODY_JOINT_NAME = "leg leftlower body joint";
	public static String LEG_LEFTLOWER_MIDDLE_JOINT_NAME = "left leftlower middle joint";
	public static String LEG_LEFTLOWER_LOWER_JOINT_NAME = "left leftlower lower joint";
	
	public static String LEG_RIGHTUPPER_BODY_JOINT_NAME = "leg rightupper body joint";
	public static String LEG_RIGHTUPPER_MIDDLE_JOINT_NAME = "left rightupper middle joint";
	public static String LEG_RIGHTUPPER_LOWER_JOINT_NAME = "left rightupper lower joint";
	
	public static String LEG_RIGHTMIDDLE_BODY_JOINT_NAME = "leg righttmiddle body joint";
	public static String LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME = "left rightmiddle middle joint";
	public static String LEG_RIGHTMIDDLE_LOWER_JOINT_NAME = "left rightmiddle lower joint";
  	
	public static String LEG_RIGHTLOWER_BODY_JOINT_NAME = "leg rightlower body joint";
	public static String LEG_RIGHTLOWER_MIDDLE_JOINT_NAME = "left rightlower middle joint";
	public static String LEG_RIGHTLOWER_LOWER_JOINT_NAME = "left rightlower lower joint";
	
  	public static String HEAD_NAME = "head";
  	public static String UPPER_BODY_NAME = "upperbody";
  	public static String LOWER_BODY_NAME = "lowerbody";
  	
  	public static String ANTENNA1_BODY_JOINT_NAME = "antenna1 body joint"; 
  	public static String ANTENNA1_MIDDLE_JOINT_NAME = "antenna1 middle joint"; 
  	public static String ANTENNA1_LOWER_JOINT_NAME = "antenna1 lower joint"; 

  	public static String ANTENNA2_BODY_JOINT_NAME = "antenna2 body joint"; 
  	public static String ANTENNA2_MIDDLE_JOINT_NAME = "antenna2 middle joint"; 
  	public static String ANTENNA2_LOWER_JOINT_NAME = "antenna2 lower joint"; 

	Map<String, Configuration> stop() {
		return this.stop;
	}

	private final Map<String, Configuration> stop;

	@SuppressWarnings("unchecked")
	TestCases() {
		this.stop = new HashMap<String, Configuration>();
		final Map<String, Configuration> grab = new HashMap<String, Configuration>();
		final Map<String, Configuration> attack = new HashMap<String, Configuration>();
		final Map<String, Configuration> wave = new HashMap<String, Configuration>();
		final Map<String, Configuration> fall = new HashMap<String, Configuration>();
		
		super.add(stop, grab, attack, wave, fall);

		// the upper arm, forearm, and hand angles do not change through any of the
		// test cases
		
		

		// the BASIC stop test case
		stop.put(LEG_LEFTUPPER_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(10,0, 0));
		stop.put(LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTLOWER_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_LEFTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		stop.put(LEG_RIGHTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTLOWER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(LEG_RIGHTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		stop.put(ANTENNA1_BODY_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		stop.put(ANTENNA1_MIDDLE_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		stop.put(ANTENNA1_LOWER_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		stop.put(ANTENNA2_BODY_JOINT_NAME, new BaseConfiguration(0, -5, 5));
		stop.put(ANTENNA2_MIDDLE_JOINT_NAME, new BaseConfiguration(0, -5, 5));
		stop.put(ANTENNA2_LOWER_JOINT_NAME, new BaseConfiguration(0, -5, 5));
		
		// the grab/carry test case
		grab.put(LEG_LEFTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, 15, 10));
		grab.put(LEG_LEFTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 15, 10));
		grab.put(LEG_LEFTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 15, 10));
		grab.put(LEG_LEFTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(10,0, 0));
		grab.put(LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		grab.put(LEG_LEFTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		grab.put(LEG_LEFTLOWER_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		grab.put(LEG_LEFTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		grab.put(LEG_LEFTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		grab.put(LEG_RIGHTUPPER_BODY_JOINT_NAME, new BaseConfiguration(10, -15, -0));
		grab.put(LEG_RIGHTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, -15, 10));
		grab.put(LEG_RIGHTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(10, -15, 10));
		grab.put(LEG_RIGHTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(LEG_RIGHTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(LEG_RIGHTLOWER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(LEG_RIGHTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(LEG_RIGHTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		grab.put(ANTENNA1_BODY_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		grab.put(ANTENNA1_MIDDLE_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		grab.put(ANTENNA1_LOWER_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		grab.put(ANTENNA2_BODY_JOINT_NAME, new BaseConfiguration(0, -5, 7));
	    grab.put(ANTENNA2_MIDDLE_JOINT_NAME, new BaseConfiguration(0, -5, 7));
		grab.put(ANTENNA2_LOWER_JOINT_NAME, new BaseConfiguration(0, -5, 7));
		
		//attack pose-- back legs towards back, front forwards, same antennas as grab 
		
		attack.put(LEG_LEFTUPPER_BODY_JOINT_NAME, new BaseConfiguration(10, 15, 5));
		attack.put(LEG_LEFTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 15, 5));
		attack.put(LEG_LEFTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(10, 15, 5));
		attack.put(LEG_LEFTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(10,0, 0));
		attack.put(LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		attack.put(LEG_LEFTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		attack.put(LEG_LEFTLOWER_BODY_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		attack.put(LEG_LEFTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		attack.put(LEG_LEFTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		attack.put(LEG_RIGHTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, -15, 5));
		attack.put(LEG_RIGHTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, -15, 5));
		attack.put(LEG_RIGHTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, -15, 5));
		attack.put(LEG_RIGHTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		attack.put(LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		attack.put(LEG_RIGHTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		attack.put(LEG_RIGHTLOWER_BODY_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		attack.put(LEG_RIGHTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		attack.put(LEG_RIGHTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		attack.put(ANTENNA1_BODY_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		attack.put(ANTENNA1_MIDDLE_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		attack.put(ANTENNA1_LOWER_JOINT_NAME, new BaseConfiguration(0, 5, 5));
		attack.put(ANTENNA2_BODY_JOINT_NAME, new BaseConfiguration(0, -5, 7));
	    attack.put(ANTENNA2_MIDDLE_JOINT_NAME, new BaseConfiguration(0, -5, 7));
		attack.put(ANTENNA2_LOWER_JOINT_NAME, new BaseConfiguration(0, -5, 7));
		
		// wave, left upper going upwards, antennas going upwards, only the left upper going up
		
		wave.put(LEG_LEFTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(LEG_LEFTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(LEG_LEFTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(LEG_LEFTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(10,0, 0));
		wave.put(LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		wave.put(LEG_LEFTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		wave.put(LEG_LEFTLOWER_BODY_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		wave.put(LEG_LEFTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		wave.put(LEG_LEFTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(10, -15, 0));
		wave.put(LEG_RIGHTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		wave.put(LEG_RIGHTLOWER_BODY_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		wave.put(LEG_RIGHTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		wave.put(LEG_RIGHTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 15, 0));
		wave.put(ANTENNA1_BODY_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(ANTENNA1_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(ANTENNA1_LOWER_JOINT_NAME, new BaseConfiguration(-10, 15, 15));
		wave.put(ANTENNA2_BODY_JOINT_NAME, new BaseConfiguration(5, -10, 5));
	    wave.put(ANTENNA2_MIDDLE_JOINT_NAME, new BaseConfiguration(5, -10, 5));
		wave.put(ANTENNA2_LOWER_JOINT_NAME, new BaseConfiguration(5, -10, 5));
		
		
		// free falling -- all limbs going crazy, antennas different, lower body moving up
		fall.put(LEG_LEFTUPPER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(-10,0, 0));
		fall.put(LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTLOWER_BODY_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_LEFTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(-10, 0, 0));
		fall.put(LEG_RIGHTUPPER_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTUPPER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTUPPER_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTMIDDLE_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTMIDDLE_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTLOWER_BODY_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTLOWER_MIDDLE_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(LEG_RIGHTLOWER_LOWER_JOINT_NAME, new BaseConfiguration(10, 0, 0));
		fall.put(ANTENNA1_BODY_JOINT_NAME, new BaseConfiguration(-10, 5, 5));
		fall.put(ANTENNA1_MIDDLE_JOINT_NAME, new BaseConfiguration(-10, 5, 5));
		fall.put(ANTENNA1_LOWER_JOINT_NAME, new BaseConfiguration(-10, 5, 5));
		fall.put(ANTENNA2_BODY_JOINT_NAME, new BaseConfiguration(7, -5, 5));
		fall.put(ANTENNA2_MIDDLE_JOINT_NAME, new BaseConfiguration(7, -5, 5));
		fall.put(ANTENNA2_LOWER_JOINT_NAME, new BaseConfiguration(7, -5, 5));
	}
}
