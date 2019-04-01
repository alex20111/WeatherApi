package net.weather.utils;

import java.util.ArrayList;
import java.util.List;

import net.weather.bean.Message;

public class MessageHandl {

	List<Message> msgs;
	
	public MessageHandl(List<Message> msgs){		
		this.msgs = msgs;		
	}
	
	
	public List<Message> returnAllErrors(){
		List<Message> errors = new ArrayList<Message>();
		if (this.msgs != null){			
			for(Message m : msgs){
				if (Message.ERROR == m.getType()){
					errors.add(m);
				}
			}
		}
		return errors;
	}
	
	public List<Message> returnAllInfos(){
		List<Message> messages = new ArrayList<Message>();
		if (this.msgs != null){			
			for(Message m : msgs){
				if (Message.INFO == m.getType()){
					messages.add(m);
				}
			}
		}
		return messages;
	}
	
	
	public int errorCount(){
		
		int cnt = 0;
		if (this.msgs != null){			
			for(Message m : msgs){
				if (Message.ERROR == m.getType()){
					cnt ++;
				}
			}
		}
		return cnt;
	}
	public int infoCount(){
		int cnt = 0;
		if (this.msgs != null){			
			for(Message m : msgs){
				if (Message.INFO == m.getType()){
					cnt ++;
				}
			}
		}
		return cnt;
	}
	
	public int messageCount(){
		return this.msgs.size();
	}
	public List<Message> getAllMessages(){
		return msgs;
	}
	public void setAllMessages(List<Message> messages) {
		this.msgs = messages;
	}
	public String returnFormattedMessages() {
		StringBuilder sb = new StringBuilder();
		for(Message m : msgs) {
			sb.append("Title: " + m.getTitle() + "\nMessage: " + m.getMessage() + "\nType: " + (m.getType() == Message.INFO? "INFO" : "ERROR") );
		}
		return sb.toString();
	}
}
