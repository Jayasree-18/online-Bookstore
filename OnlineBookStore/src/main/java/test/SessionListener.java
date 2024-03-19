package test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class SessionListener implements HttpSessionListener,
HttpSessionAttributeListener{
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("Session Created...");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("Session Destroyed...");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute Added to session...");
		String aName = hsbe.getName();
		System.out.println("Attribute Name : "+aName);
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute Removed from Session....");
	}
	
}
