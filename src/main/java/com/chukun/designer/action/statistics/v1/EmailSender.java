package com.chukun.designer.action.statistics.v1;

import java.util.ArrayList;
import java.util.List;

public class EmailSender {

    private List<String> toAddressList;

    public EmailSender() {
        this.toAddressList = new ArrayList<>();
    }

    public void addToAddress(String address) {
        toAddressList.add(address);
    }
}
