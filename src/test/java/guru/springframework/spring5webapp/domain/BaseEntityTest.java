package guru.springframework.spring5webapp.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class BaseEntityTest {
	
	@Test
	public void testHashCode001() {
		Book b1=new Book();
		b1.setId(10l);
		Book b2=new Book();
		b2.setId(10l);		
		Set<Book> c=new HashSet<>(Arrays.asList(b1,b2));
		Assert.assertThat("To many elements in collection", c,  hasSize(1));		
	}
	
	@Test
	public void testHashCode002() {
		Book b1=new Book();
		b1.setId(10l);
		Book b2=new Book();
		b2.setId(11l);
		
		//test
		Set<Book> c=new HashSet<>(Arrays.asList(b1,b2));
		Assert.assertThat("To many elements in collection", c,  hasSize(2));		
	}
	
	
	@Test
	public void testEquels001() {
		Book b1=new Book();
		b1.setId(10l);

		Book b2=new Book();
		b2.setId(11l);
		
//		test
		boolean result=b1.equals(b2);
		Assert.assertThat("The elements should be diffrent", result,  is(false));		
	}
	
	@Test
	public void testEquels002() {
		Book b1=new Book();
		b1.setId(10l);

		Book b2=new Book();
		b2.setId(10l);
		
//		test
		boolean result=b1.equals(b2);
		Assert.assertThat("The elements should be equle", result,  is(true));		
	}
	
	@Test
	public void testEquels003() {
		Book b1=new Book();
		b1.setId(10l);

		Author b2=new Author();
		b2.setId(10l);
		
//		test
		boolean result=b1.equals(b2);
		Assert.assertThat("The elements should be diffrent", result,  is(false));			
	}
	
	@Test
	public void testEquels004() {
		Book b1=new Book();
		b1.setId(10l);
		
//		test
		boolean result=b1.equals(b1);
		Assert.assertThat("The elements should be equle", result,  is(true));		
	}

	@Test
	public void testToString001() {
		Book b1=new Book();
		b1.setId(10l);
		
//		test		
		System.out.println(b1.toString());
		
		Assert.assertThat("The elements contain string:Book", b1.toString(),  containsString("Book"));
		Assert.assertThat("The elements contain id=10", b1.toString(),  containsString("id=10"));
	}

		
	
	
}
