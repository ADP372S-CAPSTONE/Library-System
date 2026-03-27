/**
 *Author: Sinazo Ntsimbi
 * 222765208
 *
 */
package factory;

import domain.Loan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 class LoanFactoryTest {
	@Test
	void shouldCreateLoanUsingBuilder() {

		Loan loan = new Loan.Builder()
				.setLoanId("L001")
				.setIssueDate(LocalDate.of(2026, 3, 21))
				.setDueDate(LocalDate.of(2026, 4, 4))
				.setReturnDate(null)
				.build();

		assertNotNull(loan);
		assertEquals("L001", loan.getLoanId());
		assertEquals(LocalDate.of(2026, 3, 21), loan.getIssueDate());
		assertEquals(LocalDate.of(2026, 4, 4), loan.getDueDate());
		assertNull(loan.getReturnDate());
	}
	@Test
	void shouldCreateLoanUsingFactory() {

		Loan loan = LoanFactory.createLoan(
				"L002",
				LocalDate.now(),
				LocalDate.now().plusDays(14),
				null
		);

		assertNotNull(loan);
		assertEquals("L002", loan.getLoanId());
		assertNotNull(loan.getIssueDate());
		assertNotNull(loan.getDueDate());
	}

	@Test
	void shouldThrowExceptionWhenLoanIdIsMissing() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Loan.Builder()
					.setLoanId(null)
					.setIssueDate(LocalDate.now())
					.setDueDate(LocalDate.now().plusDays(14))
					.build();
		});
	}
	@Test
	void shouldThrowExceptionWhenLoanIdIsInvalid() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Loan.Builder()
					.setLoanId("123") // must start with "L"
					.setIssueDate(LocalDate.now())
					.setDueDate(LocalDate.now().plusDays(14))
					.build();
		});
	}
	@Test
	void shouldThrowExceptionWhenIssueDateIsMissing() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Loan.Builder()
					.setLoanId("L003")
					.setIssueDate(null)
					.setDueDate(LocalDate.now().plusDays(14))
					.build();
		});
	}
	@Test
	void shouldThrowExceptionWhenDueDateIsBeforeIssueDate() {


		assertThrows(IllegalArgumentException.class, () -> {
			new Loan.Builder()
					.setLoanId("L004")
					.setIssueDate(LocalDate.now())
					.setDueDate(LocalDate.now().minusDays(1))
					.build();

		 });
	}
 }













