package myProject.LosslessJoin;
import java.util.HashSet;
/*
@author Asma Bawazeer
MSc Computer Science
*/
public class AttributeSet extends HashSet<Attribute> {

	public AttributeSet() {
		super();
	}

	public AttributeSet(AttributeSet other) {
		super(other);
	}
}