package BestGymEver;

import java.time.LocalDate;

public class Member {

    private String name;
    private String socialSecurityNumber;
    private LocalDate membershipPaidDate;

    public Member(String socialSecurityNumber, String name, LocalDate membershipPaidDate) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.membershipPaidDate = membershipPaidDate;
    }

    // membership active date from membership paid, return data form of true or false
    // if currentDate minus 1 year is before than membership paid date. # TRUE
    // ex) Local date 2024-10-21 / current date minus 1 year 2023-10-21 / paid date 2024-07-01 #True
    // ex) Local date 2024-10-21 / current date minus 1 year 2023-10-21 / paid date 2023-07-01 #False
    public boolean isMembershipActive(LocalDate currentDate){
        return currentDate.minusYears(1).isBefore(membershipPaidDate);
    }

    // to calculate membership valid date that will use both for the active/inactive membership
    public LocalDate membershipVaildUntilDate (){
        return membershipPaidDate.plusYears(1);
    }

    // getter and setter to be used in Member Search class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String personalNumber) {
        this.socialSecurityNumber = personalNumber;
    }

    public LocalDate getMembershipPaidDate() {
        return membershipPaidDate;
    }

    public void setMembershipPaidDate(LocalDate membershipPaidDate) {
        this.membershipPaidDate = membershipPaidDate;
    }
}
