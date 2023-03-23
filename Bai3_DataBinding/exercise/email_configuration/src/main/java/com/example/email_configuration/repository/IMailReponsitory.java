package com.example.email_configuration.repository;


import com.example.email_configuration.model.Mail;

import java.util.List;

public interface IMailReponsitory {
    List<Mail> findAll();

    void update(Mail mail);
}