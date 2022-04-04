package Email;

public class EmailExecutor extends Email {
    String book,UserID,deliverTime,givenTime;
   public EmailExecutor(String book, String UserID, String deliverTime, String givenTime, Mails mails){
       super(mails);
this.book=book;
this.UserID=UserID;
this.deliverTime=deliverTime;
this.givenTime=givenTime;
   }
    @Override
    public void execute() {
mails.sendEmail(this.book,this.UserID,this.deliverTime,this.givenTime);
    }
}
