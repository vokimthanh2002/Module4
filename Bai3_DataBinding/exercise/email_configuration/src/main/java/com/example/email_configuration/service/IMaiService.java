package com.example.email_configuration.service;

import com.example.email_configuration.model.Mail;

import java.util.List;

public interface IMaiService {
    List<Mail> findAll();

    void update(Mail mail);
}
