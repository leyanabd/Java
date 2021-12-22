import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT; 

public class Sphere extends Circular implements Displayable{ 

		private int callListHandle; 
		private final double height; 
		
		public Sphere(double radius, double height, GLUT glut) {
			super(radius, glut); 
			this.height = height; 
		}
		
		public int get_handle() {
			//TODO Auto-generated method stub
			return this.callListHandle; 
		}
		@Override
		public void draw(GL2 gl) {
			gl.glCallList(this.callListHandle);
		}
		@Override
		public void initialize(GL2 gl) {
			
			gl.glNewList(this.callListHandle, GL2.GL_COMPILE); 
			
		
			//to open:  
			gl.glPushMatrix();
			
			
			// order of gpu processing things is different; but because it's in GPU -- do experiments 
			
			gl.glScalef(1.0f, 0.5f, 0.5f);
			this.glut().glutSolidSphere(1, 36, 18); 
			
			//to close: 
			gl.glPopMatrix();
			
			gl.glEndList(); 
		}
}



