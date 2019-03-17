package myProject.LosslessJoin.Main;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import myProject.LosslessJoin.Attribute;
import myProject.LosslessJoin.AttributeSet;
import myProject.LosslessJoin.FdsPreservingLoosslessJoinChecker;
import myProject.LosslessJoin.FunctionalDependency;

/*
@author Asma Bawazeer
MSc Computer Science
*/
public class FdsCheck {
	
	public static void  main(String[] args){
		
		System.out.println("Please Insert two lettrs:");
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		Scanner reader = new Scanner(System.in); 
		String str1 =reader.next();
		String str2 =reader.next();
		
		t1.add(new Attribute(str1));
		
		fds.add(new FunctionalDependency(t1,new Attribute(str1)));
		
		fds.add(new FunctionalDependency(t1, new Attribute(str2)));
		
		t2.add(new Attribute(str1));
		t2.add(new Attribute(str2));
		System.out.println("The Result is: "+t2.equals(FdsPreservingLoosslessJoinChecker.closure(t1, fds)));
	 
	}

}
