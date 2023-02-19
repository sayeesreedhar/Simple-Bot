package com.example.simpleBot.Simple.Bot.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.simpleBot.Simple.Bot.entities.Bot;
import com.example.simpleBot.Simple.Bot.repository.SimpleBotRepository;

@Service
public class SimpleBotService {
	@Autowired
	SimpleBotRepository r;
public Bot addcommand(Bot bot) {
	return r.save(bot);
}
public Object findcommandresult(String com) throws IOException {
	String[] res=com.split("-");
	Object result;
	Bot m=r.findByCommand(res[0].toLowerCase());
	if(m.getApitype().equalsIgnoreCase("internal")) {
		return (Object)r.findByCommand(res[0].toLowerCase()).getQuery();
	}
	else if(m.getApitype().equalsIgnoreCase("internal-exec")) {
		Runtime op= Runtime.getRuntime();
		op.exec(res[1]);
		
		return (Object)"Task executed successfully";
	}
	else
	{
		RestTemplate temp=new RestTemplate();
		String payload=m.getApiurl()+res[1];
		result=temp.getForObject(payload, Object.class);
	}
	return result;
}
public Bot updatecommand(Bot bot) {
	Bot update=r.findByCommand(bot.getCommand());
	
	update.updateQuery(update.getId(),bot.getCommand(),bot.getQuery(),bot.getApiurl(),bot.getApitype(),bot.getApikey());
	return r.save(update);
}
}
