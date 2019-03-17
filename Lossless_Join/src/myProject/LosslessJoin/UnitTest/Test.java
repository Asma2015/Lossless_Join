package myProject.LosslessJoin.UnitTest;

/*
@author Asma Bawazeer
MSc Computer Science
*/
import static org.junit.Assert.*;
import java.util.*;

import myProject.LosslessJoin.Attribute;
import myProject.LosslessJoin.AttributeSet;
import myProject.LosslessJoin.FdsPreservingLoosslessJoinChecker;
import myProject.LosslessJoin.FunctionalDependency;

public class Test {

	@org.junit.Test
	public void closuretest1() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		
		fds.add(new FunctionalDependency(t1,new Attribute("a")));

		// attrs
		// a
		// fds
		// a -> a
		assertTrue(t1.equals(FdsPreservingLoosslessJoinChecker.closure(t1, fds)));
		
		
		fds.add(new FunctionalDependency(t1, new Attribute("b")));
		// tables
		// a
		// fds
		// a -> a
		// a -> b
		t2.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		assertTrue(t2.equals(FdsPreservingLoosslessJoinChecker.closure(t1, fds)));
	}
	
	@org.junit.Test
	public void closuretest2() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		AttributeSet t3 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t3.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t3, new Attribute("c")));
		fds.add(new FunctionalDependency(t1, new Attribute("b")));
		// tables
		// a
		// fds
		// b -> c
		// a -> b
		t2.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		assertTrue(t2.equals(FdsPreservingLoosslessJoinChecker.closure(t1, fds)));
	}
	
	@org.junit.Test
	public void closuretest3() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		AttributeSet t3 = new AttributeSet();
		AttributeSet t4 = new AttributeSet();
		AttributeSet t5 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("c"));
		t2.add(new Attribute("g"));
		t3.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t1, new Attribute("c")));
		fds.add(new FunctionalDependency(t1, new Attribute("b")));
		fds.add(new FunctionalDependency(t2, new Attribute("h")));
		fds.add(new FunctionalDependency(t2, new Attribute("i")));
		fds.add(new FunctionalDependency(t3, new Attribute("h")));
		// attrs
		// a g
		// fds
		// a -> b
		// a -> c
		// cg -> h
		// cg -> i
		// b -> h
		// expected
		// a b c g h i
		t4.add(new Attribute("a"));
		t4.add(new Attribute("b"));
		t4.add(new Attribute("c"));
		t4.add(new Attribute("g"));
		t4.add(new Attribute("h"));
		t4.add(new Attribute("i"));
		t5.add(new Attribute("a"));
		t5.add(new Attribute("g"));
		assertTrue(t4.equals(FdsPreservingLoosslessJoinChecker.closure(t5, fds)));
	}
	
	@org.junit.Test
	public void lossLess0() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	}

	@org.junit.Test
	public void lossLess1() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t1.add(new Attribute("d"));
	   t2.add(new Attribute("a"));
	   t2.add(new Attribute("c"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   temp0.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("c")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("c"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("e")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("d")));
	   AttributeSet temp3 = new AttributeSet();
	   temp3.add(new Attribute("e"));
	   fds.add(new FunctionalDependency(temp3,new Attribute("a")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess2() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t2.add(new Attribute("a"));
	   t2.add(new Attribute("c"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess3() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t2.add(new Attribute("b"));
	   t2.add(new Attribute("c"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   assertFalse(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess4() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("c"));
	   t1.add(new Attribute("z"));
	   t2.add(new Attribute("s"));
	   t2.add(new Attribute("z"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("c"));
	   temp0.add(new Attribute("s"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("z")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("z"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("c")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess5() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t2.add(new Attribute("a"));
	   t2.add(new Attribute("d"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("c")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("c"));
	   temp2.add(new Attribute("d"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("e")));
	   AttributeSet temp3 = new AttributeSet();
	   temp3.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp3,new Attribute("d")));
	   AttributeSet temp4 = new AttributeSet();
	   temp4.add(new Attribute("e"));
	   fds.add(new FunctionalDependency(temp4,new Attribute("a")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess6() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t2.add(new Attribute("c"));
	   t2.add(new Attribute("d"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("c")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("c"));
	   temp2.add(new Attribute("d"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("e")));
	   AttributeSet temp3 = new AttributeSet();
	   temp3.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp3,new Attribute("d")));
	   AttributeSet temp4 = new AttributeSet();
	   temp4.add(new Attribute("e"));
	   fds.add(new FunctionalDependency(temp4,new Attribute("a")));
	   AttributeSet temp5 = new AttributeSet();
	   temp5.add(new Attribute("e"));
	   fds.add(new FunctionalDependency(temp5,new Attribute("a")));
	   assertFalse(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess7() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t2.add(new Attribute("c"));
	   t2.add(new Attribute("d"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   temp0.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("c")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("c"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("d")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("e")));
	   assertFalse(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess8() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t1.add(new Attribute("d"));
	   t2.add(new Attribute("a"));
	   t2.add(new Attribute("b"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   temp0.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("c")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("c"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("d")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("e")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void lossLess9() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t1.add(new Attribute("d"));
	   t2.add(new Attribute("b"));
	   t2.add(new Attribute("e"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   temp0.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("c")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("c"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("d")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("e")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}

	@org.junit.Test
	public void depPres0() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("b"));
	   t1.add(new Attribute("c"));
	   t2.add(new Attribute("c"));
	   t2.add(new Attribute("d"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("b"));
	   fds.add(new FunctionalDependency(temp1,new Attribute("c")));
	   AttributeSet temp2 = new AttributeSet();
	   temp2.add(new Attribute("c"));
	   fds.add(new FunctionalDependency(temp2,new Attribute("d")));
	   assertTrue(FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void depPres1() {
	   AttributeSet t1 = new AttributeSet();
	   AttributeSet t2 = new AttributeSet();
	   Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
	   t1.add(new Attribute("a"));
	   t1.add(new Attribute("c"));
	   t1.add(new Attribute("d"));
	   t2.add(new Attribute("b"));
	   t2.add(new Attribute("c"));
	   AttributeSet temp0 = new AttributeSet();
	   temp0.add(new Attribute("a"));
	   fds.add(new FunctionalDependency(temp0,new Attribute("b")));
	   AttributeSet temp1 = new AttributeSet();
	   temp1.add(new Attribute("b"));
	}
	
	@org.junit.Test
	public void depPresBasictest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t1,new Attribute("a")));

		// tables
		// a
		// b
		// fds
		// a -> a
		assertTrue(FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds));
		
		
		fds.add(new FunctionalDependency(t1, new Attribute("b")));
		// tables
		// a
		// b
		// fds
		// a -> a
		// a -> b
		assertFalse(FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void losslessBasictest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		
		// tables
		// a
		// b
		// fds
		assertFalse(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("b"));
		// tables
		// a b
		// b
		// fds
		assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}
	
	@org.junit.Test
	public void depPresFDtest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t1,new Attribute("b")));

		// tables
		// a b
		// b
		// fds
		// ab -> b
		assertTrue(FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds));
		
		
		fds.add(new FunctionalDependency(t2, new Attribute("a")));
		// tables
		// a b
		// b
		// fds
		// ab -> b
		// b -> a
		assertTrue(FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void losslesstest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		t2.add(new Attribute("d"));
		
		AttributeSet temp = new AttributeSet();
		temp.add(new Attribute("b"));
		fds.add(new FunctionalDependency(temp,new Attribute("c")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		assertFalse(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
		
		fds.add(new FunctionalDependency(temp, new Attribute("d")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		// c -> d
		assertTrue(FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds));
	}
}
