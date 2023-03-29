package com.example.BLPS_l1.services.mail.service.web;

import com.example.BLPS_l1.services.mail.models.Message;
import com.example.BLPS_l1.services.mail.service.logic.MailBusinessLogic;
import com.example.BLPS_l1.services.mail.service.web.model.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/mail")
public class NetworkMailController {

    @Autowired
    MailBusinessLogic mailBusinessLogic;

    @Autowired
    ConversionService conversionService;

    @GetMapping("/getMessages")
    public List<MessageDto> getMessages() {
        return mailBusinessLogic.getMessages().stream()
                .map(e -> conversionService.convert(e, MessageDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/writeMessage")
    public void writeMessage(@Valid @RequestBody MessageDto messageDto) {
        mailBusinessLogic.writeMessage(conversionService.convert(messageDto, Message.class));
    }
}
