package com.example.email_configuration.repository.impl;

import com.example.email_configuration.model.Mail;
import com.example.email_configuration.repository.IMailReponsitory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailReponsitory implements IMailReponsitory {
    private List<Mail> mailList = new ArrayList<>();
    @Override
    public List<Mail> findAll() {
        return mailList ;
    }

    @Override
    public void update(Mail mail) {
        mailList.add(mail);
    }
}