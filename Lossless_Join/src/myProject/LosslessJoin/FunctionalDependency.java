package myProject.LosslessJoin;
/*
@author Asma Bawazeer
MSc Computer Science
*/
public class FunctionalDependency {
	public AttributeSet left;
	public Attribute right;
	
	public FunctionalDependency(AttributeSet l, Attribute r) {
		left = l;
		right = r;
	}
}