/**
 *Author: Sinazo Ntsimbi
 * 222765208
 * Date: 16 March 2026
 */
package factory;


import domain.Loan;
import java.time.LocalDate;

public class LoanFactory {
    public static Loan createLoan(String loanId, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        return new Loan.Builder()
                .setLoanId(loanId)
                .setIssueDate(issueDate)
                .setDueDate(dueDate)
                .setReturnDate(returnDate)
                .build();

    }

    //End of program
}


