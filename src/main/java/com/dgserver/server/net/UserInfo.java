package com.dgserver.server.net;

import org.apache.mina.core.session.IoSession;

import com.dgserver.server.net.buffer.JoyBuffer;

public class UserInfo {
	long uid;
	IoSession session;
	public void serialize(JoyBuffer out)
    {
      out.putLong(this.uid);
    }

    public void deserialize(JoyBuffer in)
    {
      this.uid = in.getLong();
    }

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	} 
	
	
}
