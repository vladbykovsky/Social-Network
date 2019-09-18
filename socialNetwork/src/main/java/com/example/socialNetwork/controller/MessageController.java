package com.example.socialNetwork.controller;

import com.example.socialNetwork.domain.Message;
import com.example.socialNetwork.domain.Views;
import com.example.socialNetwork.repository.MessageRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {


  private final MessageRepository messageRepository;

  @Autowired
  public MessageController(MessageRepository messageRepository){
      this.messageRepository = messageRepository;
  }

  @GetMapping
  @JsonView(Views.IdName.class)
  public List<Message> list(){
      return messageRepository.findAll();
  }

  @GetMapping("/{id}")
  @JsonView(Views.FullMessage.class)
  public Message getMessageById(@PathVariable("id") Message message){
      return message;
  }

  @PostMapping
  public Message createMessage(@RequestBody Message message){
      message.setCreationDate(LocalDateTime.now());
      return messageRepository.save(message);
  }

  @PutMapping("{id}")
  public Message updateMessage(@PathVariable("id") Message messageDB, @RequestBody Message message){
      BeanUtils.copyProperties(message, messageDB, "id");
      return messageRepository.save(messageDB);
  }

  @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
  public void deleteMessage(@PathVariable("id")Long id){
      messageRepository.deleteById(id);
  }

}
