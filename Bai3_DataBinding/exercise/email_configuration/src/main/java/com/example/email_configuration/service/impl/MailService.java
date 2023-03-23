package com.example.email_configuration.service.impl;

import com.example.email_configuration.model.Mail;
import com.example.email_configuration.repository.IMailReponsitory;
import com.example.email_configuration.service.IMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailService implements IMaiService {
    @Autowired
    IMailReponsitory iMailReponsitory;
    @Override
    public List<Mail> findAll() {
        return iMailReponsitory.findAll();
    }

    @Override
    public void update(Mail mail) {
        iMailReponsitory.update(mail);
    }
}
