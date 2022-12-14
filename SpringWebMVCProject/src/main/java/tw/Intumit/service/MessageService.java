package tw.Intumit.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.Intumit.dao.MessageDao;
import tw.Intumit.model.Message;

@Service
public class MessageService {

	@Autowired
	private MessageDao mDao;

	public Message insert(Message message) {
		return mDao.insert(message);
	}

	public Message update(Message message) {
		return mDao.update(message);
	}

	public Message updateMes(Integer id, String account, String title, String postDate, String deadLine, String content)
			throws ParseException {
		return mDao.updateMes(id, account, title, postDate, deadLine, content);
	}

	public Boolean delete(Integer id) {
		return mDao.delete(id);
	}

	public List<Message> findAll() {
		return mDao.findAll();
	}

	public Message findOne(Integer id) {
		return mDao.findOne(id);
	}

}
