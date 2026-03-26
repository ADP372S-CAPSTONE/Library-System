/* MemberFactory.java
   Member factory class
   230240887 Nxasana Owenkosi
   
*/
package factory;

import domain.Member;

public class MemberFactory {

    public static Member createMember(String memberId, String name) {

        if (memberId == null || name == null) {
            throw new IllegalArgumentException("Member ID and name are required");
        }

        return new Member.Builder(memberId, name).build();
    }

    public static Member createMember(String memberId, String name,
                                      String email, String phone) {

        return new Member.Builder(memberId, name)
                .setMemberEmail(email)
                .setMemberPhone(phone)
                .build();
    }

    public static Member createMember(String memberId, String name,
                                      String email, String phone, String date) {

        return new Member.Builder(memberId, name)
                .setMemberEmail(email)
                .setMemberPhone(phone)
                .setMembershipDate(date)
                .build();
    }

    public static String generateMemberId(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        return String.format("M%03d", number);
    }
}