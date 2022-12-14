package tw.Intumit.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import tw.Intumit.model.Message;

@Repository
public class MessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Message insert(Message message) {
		Session session = sessionFactory.openSession();
		session.save(message);
		session.close();
		return message;
	}

	public Message update(Message message) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Message oldMessage = session.get(Message.class, message.getId());
		if (oldMessage != null) {
			oldMessage.setTitle(message.getTitle());
			oldMessage.setContent(message.getContent());
			oldMessage.setDeadLine(message.getDeadLine());
			System.out.println("更新完成");
			session.getTransaction().commit();
			session.close();
			return oldMessage;
		} else {
			System.out.println("更新失敗");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
	}

	public Message updateMes(Integer id, String account, String title, String postDate, String deadLine, String content) throws ParseException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		String hqlstr = "from Message where id=:id ";
//		Query<Message> query = session.createQuery(hqlstr, Message.class);
//		query.setParameter("id", id);
//		Message oldMessage = query.getSingleResult();

		Message oldMessage = session.get(Message.class, id);
		if (oldMessage != null) {
			oldMessage.setAccount(account);
			oldMessage.setTitle(title);
			oldMessage.setContent(content);
			Date datePostDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(postDate + " 00:00:00.000");
			Date dateDeadLine = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(deadLine + " 00:00:00.000");
			oldMessage.setPostDate(datePostDate);
			oldMessage.setDeadLine(dateDeadLine);
			System.out.println("更新完成");
			session.getTransaction().commit();
			session.close();
			return oldMessage;
		} else {
			System.out.println("更新失敗");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
	}

	public Boolean delete(Integer id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message message = session.get(Message.class, id);
		if (message == null) {
			System.out.println("刪除失敗");
			session.getTransaction().rollback();
			session.close();
			return false;
		} else {
			session.delete(message);
			session.getTransaction().commit();
			session.close();
			return true;
		}
	}

	public List<Message> findAll() {
		Session session = sessionFactory.openSession();
		String hqlStr = "from Message order by postDate DESC";
		Query<Message> query = session.createQuery(hqlStr, Message.class);
		List<Message> rsList = query.list();
		session.close();
		return rsList;
	}

//	public Page<Message> findAllInPage() {
//		Session session = sessionFactory.openSession();
//
//		Pageable pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "postDate");
//		Page<Message> page = messageDao.findAll(pageRequest);
//		session.close();
//
//		return page;
//	}

	public Message findOne(Integer id) {
		Session session = sessionFactory.openSession();
		String hqlstr = "from Message where id=:id ";
		Query<Message> query = session.createQuery(hqlstr, Message.class);
		query.setParameter("id", id);
		Message message = query.getSingleResult();
		session.close();
		if (message != null) {
			System.out.println("找到訊息");
			return message;
		} else {
			System.out.println("查詢失敗");
			return null;
		}
	}

}
