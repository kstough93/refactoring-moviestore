package com.moviestore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviestoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void newMovieShouldContainTitleCuriousGeorge() {
	    Movie underTest = new Movie("Curious George", Movie.CHILDRENS);
	    assertEquals("Curious George", underTest.getTitle());
	}
	
	@Test
	public void newMovieShouldContainPriceCodeChildrens() {
	    Movie underTest = new Movie("Curious George", Movie.CHILDRENS);
	    assertEquals(Movie.CHILDRENS, underTest.getPriceCode());
	}
	
	@Test
	public void newRentalShouldContainsDaysRentedEqualToFive() {
	    Movie movie = new Movie("Curious George", Movie.CHILDRENS);
	    Rental underTest = new Rental(movie, 5);
	    assertEquals(5, underTest.getDaysRented());
	}
	
	@Test
	public void newCustomerShouldHaveNameWalterWhite() {
	    Customer underTest = new Customer("Walter White");
	    assertEquals("Walter White", underTest.getName());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweOneFiftyForOneDayRentalOfCuriousGeorge() {
	    Movie movie = new Movie("Curious George", Movie.CHILDRENS);
	    Rental rental = new Rental(movie, 1);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental);
	    assertEquals("Rental Record for Walter White\n"
	    	+ "\tCurious George\t1.5\n"
	    	+ "Amount owed is: 1.5\n"
	    	+ "You earned 1 frequent renter points", underTest.statement());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweThreeFiftyForOneDayRentalOfCuriousGeorgeAndOneDayRentalOfScarface() {
	    Movie movie1 = new Movie("Curious George", Movie.CHILDRENS);
	    Movie movie2 = new Movie("Scarface", Movie.REGULAR);
	    Rental rental1 = new Rental(movie1, 1);
	    Rental rental2 = new Rental(movie2, 1);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental1);
	    underTest.addRental(rental2);
	    assertEquals("Rental Record for Walter White\n"
	    	+ "\tCurious George\t1.5\n"
	    	+ "\tScarface\t2.0\n"
	    	+ "Amount owed is: 3.5\n"
	    	+ "You earned 2 frequent renter points", underTest.statement());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweNineForThreeDayRentalOfStarTrekBeyond() {
	    Movie movie = new Movie("Star Trek Beyond", Movie.NEW_RELEASE);
	    Rental rental = new Rental(movie, 3);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental);
	    assertEquals("Rental Record for Walter White\n"
	    	+ "\tStar Trek Beyond\t9.0\n"
	    	+ "Amount owed is: 9.0\n"
	    	+ "You earned 2 frequent renter points", underTest.statement());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweFiveForFourDayRentalOfTraffic() {
	    Movie movie = new Movie("Traffic", Movie.REGULAR);
	    Rental rental = new Rental(movie, 4);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental);
	    assertEquals("Rental Record for Walter White\n"
	    	+ "\tTraffic\t5.0\n"
	    	+ "Amount owed is: 5.0\n"
	    	+ "You earned 1 frequent renter points", underTest.statement());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweThreeForFourDayRentalOfMinions() {
	    Movie movie = new Movie("Minions", Movie.CHILDRENS);
	    Rental rental = new Rental(movie, 4);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental);
	    assertEquals("Rental Record for Walter White\n"
	    	+ "\tMinions\t3.0\n"
	    	+ "Amount owed is: 3.0\n"
	    	+ "You earned 1 frequent renter points", underTest.statement());
	}
	
	@Test
	public void WalterWhiteCustomerShouldOweThreeForFourDayRentalOfMinionsHTML() {
	    Movie movie = new Movie("Minions", Movie.CHILDRENS);
	    Rental rental = new Rental(movie, 4);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental);
	    assertEquals("<H1>Rentals for <EM>Walter White</EM></H1><P>\n"
	    	+ "Minions: 3.0<BR>\n"
	    	+ "<P>You owe <EM>3.0</EM><P>\n"
	    	+ "On this rental you earned <EM>1</EM> frequent renter points.", underTest.htmlStatement());
	}
	
	@Test 
	public void WalterWhiteCustomerShouldOweThreeFiftyForOneDayRentalOfCuriousGeorgeAndOneDayRentalOfScarfaceHTML() {
	    Movie movie1 = new Movie("Curious George", Movie.CHILDRENS);
	    Movie movie2 = new Movie("Scarface", Movie.REGULAR);
	    Rental rental1 = new Rental(movie1, 1);
	    Rental rental2 = new Rental(movie2, 1);
	    Customer underTest = new Customer("Walter White");
	    underTest.addRental(rental1);
	    underTest.addRental(rental2);
	    assertEquals("<H1>Rentals for <EM>Walter White</EM></H1><P>\n"
	    	+ "Curious George: 1.5<BR>\n"
	    	+ "Scarface: 2.0<BR>\n"
	    	+ "<P>You owe <EM>3.5</EM><P>\n"
	    	+ "On this rental you earned <EM>2</EM> frequent renter points.", underTest.htmlStatement());
	}
}
