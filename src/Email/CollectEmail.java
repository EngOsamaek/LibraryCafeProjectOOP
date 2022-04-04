package Email;

import FileOperations.FileReader;

public class CollectEmail implements Mails {

    @Override
    public void sendEmail(String book, String UserID, String deliverTime, String givenTime) {
        try {
            new FileReader("customer");
            FileReader.customers.forEach(e->{
                if (e.getIDNum().equals(UserID)){
                    String mesaage= "Dear:"+e.getLastName()+"\nYou have taken:" + book + "  in:" + deliverTime + " and should be returned by:" + givenTime;
                    new EmailUtil().sendEmail(e.getEmail(),mesaage);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
