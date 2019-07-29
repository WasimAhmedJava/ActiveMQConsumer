package activemq.springbootactivemqproducer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class Producer {
	
	@Autowired
	private JmsTemplate jmstemplate;
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/getMessage/{message}")
	public String publishMesage(@PathVariable("message") String message) {
		jmstemplate.convertAndSend(queue, message);
		System.out.println("Inside Publish Messsage");
		return "Published Successfully";
		
	}
	
}
