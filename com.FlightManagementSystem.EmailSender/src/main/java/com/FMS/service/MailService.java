package com.FMS.service;

import com.FMS.Model.EmailStructure;

public interface MailService {

	public void sendMail(String mail, EmailStructure structure);
}
