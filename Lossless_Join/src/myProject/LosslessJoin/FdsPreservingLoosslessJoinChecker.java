package myProject.LosslessJoin;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
@author Asma Bawazeer
MSc Computer Science
*/
public class FdsPreservingLoosslessJoinChecker {

	/**
	 * Checks whether a decomposition of a table is dependency
	 * preserving under the set of functional dependencies fds
	 * 
	 * @param t1 one of the two tables of the decomposition
	 * @param t2 the second table of the decomposition
	 * @param fds a complete set of functional dependencies that apply to the data
	 * 
	 * @return true if the decomposition is dependency preserving, false otherwise
	 **/
	public static boolean checkDepPres(AttributeSet t1, AttributeSet t2, Set<FunctionalDependency> fds) {
		//a decomposition is dependency preserving, if local functional dependencies are
		//sufficient to enforce the global properties
		//To check a particular functional dependency a -> b is preserved, 
		//you can run the following algorithm
		//result = a
		//while result has not stabilized
		//	for each table in the decomposition
		//		t = result intersect table 
		//		t = closure(t) intersect table
		//		result = result union t
		//if b is contained in result, the dependency is preserved
		Iterator<FunctionalDependency> fdIter = fds.iterator();
		while(fdIter.hasNext()){
			FunctionalDependency fd = fdIter.next();
			AttributeSet left = new AttributeSet(fd.left);
			Attribute right = fd.right;
			AttributeSet result = new AttributeSet(left);
			
			do{
				left = new AttributeSet(result);
				AttributeSet table;
				
				// we will always have two tables to check
				for(int i=0; i<2; i++){
					
					// assign table to t1 or t2
					table = i==0 ? t1 : t2;
					
					// attrs = result intersect table
					AttributeSet attrs = new AttributeSet();
					Iterator<Attribute> attrIter = result.iterator();
					while(attrIter.hasNext()){
						Attribute tmp = attrIter.next();
						if(table.contains(tmp))
							attrs.add(tmp);
					}

					// attrs = closure(attrs)
					Set<FunctionalDependency> fdSet =  new HashSet<FunctionalDependency>();
					fdSet.add(fd);
					attrs = closure(attrs, fdSet);

					// attrsTmp = attrs intersect table
					AttributeSet attrsTmp = new AttributeSet();
					attrIter = attrs.iterator();
					while(attrIter.hasNext()){
						Attribute tmp = attrIter.next();
						if(table.contains(tmp))
							attrsTmp.add(tmp);
					}

					// result = result union attrsTmp
					attrIter = attrsTmp.iterator();
					while(attrIter.hasNext())
						result.add(attrIter.next());
				}
				
			}while(!left.equals(result));
			
			if(!left.contains(right))
				return false;
		}
		return true;
	}

	/**
	 * Checks whether a decomposition of a table is lossless
	 * under the set of functional dependencies fds
	 * 
	 * @param t1 one of the two tables of the decomposition
	 * @param t2 the second table of the decomposition
	 * @param fds a complete set of functional dependencies that apply to the data
	 * 
	 * @return true if the decomposition is lossless, false otherwise
	 **/
	public static boolean checkLossless(AttributeSet t1, AttributeSet t2, Set<FunctionalDependency> fds) {
		//Lossless decompositions do not lose information, the natural join is equal to the 
		//original table.
		//a decomposition is lossless if the common attributes for a superkey for one of the
		//tables.
		AttributeSet sharedAttrs = new AttributeSet();
		Iterator<Attribute> attrIter = t1.iterator();
		while(attrIter.hasNext()){
			Attribute tmp = attrIter.next();
			if(t2.contains(tmp))
				sharedAttrs.add(tmp);
		}
		AttributeSet closureAttrs = closure(sharedAttrs, fds);
		if(closureAttrs.containsAll(t1) || closureAttrs.containsAll(t2))
			return true;
		
		return false;
	}

	//recommended helper method
	//finds the total set of attributes implied by attrs
	public static AttributeSet closure(AttributeSet attrs, Set<FunctionalDependency> fds) {
		AttributeSet tmp = attrs;
		AttributeSet result;
		
		do{
			result = new AttributeSet(tmp);
			Iterator<FunctionalDependency> iterfd = fds.iterator();
			while(iterfd.hasNext()){
				FunctionalDependency fd = iterfd.next();
				AttributeSet left = fd.left;
				
				Iterator<Attribute> iter = left.iterator();
				boolean leftInAttrs = true;
				while(iter.hasNext()){
					if(!tmp.contains(iter.next())){
						leftInAttrs = false;
						break;
					}
				}
				if(leftInAttrs)
					tmp.add(fd.right);
			}
		}while(!result.equals(tmp));
		
		return result;
	}
}
