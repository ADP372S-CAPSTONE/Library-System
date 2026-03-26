/**
 * Author: Sinazo Ntsimbi
 * 222765208
 * Date: 16 March 2026
 */

package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {

    private final String loanId;
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private final LocalDate returnDate;

    // Private constructor (Builder Pattern requirement)
    private Loan(Builder builder) {
        this.loanId = builder.loanId;
        this.issueDate = builder.issueDate;
        this.dueDate = builder.dueDate;
        this.returnDate = builder.returnDate;
    }

    // Getters
    public String getLoanId() {
        return loanId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String loanId;
        private LocalDate issueDate;
        private LocalDate dueDate;
        private LocalDate returnDate;

        public Builder setLoanId(String loanId) {
            this.loanId = loanId;
            return this;
        }

        public Builder setIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Loan build() {

            if (loanId == null || loanId.isEmpty() || !loanId.startsWith("L")) {
                throw new IllegalArgumentException("Loan ID must not be null and must start with 'L'");
            }

            if (issueDate == null) {
                throw new IllegalArgumentException("Issue date is required");
            }

            if (dueDate == null) {
                throw new IllegalArgumentException("Due date is required");
            }

            if (dueDate.isBefore(issueDate)) {
                throw new IllegalArgumentException("Due date cannot be before issue date");
            }

            // returnDate can be null (book not yet returned)

            return new Loan(this);
         }
    }
}












