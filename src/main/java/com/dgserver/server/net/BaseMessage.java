package com.dgserver.server.net;

import com.dgserver.server.net.buffer.JoyBuffer;
import java.io.Serializable;

public class BaseMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6520956222682490946L;
	
	private UserInfo userInfo = null;
	private int length;
	private byte msgType = 0;
	private byte result = 0;
	
	public int GetProtocol(){
		return 0;
	}
    public void serialize(JoyBuffer in){
    	in.skip(4);
		in.putInt(GetProtocol());
    	in.put(msgType);
    	in.put(result);
    }
    public void deserialize(JoyBuffer in){
    	length = in.getInt();//长度
    	in.getInt();//协议id
    	msgType = in.get();
    	result = in.get();
    }
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
	public void Send(){
		ServerManager.GetInstance().SendMessage(this);
	}
	public byte getMsgType() {
		return msgType;
	}
	public void setMsgType(byte msgType) {
		this.msgType = msgType;
	}
	public byte getResult() {
		return result;
	}
	public void setResult(byte result) {
		this.result = result;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
