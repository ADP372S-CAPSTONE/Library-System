/** LoanRepositoryImplTest.java
 * Loan repository implementation test
 * Author: Sinazo Ntsimbi 222765208
 * Date: 23 March 2026
*/
package repository.impl;

import domain.Loan;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoanRepositoryImplTest {

    @Test
    void testCreate() {
        LoanRepositoryImpl repository = LoanRepositoryImpl.getInstance();
        Loan loan = new Loan.Builder()
                .setLoanId("L001")
                .setIssueDate(LocalDate.of(2026, 3, 1))
                .setDueDate(LocalDate.of(2026, 3, 15))
                .build();

        Loan createdLoan = repository.create(loan);

        assertNotNull(createdLoan);
        assertEquals("L001", createdLoan.getLoanId());
        assertEquals(LocalDate.of(2026, 3, 1), createdLoan.getIssueDate());
    }

    @Test
    void testRead() {
        LoanRepositoryImpl repository = LoanRepositoryImpl.getInstance();
        Loan loan = new Loan.Builder()
                .setLoanId("L002")
                .setIssueDate(LocalDate.of(2026, 3, 2))
                .setDueDate(LocalDate.of(2026, 3, 16))
                .build();

        repository.create(loan);
        String key = loan.getLoanId();

        Optional<Loan> foundLoan = repository.read(key);

        assertTrue(foundLoan.isPresent());
        assertEquals("L002", foundLoan.get().getLoanId());
    }

    @Test
    void testUpdate() {
        LoanRepositoryImpl repository = LoanRepositoryImpl.getInstance();
        Loan loan = new Loan.Builder()
                .setLoanId("L003")
                .setIssueDate(LocalDate.of(2026, 3, 3))
                .setDueDate(LocalDate.of(2026, 3, 17))
                .build();

        repository.create(loan);
        String key = loan.getLoanId();

        Loan updatedLoan = new Loan.Builder()
                .setLoanId("L003")
                .setIssueDate(LocalDate.of(2026, 3, 3))
                .setDueDate(LocalDate.of(2026, 3, 17))
                .setReturnDate(LocalDate.of(2026, 3, 10))
                .build();

        repository.update(updatedLoan);

        Optional<Loan> result = repository.read(key);
        assertTrue(result.isPresent());
        assertEquals(LocalDate.of(2026, 3, 10), result.get().getReturnDate());
    }

    @Test
    void testDelete() {
        LoanRepositoryImpl repository = LoanRepositoryImpl.getInstance();
        Loan loan = new Loan.Builder()
                .setLoanId("L004")
                .setIssueDate(LocalDate.of(2026, 3, 4))
                .setDueDate(LocalDate.of(2026, 3, 18))
                .build();

        repository.create(loan);
        String key = loan.getLoanId();

        boolean deleted = repository.delete(key);

        assertTrue(deleted);
        assertFalse(repository.read(key).isPresent());
    }

    @Test
    void testGetAll() {
        LoanRepositoryImpl repository = LoanRepositoryImpl.getInstance();
        Loan loan1 = new Loan.Builder()
                .setLoanId("L005")
                .setIssueDate(LocalDate.of(2026, 3, 5))
                .setDueDate(LocalDate.of(2026, 3, 19))
                .build();

        Loan loan2 = new Loan.Builder()
                .setLoanId("L006")
                .setIssueDate(LocalDate.of(2026, 3, 6))
                .setDueDate(LocalDate.of(2026, 3, 20))
                .build();

        repository.create(loan1);
        repository.create(loan2);

        Collection<Loan> allLoans = repository.getAll();

        assertNotNull(allLoans);
        assertTrue(allLoans.size() >= 2);
    }
}

