package mykitchen.web.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mykitchen.util.UserSessionHelper;

import org.apache.log4j.Logger;


/**
 * Session listener for create and destroy session.
 * 
 * @author Asparuh Vitkinov
 */
public class SessionListener implements HttpSessionListener
{
  /** Logger. */
  private static final Logger cLog = Logger.getLogger(SessionListener.class);

  @Override
  public void sessionCreated(HttpSessionEvent aEvent)
  {
    cLog.info("Create session");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent aEvent)
  {
    cLog.info("Destroy session " + aEvent.getSession().getAttribute(UserSessionHelper.LOG_IN_USER));
  }

}
