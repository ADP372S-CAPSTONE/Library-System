
# 3rd Year AppDev Library System

## Domain

A specialized library management system tailored for Cape Peninsula University of Technology (CPUT) 3rd-year Application Development students. The system manages a catalog of academic textbooks categorized by final-year modules (e.g., Software Engineering, Database, Project, IT Governance, Financial Accounting, Data Analytics, Ethical hacking, Web framework) and tracked by their respective Publishers

## How it works

- Registered Members can initiate Loans for available books and create Reservations for titles currently in use.
- The Specialized Librarian roles are responsible for managing the lifecycle of both Loans and Reservations, ensuring data integrity and availability.
- The system enforces business rules through automated tracking of issue dates, due dates, and reservation expiry dates.

## Entities
- **Book**: Textbooks available in the library
- **Member**: 3rd year students who can borrow books
- **Loan**: Records of books borrowed
- **Librarian**: Staff who manage the library
- **Category**: Book categories (Software Eng, Database, Project Management, etc.)

## Group Members
- Leader: 1: TIYANI NGWANA      231266731 - Category and Publisher Entity
- Member 2: ABULELE NTWANAMBI 218276400 - Reservation Entity
- Member 3: NOMHLE NJENGELE   216227488 - Book Entity
- Member 4: OWENKOSI NXASANA  230240887 - Member Entity
- Member 5: SINAZO NTSIMBI    222765208 - Loan Entity
- Member 6: SINETHEMBA NYIMBINYA 220085870 - Librarian Entity

 ## Contributing Guidelines
  
 ### **Pull Request Process** 
- Create a branch with your student number
- Implement your feature with tests
- Ensure all tests pass
- Update documentation if needed
- Create a Pull Request to main branch
- Request review from team lead
- Address review comments

 ### **Merge after approval**

- Code Review Checklist
- Follows Builder Pattern
- Includes TDD tests
- Proper package placement
- Author comments included
- No merge conflicts
- All tests passing


## UML Diagram

<img width="810" height="810" alt="UML Diagram" src="https://github.com/user-attachments/assets/b77d1043-2701-4332-9054-6ff3d956d43e" />
