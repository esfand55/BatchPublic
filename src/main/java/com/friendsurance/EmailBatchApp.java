package com.friendsurance;

import com.friendsurance.backend.User;
import com.friendsurance.impl.CustomItemReader;
import com.friendsurance.impl.EmailItemWriter;
import com.friendsurance.processing.EMailItemProcessing;
import com.friendsurance.processing.InputItem;

import java.util.ArrayList;
import java.util.List;

/*
        Sample execution of the program is given here.

        ToDO: the program need to be executed using specific scheduling framework such as Cron job like 0 0 3 * * ? "

        This can be done by the help of API from Quartz
 */
public class EmailBatchApp {

    public static void main(String[] args) {

        List<InputItem> items = new ArrayList<InputItem>();

        items.add(new InputItem(new User("a@abc.com" , false, 0, 0)));
        items.add(new InputItem(new User("b@abc.com" , false, 3, 0)));
        items.add(new InputItem(new User("c@abc.com" , false, 4, 2)));
        items.add(new InputItem(new User("d@abc.com" , false, 2, 2)));
        items.add(new InputItem(new User("e@abc.com" , false, 2, 10)));
        items.add(new InputItem(new User("f@abc.com" , true, 0, 0)));
        items.add(new InputItem(new User("g@abc.com" , true, 0, 5)));
        items.add(new InputItem(new User("h@abc.com" , true, 2, 2)));
        items.add(new InputItem(new User("i@abc.com" , true, 5, 4)));

        EMailItemProcessing mailItemProcessing = new EMailItemProcessing(new CustomItemReader(items),
                new EmailItemWriter());

        mailItemProcessing.doProcessing();
    }
}
