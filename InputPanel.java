import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel
{
   	private JPanel titlelPanel, genderPanel,agePanel,heightPanel,WeightPanel,okPanel,outputPanel,panel2;
    private JLabel titleLabel,actualWeightLable,desirableWeightLabel,bmi,weightStatusLable,heightLable ;
	private JRadioButton male,female ;
	private JTextField ageFild,actualWeightFild;
	private JSlider heightSlider;
    private JButton okButton;
	private int heightValue,WeightValue,desirableWeightValue,Border=TitledBorder.CENTER; 
	private double bmiValue;
	private String weightStatusValue;
	private Font font=new Font("Secular one",Font.BOLD,30),font2=new Font("Secular one",Font.BOLD,20),font3=new Font("Secular one",Font.PLAIN,20);
	private Color color=new Color(245,245,245),color2=new Color(0,220,0);
    private Dimension dimension = new Dimension(300, 100);
	private TitledBorder genderBorder,ageTitle,heightTitle,WeighttTitle,outputTitle;
	private Object source;
	private Border border=BorderFactory.createLineBorder(color2);
	   
	public InputPanel()
	{
     //עיצוב הפנל הראשי
     setPreferredSize (new Dimension(530, 650));
     setBackground(color);	

/***************כותרת***************/
     //הגדרה ועיצוב פנל 
     titlelPanel=new JPanel();
     titlelPanel.setBackground(color2);
     titlelPanel.setPreferredSize (new Dimension(600, 50));
     //הגדרה ועיצוב כיתוב 
     titleLabel=new JLabel("מחשבון למציאת BMI");
     titleLabel.setForeground(Color.white);
     titleLabel.setFont(font);
     //הוספת הכיתוב לפנל
     titlelPanel.add(titleLabel);
     
/***************כפתורי בחירה מין***************/
     //הגדרה ועיצוב פנל
     genderPanel=new JPanel();
     genderPanel.setBackground(color);
     genderPanel.setPreferredSize(dimension);
     genderBorder=new TitledBorder(border,"מין",Border,0,font2);
	 genderPanel.setBorder (genderBorder);
     //הגדרת כפתורים
	 male=new JRadioButton("זכר");
	 male.setBackground(color);
	 male.setFont(font3);
	 female=new JRadioButton("נקבה");
	 female.setBackground(color);
	 female.setFont(font3);
	 //הגדרת מאזין
	 GenderListener listener=new GenderListener(); 
	 male.addActionListener(listener);
	 female.addActionListener(listener);
	 //חיבור הכפתורים לקבוצה אחת
     ButtonGroup group = new ButtonGroup();
     group.add (male);
     group.add (female);
     //הוספת הכפתורים לפנל
     genderPanel.add(male);
	 genderPanel.add(female);
	 
/***************טקסט גיל***************/
     //הגדרה ועיצוב פנל
	 agePanel=new JPanel();
	 agePanel.setBackground(color);
	 agePanel.setPreferredSize (dimension);
	 ageTitle =new TitledBorder(border,"גיל",Border,0,font2);
     agePanel.setBorder(ageTitle);
     //הגדרת שדה טקסט
     ageFild=new JTextField(2);
     ageFild.setFont(font3);
	 //הוספת שדה טקסט לפנל
     agePanel.add(ageFild);

/***************סליידר גובה***************/
	//הגדרה ועיצוב סליידר
     heightPanel=new JPanel();
     heightPanel.setBackground(color);
     heightPanel.setPreferredSize(new Dimension(160,570));
     heightSlider=new JSlider(JSlider.VERTICAL,140,220,140);
     heightSlider.setPreferredSize(new Dimension(150,500));
     heightSlider.setMajorTickSpacing (5);
     heightSlider.setMinorTickSpacing (1);
     heightSlider.setPaintTicks (true);
     heightSlider.setPaintLabels (true);
     heightSlider.setBackground(color);
     
     heightLable=new JLabel("הרם את הסליידר");
     heightLable.setFont(new Font("Ariel",Font.PLAIN,17));

     heightTitle=new TitledBorder(border,"גובה",Border,0,font2);
     heightPanel.setBorder (heightTitle);
     //הגדרת מאזין
     heightSlider.addChangeListener(e ->
     {
    	 heightValue = heightSlider.getValue();
	     heightLable.setText("הגובה שלך: "+heightValue+" ס''מ");
     });
     
     //הוספת סליידר לפנל
     heightPanel.add(heightSlider);
     heightPanel.add(heightLable);

/***************טקסט משקל***************/
     //הגדרה ועיצוב פנל
     WeightPanel=new JPanel();
     WeightPanel.setBackground(color);
     WeightPanel.setPreferredSize(dimension);
     WeighttTitle =new TitledBorder(border,"משקל",Border,0,font2);
     WeightPanel.setBorder (WeighttTitle);
     //הגדרת שדה טקסט
     actualWeightFild=new JTextField(3);
     actualWeightFild.setFont(font3);

     //הגדרת מאזין
     actualWeightFild.addActionListener(new okListener());
     //הוספת שדה טקסט לפנל   
     WeightPanel.add(actualWeightFild);
     
/***************כפתור חישוב***************/
     //הגדרה ועיצוב פנל
     okPanel=new JPanel();
     okPanel.setBackground(color);
     okPanel.setPreferredSize(dimension);
     //הגדרה ועיצוב כפתור
     okButton=new JButton("חשב"); 
     okButton.setForeground(Color.white);
     okButton.setFont(font);
     okButton.setBackground(color2);
     okButton.setPreferredSize(new Dimension(200,60));
     //הגדרת מאזין
     okButton.addActionListener(new okListener());
     //הוספת כפתור לפנל
     okPanel.add(okButton);
     
     
/***************תוצאה***************/
     //הגדרה ועיצוב פנל
     outputPanel=new JPanel();
     outputPanel.setPreferredSize(new Dimension(300,170));
     outputPanel.setBackground(color);

     outputTitle=new TitledBorder(border,"תוצאות",Border,1,font2);
     //הגדרת לייבל למשקל הרצוי
     desirableWeightLabel=new JLabel();
     desirableWeightLabel.setFont(font3);
     desirableWeightLabel.setForeground(Color.blue);
     desirableWeightLabel.setHorizontalTextPosition(SwingConstants.CENTER);
     //הגדרת לייבל למשקל האמיתי
     actualWeightLable=new JLabel();
     actualWeightLable.setFont(font3);
     actualWeightLable.setForeground(Color.blue);
     actualWeightLable.setHorizontalAlignment(SwingConstants.CENTER);

     //הגדרת לייבל ל BMI
     bmi=new JLabel();
     bmi.setFont(font3);
     bmi.setForeground(Color.blue);
     bmi.setHorizontalAlignment(SwingConstants.CENTER);

     //הגדרת לייבל לסטטוס משקל
     weightStatusLable=new JLabel();
     weightStatusLable.setFont(font3);
     weightStatusLable.setForeground(Color.blue);
     weightStatusLable.setHorizontalAlignment(SwingConstants.CENTER);

     //הוספת הליבלים לפנל התוצאה
     outputPanel.add(actualWeightLable);
     outputPanel.add(desirableWeightLabel);
     outputPanel.add(bmi);
     outputPanel.add(weightStatusLable);
     
    //סידור הפנלים הקטנים כבוקס ליאוט
     panel2=new JPanel();
     panel2.setLayout (new BoxLayout (panel2, BoxLayout.Y_AXIS)); 
     panel2.setBackground(color);
     
    //הוספת הפנלים הקטנים לפנל
    panel2.add(genderPanel);
   	panel2.add(agePanel);
   	panel2.add(WeightPanel);
   	panel2.add(okPanel);
   	panel2.add(outputPanel);
   	
    //הוספת כל הפנלים לפנל הראשי
    add(titlelPanel);
  	add(heightPanel);	
  	add(panel2);

	}
	
	 //מאזין לכפתורי רדיו
	private class GenderListener implements ActionListener
	   {
	      public void actionPerformed (ActionEvent event)
	      {
	    	  source= event.getSource();
	   }
	}
	                         
	 //מאזין לכפתור חישוב
	 private class okListener implements ActionListener
	   {
	      public void actionPerformed (ActionEvent event)
	      {
	    	  int k=ageFild.toString().length();
	    	  String a=String.valueOf(k);
	    	  weightStatusLable.setText(a);
	    	  
	    	  try {
	    		  if(source!=null)
	    		  {
	    	  WeightValue =Integer.parseInt (actualWeightFild.getText());
	    	  
	    	  if (source==male)
	    	  desirableWeightValue= Functions.desirableWeightMale(heightValue);
	    	  else if(source==female)
	    	  desirableWeightValue= Functions.desirableWeightFemale(heightValue);
	    	 
	    	  
	    	  bmiValue= Functions.bmi(WeightValue, heightValue);
	    	  weightStatusValue= Functions.status(bmiValue);
	    	  
	    	  desirableWeightLabel.setText("המשקל הרצוי: " + desirableWeightValue+ " kg ");
	    	  actualWeightLable.setText("המשקל שלך: "+WeightValue+" kg");
	    	  bmi.setText("     "+bmiValue+" :BMI    ");
	    	  weightStatusLable.setText("   סטטוס המשקל שלך: "+weightStatusValue+"   ");
	    	  outputPanel.setBorder (outputTitle);
	    		  }
	    		  else 	    		
		    		  JOptionPane.showMessageDialog (null,"הזן נתונים חיוביים בכל השדות");

	    	  }catch (Exception e){
	    		  JOptionPane.showMessageDialog (null,"הזן נתונים חיוביים בכל השדות");
	    	  }
	   }
	}
}
