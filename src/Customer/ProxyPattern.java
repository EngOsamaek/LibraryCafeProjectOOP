package Customer;

import FileOperations.FileReader;
import Library.Observer.Subject;

public class ProxyPattern implements NotificationUpdate{
    Customer customer;
    Subject subject;
    public ProxyPattern(Subject subject){
        this.subject=subject;
    }
    @Override
    public void notifUpdate () {
        if (customer==null){
            customer=new Customer(subject );
        }
        customer.notifUpdate();
    }

}
