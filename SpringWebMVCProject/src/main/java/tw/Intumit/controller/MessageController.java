package tw.Intumit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.Intumit.model.Message;
import tw.Intumit.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService mService;

	@ResponseBody
	@GetMapping(path = "/message.findOne/{id}")
	public Message findOne(@PathVariable Integer id) {
		return mService.findOne(id);
	}

	@GetMapping(path = "/message.boardPage")
	public String findAll(Model m) {
		List<Message> list = mService.findAll();
		m.addAttribute("list", list);
		return "messageBoard";
	}

	@GetMapping(path = "/message.create")
	public String insertMessage(@RequestParam("account") String account, @RequestParam("title") String title,
			@RequestParam("postDate") String postDate, @RequestParam("deadLine") String deadLine,
			@RequestParam("content") String content) throws ParseException {

		System.out.println(postDate);
		System.out.println(deadLine);
		Date datePostDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(postDate + " 00:00:00.000");
		Date dateDeadLine = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(deadLine + " 00:00:00.000");
		Message message = new Message();

		message.setAccount(account);
		message.setTitle(title);
		message.setDeadLine(datePostDate);
		message.setPostDate(dateDeadLine);
		message.setContent(content);
		mService.insert(message);
		return "redirect:/message.boardPage";
	}

	@GetMapping(path = "/message.delete/{id}")
	public String deleteMessage(@PathVariable("id") Integer id) {
		mService.delete(id);
		return "redirect:/message.boardPage";
	}

	@GetMapping(path = "/message.update/{id}")
	public String updateMessagePage(@PathVariable("id") Integer id, Model m) {
		Message message = mService.findOne(id);
		// 日期調整
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date postDate = message.getPostDate();
		String formatPostDate = dateFormat.format(postDate);
		Date deadLine = message.getDeadLine();
		String formatDeadLine = dateFormat.format(deadLine);

		m.addAttribute("message", message);
		m.addAttribute("formatPostDate", formatPostDate);
		m.addAttribute("formatDeadLine", formatDeadLine);
		return "updateMessagePage";
	}

	@GetMapping(path = "/message.updateAction")
	public String updateMessageAction(@RequestParam("id") Integer id, @RequestParam("account") String account,
			@RequestParam("title") String title, @RequestParam("postDate") String postDate,
			@RequestParam("deadLine") String deadLine, @RequestParam("content") String content) throws ParseException {
		System.out.println("進入controller");
		mService.updateMes(id, account, title, postDate, deadLine, content);
		System.out.println("修改完成");

		return "redirect:/message.boardPage";
	}

//	@GetMapping(path = "/message.updateAction")
//	public String updateMessageAction(@ModelAttribute(name = "message") Message message) {
//		System.out.println("進入controller");
//		System.out.println(message.getId());
//		mService.update(message);
//		System.out.println("修改完成");
//
//		return "redirect:/message.boardPage";
//	}

}
