package com.friendsurance.processing;

import com.friendsurance.mail.EmailService;

import java.util.ArrayList;
import java.util.List;

/*
    The concrete implementation of ItemProcessing for Email system.
 */

public class EMailItemProcessing extends ItemProcessing<InputItem, OutputItem> {

    private EmailService.MailType defaultEmailType = EmailService.MailType.MAIL_TYPE_1;

    public EMailItemProcessing(ItemReader<InputItem> reader, ItemWriter<OutputItem> writer) {
        super(reader, writer);
    }

    protected OutputItem process(InputItem item) {
        Boolean hasContract = item.getUser().hasContract();

        Integer friends = item.getUser().getFriendsNumber();

        Integer invitations = item.getUser().getSentInvitationsNumber();

        EmailService.MailType mailType = calculateMailType(hasContract, friends, invitations);

        // There has been no valid status based on implemented algorithm
        if (mailType == null)
            return null;

        return new OutputItem(item.getUser(), mailType);
    }

    /*
        Analyzes the user status information and return the type of email should be sent to that particular user

        TODO: If this logic goes complicated in future and also dynamic (no momre static if-else) then we shall need to

        implement Rule Engine pattern in order to handle any new Rule enforced by management into our implementation

        without the need for changing below implementation.
     */
    private EmailService.MailType calculateMailType(Boolean hasContract, Integer friends, Integer invitations) {
        List<EmailService.MailType> userOptions = new ArrayList<EmailService.MailType>();

        if (hasContract){
            if (friends ==0 && invitations ==0)
                userOptions.add(EmailService.MailType.MAIL_TYPE_2);

            if (friends > 1 && invitations ==0)
                userOptions.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends > 3 && invitations > 1)
                userOptions.add(EmailService.MailType.MAIL_TYPE_1);

            if (friends < 3 && invitations > 1)
                userOptions.add(EmailService.MailType.MAIL_TYPE_2);

            if (friends < 3 && invitations > 6)
                userOptions.add(EmailService.MailType.MAIL_TYPE_3);
        }
        else {
            if (friends ==0 && invitations ==0)
                userOptions.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends ==0 && invitations > 3)
                userOptions.add(EmailService.MailType.MAIL_TYPE_3);

            if (friends > 1)
                userOptions.add(EmailService.MailType.MAIL_TYPE_4);

            if (friends > 4 && invitations > 3)
                userOptions.add(EmailService.MailType.MAIL_TYPE_5);
        }

        if (userOptions.isEmpty())
            return null;

        Integer max = userOptions.get(0).getValue();
        for (EmailService.MailType mailType: userOptions) {
               if (mailType.getValue() > max)
                   max = mailType.getValue();
        }

        /*
            TODO: changing to Java 8 will give us the power of Streams as below

        Integer max = userOptions.stream()
                .mapToInt(t -> t.getValue())
                .max().getAsInt();
         */

        return EmailService.MailType.tyoeOf(max);
    }



}
