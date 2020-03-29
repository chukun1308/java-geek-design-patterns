package com.chukun.designer.action.statistics.v2;

import com.chukun.designer.action.statistics.v1.EmailSender;
import com.chukun.designer.action.statistics.v1.RequestStat;
import java.util.Map;

/**
 * @author chukun
 * EmailViewer 负责将结果发送邮件
 */
public class EmailViewer implements StatViewer {

    private EmailSender emailSender;

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addAddress(String address) {
        emailSender.addToAddress(address);
    }


    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
