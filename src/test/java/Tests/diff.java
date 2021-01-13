package Tests;

import java.util.Comparator;

public class diff implements Comparator<Float>
{
    // Used for sorting in ascending order of
    // roll number
    public int  compare(Float a, Float b)
    {
    	
    	if(Math. abs(b-a)<=1.0)
    		return 1;
    	return 0;
    }
}