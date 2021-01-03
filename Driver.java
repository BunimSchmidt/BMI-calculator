import javax.swing.*;
public class Driver {

	public static void main(String[] args) {

		//יצירת פריים
		JFrame frame=new JFrame("מחשבון BMI");
		
        //הוספת הפנל הראשי לפריים
		frame.add(new InputPanel());
	
		frame.pack();
		frame.setVisible(true);
	}
}
