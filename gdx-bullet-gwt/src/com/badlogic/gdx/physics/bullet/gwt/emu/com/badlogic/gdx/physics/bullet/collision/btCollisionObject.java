package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.BulletBase;
import com.google.gwt.core.client.JavaScriptObject;

public class btCollisionObject extends BulletBase
{
	public Object userData;
	protected btCollisionShape collisionShape;
	protected int userValue;
	protected int contactCallbackFilter;
	protected int contactCallbackFlag = 1;
	protected GdxCollisionObjectBridge gdxBridge;
	
	public btCollisionObject() {
		gdxBridge = new GdxCollisionObjectBridge();
		jsObject = createMe();
	}

	public JavaScriptObject createMe() {
		JavaScriptObject createObj = createObj();
		internalSetGdxBridge(gdxBridge, createObj);
		return createObj;
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
		if (gdxBridge != null)
			gdxBridge.dispose();
		gdxBridge = null;
		collisionShape = null;
	}
	
	private native JavaScriptObject createObj() /*-{
		var obj = new $wnd.Ammo.btCollisionObject();
		obj.javaObject = this;
		return obj;
	}-*/;
	
	
	static protected native void internalSetGdxBridge(GdxCollisionObjectBridge gdxBridge, JavaScriptObject collObject) /*-{
		var bridgeJS = gdxBridge.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setUserPointer(bridgeJS);
	}-*/;
	public native void internalSetGdxBridge(JavaScriptObject collObject) /*-{
		var gdxBridge = this.@com.badlogic.gdx.physics.bullet.collision.btCollisionObject::gdxBridge;
		var bridgeJS = gdxBridge.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setUserPointer(bridgeJS);
	}-*/;
	public native void internalSetGdxBridge() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject
		var gdxBridge = this.@com.badlogic.gdx.physics.bullet.collision.btCollisionObject::gdxBridge;
		var bridgeJS = gdxBridge.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setUserPointer(bridgeJS);
	}-*/;
	
	protected void refCollisionShape(btCollisionShape shape) {
		if (collisionShape == shape)
			return;
		//		if (collisionShape != null)
		//			collisionShape.release();
		collisionShape = shape;
		//		collisionShape.obtain();
	}
	
	public native void setAnisotropicFriction(Vector3 anisotropicFriction, int frictionMode) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		var x = anisotropicFriction.@com.badlogic.gdx.math.Vector3::x;
		var y = anisotropicFriction.@com.badlogic.gdx.math.Vector3::y;
		var z = anisotropicFriction.@com.badlogic.gdx.math.Vector3::z;
		var tmpbtVector = @com.badlogic.gdx.physics.bullet.Bullet::TMP_btVector3js_1;
		tmpbtVector.setValue(x,y,z);
		collObject.setAnisotropicFriction(anisotropicFriction, frictionMode);
	}-*/;
	
	public native void setAnisotropicFriction(Vector3 anisotropicFriction) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		var x = anisotropicFriction.@com.badlogic.gdx.math.Vector3::x;
		var y = anisotropicFriction.@com.badlogic.gdx.math.Vector3::y;
		var z = anisotropicFriction.@com.badlogic.gdx.math.Vector3::z;
		var tmpbtVector = @com.badlogic.gdx.physics.bullet.Bullet::TMP_btVector3js_1;
		tmpbtVector.setValue(x,y,z);
		collObject.setAnisotropicFriction(anisotropicFriction);
	}-*/;
	
	public btCollisionShape getCollisionShape() {
		return collisionShape;
	}
	
	public native void setCollisionShape(btCollisionShape collisionShape) /*-{
		this.@com.badlogic.gdx.physics.bullet.collision.btCollisionObject::refCollisionShape(Lcom/badlogic/gdx/physics/bullet/collision/btCollisionShape;)(collisionShape)
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		var collShapeJS = collisionShape.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setCollisionShape (collShapeJS);
	}-*/;
	
	public native void setContactProcessingThreshold(int newState) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setContactProcessingThreshold(newState);
	}-*/;
	
	public native void setActivationState(int newState) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setActivationState(newState);
	}-*/;
	
	public native void forceActivationState(int newState) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.forceActivationState(newState);
	}-*/;
	
	public native void activate(boolean forceActivation) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.activate(forceActivation);
	}-*/;

	public native void activate() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.activate();
	}-*/;

	public native boolean isActive() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.isActive();
	}-*/;
	
	public native boolean isKinematicObject()/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.isKinematicObject();
	}-*/;
	
	public native boolean isStaticObject()/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.isStaticObject();
	}-*/;
	
	public native boolean isStaticOrKinematicObject()/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.isStaticOrKinematicObject();
	}-*/;
	
	public native void setRestitution(float rest)/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setRestitution(rest);
	}-*/;
	
	public native void setFriction(float frict)/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setFriction(frict);
	}-*/;
	
	public native void setRollingFriction(float frict)/*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setRollingFriction(frict);
	}-*/;
	
	private native JavaScriptObject getWorldTransformm() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.getWorldTransform();
	}-*/;

	public Matrix4 getWorldTransform() {
		com.badlogic.gdx.physics.bullet.linearmath.btTransform.getTransform(getWorldTransformm(), Bullet.TMP_Matrix4_1);
		return Bullet.TMP_Matrix4_1;
	}
	
	public void getWorldTransform(Matrix4 out) {
		com.badlogic.gdx.physics.bullet.linearmath.btTransform.getTransform(getWorldTransformm(), out);
	}
	
	public native int getCollisionFlags() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.getCollisionFlags();
	}-*/;

	public native void setCollisionFlags(int flag) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setCollisionFlags(flag);
	}-*/;
	
	public native float getDeactivationTime() /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.getDeactivationTime();
	}-*/;
	
	public native void setDeactivationTime(float time) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setDeactivationTime(time);
	}-*/;
	
	public native void setWorldTransform(Matrix4 transform) /*-{
		var transformJS = @com.badlogic.gdx.physics.bullet.Bullet::TMP_btTransformjs_1;
		@com.badlogic.gdx.physics.bullet.linearmath.btTransform::setTransform(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/badlogic/gdx/math/Matrix4;)(transformJS, transform);
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setWorldTransform(transformJS);
	}-*/;

	public native void setCcdMotionThreshold(float ccdMotionThreshold) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setCcdMotionThreshold(ccdMotionThreshold);
	}-*/;
	
	public native void setCcdSweptSphereRadius (float radius) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setCcdSweptSphereRadius(radius);
	}-*/;
	
	public native boolean getUserIndex () /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		return collObject.getUserIndex();
	}-*/;
	
	public native void setUserIndex (int index) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		collObject.setUserIndex(index);
	}-*/;
	
	public native void setInterpolationWorldTransform (Matrix4 trans) /*-{
		var collObject = this.@com.badlogic.gdx.physics.bullet.BulletBase::jsObject;
		var tmpbtTransform = @com.badlogic.gdx.physics.bullet.Bullet::TMP_btTransformjs_1;
		@com.badlogic.gdx.physics.bullet.linearmath.btTransform::setTransform(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/badlogic/gdx/math/Matrix4;)(tmpbtTransform, trans);
		collObject.setInterpolationWorldTransform(tmpbtTransform);
	}-*/;

	long pointer;
	
	public long getUserPointer () {
		return pointer; 
	}

	public void setUserPointer (long userPointer) {
		pointer = userPointer;
	}
	
	public int getUserValue () {
		return userValue;
	}
	
	public void setUserValue (int value) {
		gdxBridge.setUserValue(userValue = value);
	}
	
	public int getContactCallbackFlag() {
		return contactCallbackFlag;
	}
	
	public void setContactCallbackFlag(int flag) {
		gdxBridge.setContactCallbackFlag(contactCallbackFlag = flag);
	}

	public int getContactCallbackFilter() {
		return contactCallbackFilter;
	}
	
	public void setContactCallbackFilter(int filter) {
		gdxBridge.setContactCallbackFilter(contactCallbackFilter = filter);
	}
	
	public final static class CollisionFlags {
		public final static int CF_STATIC_OBJECT = 1;
		public final static int CF_KINEMATIC_OBJECT = 2;
		public final static int CF_NO_CONTACT_RESPONSE = 4;
		public final static int CF_CUSTOM_MATERIAL_CALLBACK = 8;
		public final static int CF_CHARACTER_OBJECT = 16;
		public final static int CF_DISABLE_VISUALIZE_OBJECT = 32;
		public final static int CF_DISABLE_SPU_COLLISION_PROCESSING = 64;
	}

	public final static class CollisionObjectTypes {
		public final static int CO_COLLISION_OBJECT = 1;
		public final static int CO_RIGID_BODY = 2;
		public final static int CO_GHOST_OBJECT = 4;
		public final static int CO_SOFT_BODY = 8;
		public final static int CO_HF_FLUID = 16;
		public final static int CO_USER_TYPE = 32;
		public final static int CO_FEATHERSTONE_LINK = 64;
	}

	public final static class AnisotropicFrictionFlags {
		public final static int CF_ANISOTROPIC_FRICTION_DISABLED = 0;
		public final static int CF_ANISOTROPIC_FRICTION = 1;
		public final static int CF_ANISOTROPIC_ROLLING_FRICTION = 2;
	}
}
