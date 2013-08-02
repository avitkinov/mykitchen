/*
 * PasswordRenewBean.java
 *
 * $Id$
 *
 * Copyright (c) 2001-2010 Administration Intelligence AG,
 * Steinbachtal 2b, 97082 Wuerzburg, Germany.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Administration Intelligence AG ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with Administration Intelligence.
 */
package mykitchen.web.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mykitchen.util.NavigationPage;

import org.apache.log4j.Logger;


/**
 * Controls password restoration. Send an email with a link in order user to reset the password.
 * 
 * @author Asparuh Vitkinov
 * 
 */
@ManagedBean(name = "passwordRenewBean")
@ViewScoped
public class PasswordRenewManagedBean implements Serializable
{
  /** Serial verison UID. */
  private static final long serialVersionUID = -100874172946613913L;
  /** Logger. */
  private static final Logger cLogger = Logger.getLogger(PasswordRenewManagedBean.class);
  /** Email validation pattern. */
  private final String EMAIL_PATTERN =
    "^(([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})+([;.](([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})+)*$";

  /**
   * Initialize password renew managed bean.
   */
  @PostConstruct
  public void postContruct()
  {
    cLogger.info("Initialize PasswordRenewManagedBean");
  }

  /** Variable for email field. */
  private String iEmail;

  /**
   * Get email of user.
   * 
   * @return the email of user
   */
  public String getEmail()
  {
    return iEmail;
  }

  /**
   * Set email of user.
   * 
   * @param aEmail the email of user to set
   */
  public void setEmail(String aEmail)
  {
    this.iEmail = aEmail;
  }

  public String getEMAIL_PATTERN()
  {
    return EMAIL_PATTERN;
  }

  /**
   * Send a new password to introduced e-mail.
   * 
   * @return success and redirect user to login page if e-mail is sent successfully, otherwise
   * return error message to user.
   */
  public String passwordRenew()
  {
    return NavigationPage.LOGIN.value();
  }

}
