package Email;

public abstract class Email {
Mails mails;
Email(Mails mails){
    this.mails=mails;
}
public abstract void execute();
}
