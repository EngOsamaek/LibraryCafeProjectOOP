package Email;

import FileOperations.FileReader;

public class CollectTakenEmail implements Mails {
    @Override
    public void sendEmail(java.lang.String book, java.lang.String UserID, java.lang.String deliverTime, java.lang.String givenTime) {
        try {
            new FileReader("customer");
            FileReader.customers.forEach(e->{
                if (e.getIDNum().equals(UserID)){
                    String mesaage= "Dear:"+e.getLastName()+"\nYou have returned:" + book + "  in:" + givenTime + " and You have taken it in:" + deliverTime;
                    new EmailUtil().sendEmail(e.getEmail(),mesaage);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
