package th.co.tac.cns.app.service.forwarder.management.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import java.io.Serializable;

@XmlRootElement(name = "InsufficientBalanceNotify")
@XmlAccessorType(XmlAccessType.NONE)
public class InsufficientBalanceNotify implements Serializable
{
	@XmlElement(name = "StreamNo")
	private String streamNo;
	
	@XmlElement(name = "CallingNumber")
	private String callingNumber;
	
	@XmlElement(name = "CalledNumber")
	private String calledNumber;
	
	@XmlElement(name = "CallingTime")
	private String callingTime;
	
	public InsufficientBalanceNotify() {}

	public String getStreamNo() {
		return streamNo;
	}

	public void setStreamNo(String streamNo) {
		this.streamNo = streamNo;
	}

	public String getCallingNumber() {
		return callingNumber;
	}

	public void setCallingNumber(String callingNumber) {
		this.callingNumber = callingNumber;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	public String getCallingTime() {
		return callingTime;
	}

	public void setCallingTime(String callingTime) {
		this.callingTime = callingTime;
	}
	
	@Override
	public String toString() 
	{
		return streamNo + " " + callingNumber + " " + calledNumber + " " + callingTime;
	}
}
