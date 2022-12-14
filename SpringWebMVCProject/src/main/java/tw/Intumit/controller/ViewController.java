package tw.Intumit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping(path = "/test")
	public String testJSP() {
		return "test";
	}

	@GetMapping(path = "/message.board")
	public String messageBoard() {
		return "messageBoard";
	}
	
	@GetMapping(path="/message.new")
	public String newMessagePage() {
		return "insertMessage";
	}

}
