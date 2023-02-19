package com.example.simpleBot.Simple.Bot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleBot.Simple.Bot.entities.Bot;
import com.example.simpleBot.Simple.Bot.service.SimpleBotService;

@RestController
@RequestMapping("/command")
public class SimpleBotController {
	@Autowired
	SimpleBotService s;
	@PostMapping("/add")
	public Bot addcommand(@RequestBody Bot bot) {
		
		return s.addcommand(bot);
		
	}
	@GetMapping("/find/{com}")
	public Object findcommand(@PathVariable("com") String com) throws IOException {
		return s.findcommandresult(com);
	}
	@PutMapping("/update")
	public Bot updatecommand(@RequestBody Bot bot) {
		
		return s.updatecommand(bot);
		
	}
	

}
