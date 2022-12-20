package com.netflix.backend.services;

public interface EmailService {
    void sendSimpleMail(final String toEmail, final String subject, final String content);
}