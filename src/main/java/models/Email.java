package models;

import javax.mail.Multipart;

public class Email {
    private String from, to, fromPass, subject;
    private Multipart content;

    public Email(String from, String to, String fromPass, String subject, Multipart content) {
        this.from = from;
        this.to = to;
        this.fromPass = fromPass;
        this.subject = subject;
        this.content = content;
    }

    public Email() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromPass() {
        return fromPass;
    }

    public void setFromPass(String fromPass) {
        this.fromPass = fromPass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Multipart getContent() {
        return content;
    }

    public void setContent(Multipart content) {
        this.content = content;
    }
}
