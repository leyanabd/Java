
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jogamp.opengl.util.gl2.GLUT;



public class INSECT extends Component implements Animate, Selection{
	/** The OpenGL utility toolkit object. */
	private final GLUT glut = new GLUT();
	 
	/* The head to be modeled */ 
	private final Component head;
	
	/*The upper body attached to the head, to be modeled */ 
	private final Component upperBody; 
	
	/*The lower, back body attached to the upper body to be modeled */ 
	private final Component lowerBody; 
	
	/*The legs attached to the upper body to be modeled */ 
	private final Leg[] legs; 
	
	/* The set of all components */ 
	private final List<Component> components; 
	
	/*The set of components which are currently selected for rotation */ 
	private final Set<Component> selectedComponents = new HashSet<Component>(26); 
	
	 
	/** The color for components which are selected for rotation. */
	public static final FloatColor ACTIVE_COLOR = FloatColor.RED;
  	/** The color for components which are not selected for rotation. */
	public static final FloatColor INACTIVE_COLOR = FloatColor.DARK_GRAY; 
	
	/* Initial position of component on the scene */ 
	public static final Point3D INITIAL_POSITION = new Point3D(0, 0, 0); 
	
	/** The radius of the components which comprise the insect. */
	public static final double INSECT_RADIUS = 0.1;
	/** The height of the body joint on each of the legs. */
	public static final double BODY_JOINT_HEIGHT = -0.5;
	/** The radius of each joint which comprises the leg. */
	public static final double LEG_RADIUS = 0.04;
	/** The radius of the lower body */ 
	public static final double LOWER_BODY_RADIUS = 0.65; 
	/** The radius of the upper body */ 
	public static final double UPPER_BODY_RADIUS = 0.45; 
	/**The height of the lower body */
	public static final double LOWER_BODY_HEIGHT = -0.5; 
	/** The height of the upper BODY. */
	public static final double UPPER_BODY_HEIGHT = -1.5;
	/** The radius of the head. */
	public static final double HEAD_RADIUS = 0.4;
	/** The height of the middle joint on each of the legs. */
	public static final double MIDDLE_JOINT_HEIGHT = -0.5;
	/** The height of the upper joint on each of the legs. */
	public static final double LOWER_JOINT_HEIGHT = -0.5;
	
	/** The height of the ant's atenna **/
	public static final double ANTENNA_HEIGHT = -0.5; 

	
	
	public static final String LEG_LEFTUPPER_BODY_JOINT_NAME = "leg leftupper body joint";
	public static final String LEG_LEFTUPPER_MIDDLE_JOINT_NAME = "left leftupper middle joint";
	public static final String LEG_LEFTUPPER_LOWER_JOINT_NAME = "left leftupper lower joint";
	
	public static final String LEG_LEFTMIDDLE_BODY_JOINT_NAME = "leg leftmiddle body joint";
	public static final String LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME = "left leftmiddle middle joint";
	public static final String LEG_LEFTMIDDLE_LOWER_JOINT_NAME = "left leftmiddle lower joint";
	
	public static final String LEG_LEFTLOWER_BODY_JOINT_NAME = "leg leftlower body joint";
	public static final String LEG_LEFTLOWER_MIDDLE_JOINT_NAME = "left leftlower middle joint";
	public static final String LEG_LEFTLOWER_LOWER_JOINT_NAME = "left leftlower lower joint";
	
	public static final String LEG_RIGHTUPPER_BODY_JOINT_NAME = "leg rightupper body joint";
	public static final String LEG_RIGHTUPPER_MIDDLE_JOINT_NAME = "left rightupper middle joint";
	public static final String LEG_RIGHTUPPER_LOWER_JOINT_NAME = "left rightupper lower joint";
	
	public static final String LEG_RIGHTMIDDLE_BODY_JOINT_NAME = "leg righttmiddle body joint";
	public static final String LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME = "left rightmiddle middle joint";
	public static final String LEG_RIGHTMIDDLE_LOWER_JOINT_NAME = "left rightmiddle lower joint";
  	
	public static final String LEG_RIGHTLOWER_BODY_JOINT_NAME = "leg rightlower body joint";
	public static final String LEG_RIGHTLOWER_MIDDLE_JOINT_NAME = "left rightlower middle joint";
	public static final String LEG_RIGHTLOWER_LOWER_JOINT_NAME = "left rightlower lower joint";
	
  	public static final String HEAD_NAME = "head";
  	public static final String UPPER_BODY_NAME = "upperbody";
  	public static final String LOWER_BODY_NAME = "lowerbody";
  	
  	public static final String ANTENNA1_BODY_JOINT_NAME = "antenna1 body joint"; 
  	public static final String ANTENNA1_MIDDLE_JOINT_NAME = "antenna1 middle joint"; 
  	public static final String ANTENNA1_LOWER_JOINT_NAME = "antenna1 lower joint"; 

  	public static final String ANTENNA2_BODY_JOINT_NAME = "antenna2 body joint"; 
  	public static final String ANTENNA2_MIDDLE_JOINT_NAME = "antenna2 middle joint"; 
  	public static final String ANTENNA2_LOWER_JOINT_NAME = "antenna2 lower joint"; 
  	
  	private Component mapNum2Component(int componentNum) {
  		switch(componentNum) {
  			case  0: return this.head;
			case  1: return this.upperBody;
			case  2: return this.lowerBody;
			case  3: return this.legs[0].lowerJoint();
			case  4: return this.legs[0].middleJoint();
			case  5: return this.legs[0].bodyJoint();
			case  6: return this.legs[1].lowerJoint();
			case  7: return this.legs[1].middleJoint();
			case  8: return this.legs[1].bodyJoint();
			case  9: return this.legs[2].lowerJoint();
			case 10: return this.legs[2].middleJoint();
			case 11: return this.legs[2].bodyJoint();
			case 12: return this.legs[3].lowerJoint();
			case 13: return this.legs[3].middleJoint();
			case 14: return this.legs[3].bodyJoint();
			case 15: return this.legs[4].lowerJoint();
			case 16: return this.legs[4].middleJoint();
			case 17: return this.legs[4].bodyJoint();
			case 18: return this.legs[5].lowerJoint();
			case 19: return this.legs[5].middleJoint();
			case 20: return this.legs[5].bodyJoint();
			case 21: return this.legs[6].lowerJoint();
			case 22: return this.legs[6].middleJoint();
			case 23: return this.legs[6].bodyJoint(); 
			case 24: return this.legs[7].lowerJoint();
			case 25: return this.legs[7].middleJoint();
			case 26: return this.legs[7].bodyJoint(); 
			default: throw new IllegalArgumentException("componentNum over index"); 
  		}
  	}
  	
  	private Component mapName2Component(String componentName) {
  		switch(componentName) {
	  		case  HEAD_NAME: return this.head;
			case  UPPER_BODY_NAME: return this.upperBody;
			case  LOWER_BODY_NAME: return this.lowerBody;
			case  ANTENNA2_LOWER_JOINT_NAME: return this.legs[7].lowerJoint();
			case  ANTENNA2_MIDDLE_JOINT_NAME: return this.legs[7].middleJoint();
			case  ANTENNA2_BODY_JOINT_NAME: return this.legs[7].bodyJoint(); 
			case  ANTENNA1_LOWER_JOINT_NAME: return this.legs[6].lowerJoint(); 
			case  ANTENNA1_MIDDLE_JOINT_NAME: return this.legs[6].middleJoint();
			case  ANTENNA1_BODY_JOINT_NAME: return this.legs[6].bodyJoint();
			case  LEG_RIGHTLOWER_LOWER_JOINT_NAME: return this.legs[5].lowerJoint();
			case  LEG_RIGHTLOWER_MIDDLE_JOINT_NAME: return this.legs[5].middleJoint();
			case  LEG_RIGHTLOWER_BODY_JOINT_NAME: return this.legs[5].bodyJoint();
			case  LEG_RIGHTMIDDLE_LOWER_JOINT_NAME: return this.legs[4].lowerJoint();
			case  LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME: return this.legs[4].middleJoint();
			case  LEG_RIGHTMIDDLE_BODY_JOINT_NAME: return this.legs[4].bodyJoint();
			case  LEG_RIGHTUPPER_LOWER_JOINT_NAME: return this.legs[3].lowerJoint();
			case  LEG_RIGHTUPPER_MIDDLE_JOINT_NAME: return this.legs[3].middleJoint();
			case  LEG_RIGHTUPPER_BODY_JOINT_NAME: return this.legs[3].bodyJoint();
			case  LEG_LEFTLOWER_LOWER_JOINT_NAME: return this.legs[2].lowerJoint();
			case  LEG_LEFTLOWER_MIDDLE_JOINT_NAME: return this.legs[2].middleJoint();
			case  LEG_LEFTLOWER_BODY_JOINT_NAME: return this.legs[2].bodyJoint();
			case  LEG_LEFTMIDDLE_LOWER_JOINT_NAME: return this.legs[1].lowerJoint();
			case  LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME: return this.legs[1].middleJoint();
			case  LEG_LEFTMIDDLE_BODY_JOINT_NAME: return this.legs[1].bodyJoint();
			case  LEG_LEFTUPPER_LOWER_JOINT_NAME: return this.legs[0].lowerJoint(); 
			case  LEG_LEFTUPPER_MIDDLE_JOINT_NAME: return this.legs[0].middleJoint(); 
			case  LEG_LEFTUPPER_BODY_JOINT_NAME: return this.legs[0].bodyJoint(); 
			default: throw new IllegalArgumentException("componentName doesn't exist");
  		}
  	}
  	public void setModelStates(final ArrayList<Configuration> config_list) {
  		for (int i = 0; i < config_list.size(); i++) {
  			if ( 0 <= i && i <= 26) {
  				mapNum2Component(i).setAngles(config_list.get(i));
  			}
  		}
  	}
  	
  	public void setModelStates(final Map<String, Configuration> state) {
  		for (Map.Entry<String, Configuration> entry: state.entrySet()) {
  			this.mapName2Component(entry.getKey()).setAngles(entry.getValue());
  		}
  	}
  	
  	/**
     * Prints the joints on the specified PrintStream.
     * 
     * @param printStream
     *          The stream on which to print each of the components.
     */
    public void printJoints(final PrintStream printStream) {
      for (final Component component : this.components) {
        printStream.println(component);
      }
    }

  	
  	public void toggleSelection(int selectionNum) {
  		if ( 0 <= selectionNum && selectionNum <= 26) {
  			Component component = mapNum2Component(selectionNum);
  			if ( this.selectedComponents.contains(component) ) {
  				this.selectedComponents.remove(component);
  				component.setColor(INACTIVE_COLOR);
  			}
  			else {
  		      this.selectedComponents.add(component);
  		      component.setColor(ACTIVE_COLOR);
  		    }
		}
  	}
  	
  	public void changeSelected(Configuration config) {
  		for(Component c: this.selectedComponents) {
  			c.changeConfiguration(config);
  		}
  	}
  	public INSECT(final Point3D position, final String name) {
		// Insect object itself as a top level component, need initialization
		
  		super(position, name);
  		
  		
		//antennas -- body joints
		final Component antenna_body1 = new Component(new Point3D(0.1, -0.85, 0.5), 
				new RoundedCylinder(LEG_RADIUS, -0.25, this.glut), ANTENNA1_BODY_JOINT_NAME);
		
		final Component antenna_body2 = new Component(new Point3D(0.1, -0.85, -0.2), 
				new RoundedCylinder(LEG_RADIUS, -0.25, this.glut), ANTENNA2_BODY_JOINT_NAME);
	
		//antennas -- middle joints 
		final Component antenna_middle1 = new Component(new Point3D(0.001, 0, 0), 
				new RoundedCylinder(0.025, 0.2, this.glut), ANTENNA1_MIDDLE_JOINT_NAME);
		
		final Component antenna_middle2 = new Component(new Point3D(0.001, 0, -0.45), 
				new RoundedCylinder(0.025, 0.2, this.glut), ANTENNA2_MIDDLE_JOINT_NAME);
	
		//antennas -- lower joints 
		final Component antenna_lower1 = new Component(new Point3D(-0.01, 0, 0.2), 
				new RoundedCylinder(0.02, 0.1, this.glut), ANTENNA1_LOWER_JOINT_NAME);
		
		final Component antenna_lower2 = new Component(new Point3D(-0.01, 0, -0.1), 
				new RoundedCylinder(0.02, 0.1, this.glut), ANTENNA2_LOWER_JOINT_NAME);
		
		// all the lower joints
		//LOWER = DISTAL JOINT IN ARM 
	    final Component lower1 = new Component(new Point3D(0, 0,
	        -MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -LOWER_JOINT_HEIGHT, this.glut), LEG_LEFTUPPER_LOWER_JOINT_NAME);
	    final Component lower2 = new Component(new Point3D(0, 0,
	        -MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -LOWER_JOINT_HEIGHT, this.glut), LEG_LEFTMIDDLE_LOWER_JOINT_NAME);
	    final Component lower3 = new Component(new Point3D(0, 0,
	        -MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -LOWER_JOINT_HEIGHT, this.glut), LEG_LEFTUPPER_LOWER_JOINT_NAME);
	    final Component lower4 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        LOWER_JOINT_HEIGHT, this.glut), LEG_RIGHTUPPER_LOWER_JOINT_NAME);
	    final Component lower5 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        LOWER_JOINT_HEIGHT, this.glut), LEG_RIGHTMIDDLE_LOWER_JOINT_NAME);
	    final Component lower6 = new Component(new Point3D(0, 0,
		        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
		        LOWER_JOINT_HEIGHT, this.glut), LEG_RIGHTLOWER_LOWER_JOINT_NAME);

	    // all the middle joints
	    final Component middle1 = new Component(new Point3D(0, 0,
	        -BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -MIDDLE_JOINT_HEIGHT, this.glut), LEG_LEFTUPPER_MIDDLE_JOINT_NAME);
	    final Component middle2 = new Component(new Point3D(0, 0,
	        -BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -MIDDLE_JOINT_HEIGHT, this.glut), LEG_LEFTMIDDLE_MIDDLE_JOINT_NAME);
	    final Component middle3 = new Component(new Point3D(0, 0,
	        -BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        -MIDDLE_JOINT_HEIGHT, this.glut), LEG_LEFTUPPER_MIDDLE_JOINT_NAME);
	    final Component middle4 = new Component(new Point3D(0, 0,
	        BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), LEG_RIGHTUPPER_MIDDLE_JOINT_NAME);
	    final Component middle5 = new Component(new Point3D(0, 0,
	        BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), LEG_RIGHTMIDDLE_MIDDLE_JOINT_NAME);
	    final Component middle6 = new Component(new Point3D(0, 0,
		    BODY_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
		    MIDDLE_JOINT_HEIGHT, this.glut), LEG_RIGHTUPPER_MIDDLE_JOINT_NAME);

	    // all the BODY joints, displaced by various amounts from the palm
	   //BODY = PALM JOINT IN ARM 
	    final Component body1 = new Component(new Point3D(0.3, -0.9, 0.15),
	        new RoundedCylinder(LEG_RADIUS, -BODY_JOINT_HEIGHT, this.glut),
	        LEG_LEFTUPPER_BODY_JOINT_NAME);
	    final Component body2 = new Component(new Point3D(0.0, -0.9, 0.15),
	        new RoundedCylinder(LEG_RADIUS, -BODY_JOINT_HEIGHT, this.glut),
	        LEG_LEFTMIDDLE_BODY_JOINT_NAME);
	    final Component body3 = new Component(new Point3D(-0.3, -0.9, 0.15),
	        new RoundedCylinder(LEG_RADIUS, -BODY_JOINT_HEIGHT, this.glut),
	        LEG_LEFTLOWER_BODY_JOINT_NAME);
	    final Component body4 = new Component(new Point3D(0.3, -0.9, -0.2),
	        new RoundedCylinder(LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut),
	        LEG_RIGHTUPPER_BODY_JOINT_NAME);
	    final Component body5 = new Component(new Point3D(0.0, -0.9, -0.2),
	        new RoundedCylinder(LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut),
	        LEG_RIGHTMIDDLE_BODY_JOINT_NAME);
	    final Component body6 = new Component(new Point3D(-0.3, -0.9, -0.2),
	    	new RoundedCylinder(LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut),
	    	LEG_RIGHTLOWER_BODY_JOINT_NAME); 
	    	

	    // put together the legs for easier selection by keyboard input later on
	    this.legs = new Leg[] { 
	    		
	    	new Leg(body1, middle1, lower1),
	        new Leg(body2, middle2, lower2),
	        new Leg(body3, middle3, lower3),
	        new Leg(body4, middle4, lower4),
	        new Leg(body5, middle5, lower5),
	        new Leg(body6, middle6, lower6),

	    //antennas 
	    
	    	new Leg(antenna_body1, antenna_middle1, antenna_lower1), 
	    	new Leg(antenna_body2, antenna_middle2, antenna_lower2)};
	    
	    
	    
	    // the head which models the upper body joint 

	    this.head = new Component(new Point3D(0.3, -0.1, 0.0), new Ellipsoid(
		        HEAD_RADIUS, this.glut), HEAD_NAME);
	    
	    //-1.0, 0.7, 0.1
	    // the upper body, which models the head joint (and the lower body joint ?) 
	    // -0.6, -0.7, 0.1
	    this.upperBody = new Component(new Point3D(-0.7, -0.35, 0.0), 
		    	new Ellipsoid(UPPER_BODY_RADIUS, this.glut), UPPER_BODY_NAME);


	    // the lower body, which models the lower body joint
	    //-1.0, 0.7, 0.1
	    this.lowerBody = new Component(new Point3D(-0.8, 0.3, 0.1),
	        new Ellipsoid(LOWER_BODY_RADIUS, this.glut),
	        LOWER_BODY_NAME);

	    

	    this.addChild(this.head);
	    this.head.addChild(this.upperBody);
	    this.upperBody.addChild(this.lowerBody);
	    this.head.addChildren(antenna_body1, antenna_body2);
	    
	    this.upperBody.addChildren(body1, body2, body3, body4, body5, body6);
	    body1.addChild(middle1);
	    body2.addChild(middle2);
	    body3.addChild(middle3);
	    body4.addChild(middle4);
	    body5.addChild(middle5);
	    body6.addChild(middle6);

	    middle1.addChild(lower1);
	    middle2.addChild(lower2);
	    middle3.addChild(lower3);
	    middle4.addChild(lower4);
	    middle5.addChild(lower5);
	    middle6.addChild(lower6);
	    
	    antenna_body1.addChild(antenna_middle1);
	    antenna_middle1.addChild(antenna_lower1);
	    
	    antenna_body2.addChild(antenna_middle2);
	    antenna_middle2.addChild(antenna_lower2);
	    
	    //Setting rotation limits 
	    
	    //Limits for antenna's body joints 
	    for (final Component bodyJoint : Arrays.asList(antenna_body1, antenna_body2)) {
	    	bodyJoint.setXPositiveExtent(35);
	    	bodyJoint.setXNegativeExtent(-35);
	    	
	    	bodyJoint.setYPositiveExtent(95);
	    	bodyJoint.setYNegativeExtent(85);
	    	
	    	bodyJoint.setZPositiveExtent(15);
	    	bodyJoint.setZPositiveExtent(-15);
	    }
	    //limits for antenna's middle joints
	    for (final Component middleJoint : Arrays.asList(antenna_middle1, antenna_middle2)) {
	    	middleJoint.setXPositiveExtent(30);
	    	middleJoint.setXNegativeExtent(-30);
	    	
	    	middleJoint.setYPositiveExtent(100);
	    	middleJoint.setYNegativeExtent(-100);
	    	
	    	middleJoint.setZPositiveExtent(0);
	    	middleJoint.setZNegativeExtent(0);
	    }
	    //limits for antenna's lower joints 
	    for (final Component lowerJoint : Arrays.asList(antenna_lower1, antenna_lower2)) {
	    	lowerJoint.setXPositiveExtent(30);
	    	lowerJoint.setXNegativeExtent(-30);
	    	
	    	lowerJoint.setYPositiveExtent(100);
	    	lowerJoint.setYNegativeExtent(-100);
	    	
	    	lowerJoint.setZPositiveExtent(15);
	    	lowerJoint.setZNegativeExtent(-15);
	    }
	    
	    //rotation limits for BODY joints of ant 
	    for (final Component bodyJoint : Arrays.asList(body1, body2, body3, body4, body5, body6)) {
	    	bodyJoint.setXPositiveExtent(15);
	    	bodyJoint.setXNegativeExtent(-15);
	    	
	    	bodyJoint.setYPositiveExtent(2);
	    	bodyJoint.setYNegativeExtent(-15);
	    	
	    	bodyJoint.setZPositiveExtent(15);
	    	bodyJoint.setZPositiveExtent(-15);
  	}
	    //rotation limits for MIDDLE joints of ant 
	    for (final Component middleJoint : Arrays.asList( middle2,
	            middle5)) {
	        	
	          middleJoint.setXPositiveExtent(5);
	          middleJoint.setXNegativeExtent(-15);

	          middleJoint.setYPositiveExtent(5);
	          middleJoint.setYNegativeExtent(-5);
	          
	          middleJoint.setZPositiveExtent(5);
	          middleJoint.setZNegativeExtent(-5);
	          
	       }
	    
	    //rotation limits for front legs 
	    //left upper leg == middle 1
	    
	    middle1.setYPositiveExtent(20);
	    middle1.setYNegativeExtent(-15);
	    middle1.setXPositiveExtent(5);
	    middle1.setXNegativeExtent(-5);
	    middle1.setZNegativeExtent(-5);
	    middle1.setZPositiveExtent(5);
	    
	    //right upper leg 
	    middle4.setYPositiveExtent(20);
	    middle4.setYNegativeExtent(-20);
	    middle4.setXPositiveExtent(15);
	    middle4.setXNegativeExtent(-15);
	    middle4.setZPositiveExtent(5);
	    middle4.setZNegativeExtent(-5);
  	
	    
	    //rotation limits for back legs 
	    middle3.setYPositiveExtent(15);
	    middle3.setYNegativeExtent(-15);
	    middle3.setXNegativeExtent(5);
	    middle3.setXPositiveExtent(5);
	    middle3.setZPositiveExtent(5);
	    middle3.setZNegativeExtent(-5);
	    
	    middle6.setYPositiveExtent(15);
	    middle6.setYNegativeExtent(-15);
	    middle6.setXNegativeExtent(-5);
	    middle6.setXPositiveExtent(5);
	    middle6.setZPositiveExtent(5);
	    middle6.setZNegativeExtent(-5); 
	    
	    
	    //rotation limits for the lower joints 
	    for (final Component lowerJoint : Arrays.asList(lower1, lower2,
	          lower3, lower4, lower5, lower6)) {
	        	
	          lowerJoint.setXPositiveExtent(10);
	          lowerJoint.setXNegativeExtent(-10);
	          
	          lowerJoint.setYPositiveExtent(5);
	          lowerJoint.setYNegativeExtent(-10);
	          
	          lowerJoint.setZPositiveExtent(5);
	          lowerJoint.setZNegativeExtent(-5);
	     }
	 
	   //rotation limits for the lower body 
	    this.lowerBody.setXPositiveExtent(10); 
	    this.lowerBody.setXNegativeExtent(-10);
	    this.lowerBody.setYNegativeExtent(-15);
	    this.lowerBody.setYPositiveExtent(15);
	    this.lowerBody.setZPositiveExtent(3);
	    this.lowerBody.setZNegativeExtent(-3);
	    
	    //rotation limits for the upper body 
	    this.upperBody.setXPositiveExtent(10);
	    this.upperBody.setXNegativeExtent(-10);
	    this.upperBody.setYPositiveExtent(15);
	    this.upperBody.setYNegativeExtent(-15);
	    this.upperBody.setZNegativeExtent(-3);
	    this.upperBody.setZPositiveExtent(3);
	    
	    //rotation limits for the head
	    this.head.setXNegativeExtent(-10);
	    this.head.setXPositiveExtent(10);
	    this.head.setYNegativeExtent(-15);
	    this.head.setYPositiveExtent(15);
	    this.head.setZNegativeExtent(-15);
	    this.head.setZPositiveExtent(15);
	    
	    this.components = Arrays.asList(
	    	body1, middle1, lower1, 
	    	body2, middle2, lower2, 
	    	body3, middle3, lower3, 
	    	body4, middle4, lower4, 
	    	body5, middle5, lower5, 
	    	body6, middle6, lower6, 
	    	antenna_body1, antenna_middle1, antenna_lower1, 
	    	antenna_body2, antenna_middle2, antenna_lower2,
	    	this.lowerBody, this.upperBody); 
	    
	    
  	}
  	private class Leg {
	    /** The body joint of this leg. */
	    private final Component bodyJoint;
	    
	    /** The list of all the joints in this leg. */
	    private final List<Component> joints;
	    
	    /** The middle joint of this leg. */
	    private final Component middleJoint;
	    
	    /** The lower joint of this leg. */
	    private final Component lowerJoint;

	    /**
	     * Instantiates this leg with the three specified joints.
	     * 
	     * @param lowerJoint
	     *          The lower joint of this leg.
	     * @param middleJoint
	     *          The middle joint of this leg.
	     * @param bodyJoint
	     *          The upper joint of this leg.
	     */
	    public Leg(final Component lowerJoint, final Component middleJoint,
	        final Component bodyJoint) {
	    	
	    
	     this.lowerJoint = lowerJoint;
	     this.middleJoint = middleJoint;
	     this.bodyJoint = bodyJoint;

	      this.joints = Collections.unmodifiableList(Arrays.asList(this.lowerJoint,
	          this.middleJoint, this.bodyJoint));
	 
		    }

		    /**
		     * Gets the lower joint of this leg.
		     * 
		     * @return The distal joint of this leg.
		     */
		    Component lowerJoint() {
		      return this.lowerJoint;
		    }

		    /**
		     * Gets an unmodifiable view of the list of the joints of this leg.
		     * 
		     * @return An unmodifiable view of the list of the joints of this leg.
		     */
		    List<Component> joints() {
		      return this.joints;
		    }

		    /**
		     * Gets the middle joint of this finger.
		     * 
		     * @return The middle joint of this finger.
		     */
		    Component middleJoint() {
		      return this.middleJoint;
		    }

		    /**
		     * Gets the body joint of this finger.
		     * 
		     * @return The body joint of this finger.
		     */
		    Component bodyJoint() {
		      return this.bodyJoint;
		    }
		}

	}


