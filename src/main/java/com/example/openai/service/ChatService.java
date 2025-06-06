package com.example.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String message) {
        return chatClient.prompt() // 프롬프트 생성
                .user(message) // 사용자 메시지
                .call() // 호출
                .content(); // chatResponse --> 요청정보를 받는 부분(문자열)
    }

    public String chatmessage(String message) {

        return chatClient.prompt()
                .user(message) // 뉴턴의 운동 제2법칙을 간단하게 설명하세요
                .call()
                .chatResponse() // ChatResponse
                .getResult()
                .getOutput()
                .getText();
    }
}
