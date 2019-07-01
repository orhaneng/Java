package org.orhan.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.orhan.javabrains.messenger.database.DatabaseClass;
import org.orhan.javabrains.messenger.exception.DataNotFoundException;
import org.orhan.javabrains.messenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	static {
		messages.put(1L, new Message(1, "Hello World", "kousihk"));
		messages.put(2L, new Message(2, "Hello Jersey", "kousihk"));
	}

	public MessageService() {

	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}

	public List<Message> getAllMessagesForPaginated(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message msg= messages.get(id);
		if(msg==null) {
			throw new DataNotFoundException("Message with id "+id+" not found");
		}
		return msg;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
