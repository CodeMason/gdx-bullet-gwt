/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet.collision;

import com.google.gwt.core.client.JavaScriptObject;

public class btDefaultCollisionConfiguration extends btCollisionConfiguration
{
	public btDefaultCollisionConfiguration()
	{
		this.jsObject = createObj();
	}
	
	private native JavaScriptObject createObj() /*-{
	  var obj = new $wnd.Ammo.btDefaultCollisionConfiguration();
	  return obj;
//	  $wnd.alert("Hello! I am an alert box!!");
	}-*/;
	
	
//	public native void setVaar(String value) /*-{
//	  $wnd.vaar = value;
//	}-*/;
//	
//	public native String getVaar() /*-{
//	  return $wnd.vaar;
//	}-*/;
//	
//	public static native String getVaar2() /*-{
//	  return $wnd.vaar;
//	}-*/;
}
