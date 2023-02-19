package com.example.simpleBot.Simple.Bot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.simpleBot.Simple.Bot.entities.Bot;

public interface SimpleBotRepository extends CrudRepository<Bot,Integer> {
public Bot save(Bot bot);
public Bot findByCommand(String com);
}
