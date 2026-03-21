
package domain;
/*
 * Author: Sinazo Ntsimbi
 * 222765208
 */
import java.time.LocalDate;
import java.util.Objects;

public class Loan
{
    private String loanId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private Loan(Builder builder) {
        this.loanId = builder.loanId;
        this.issueDate = builder.issueDate;
        this.dueDate = builder.dueDate;
        this.returnDate = builder.returnDate;
    }

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
        return "Loan{" + "loanId='" + loanId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate + '}';
    }

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
                if (loanId == null || !loanId.startsWith("L")) {
                    throw new IllegalArgumentException("Invalid loan ID");
                }

                if (issueDate == null) {
                    throw new IllegalArgumentException("Issue date is required");
                }

                if (dueDate == null || dueDate.isBefore(issueDate)) {
                    throw new IllegalArgumentException("Invalid due date");
                }

                return new Loan(this);
            }
    }
}

