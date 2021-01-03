public  class Functions {
	
	//פונקציה לחישוב משקל רצוי לגבר
	public static int desirableWeightMale(int h)
	{
		return	(int)(48 + 1.1 * (h - 152));	
	}

	//פונקציה לחישוב משקל רצוי לאישה
	public static int desirableWeightFemale(int h)
	{
				return	(int)(45.4 + 0.9 * (h - 152));
	}
	
	//פונקציה לחישוה מספר BMI
	public static double bmi(int weight,double height )
	{
		height/=100;
		
		height= Math.pow(height,2);
		
		double temp=weight / height;
		temp*=100;
		temp=(int)temp/100.0;
		
		return	temp;
	}
	
	//פונקציה לחישוב סטטוס משקל
	public static String status(double bmi) 
	{
		String result = null;
		
		if( bmi<15)
			result	="אנורקטי";
		else if( bmi>=15&&bmi<18.5)
			result	="תת משקל";
		else if( bmi>18.5&&bmi<25)
			result	="נורמלי";
		else if( bmi>=25&&bmi<30)
			result	="עודף משקל";
		else if( bmi>=30&&bmi<35)
			result	="שמן";
		else if( bmi>35)
			result	="שמן מאוד";

		return result;
	}
}
