package org.skhuton.skhudebug.connection;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SSEProcessor {
    private final Map<String, SseEmitter> clients = new ConcurrentHashMap<>();

    public void registerClient(String clientId, SseEmitter emitter) throws IOException {
        if(this.clients.get(clientId) != null) {
            emitter.send("재접속이 성공적으로 완료됐습니다.");
        } else {
            this.clients.put(clientId, emitter);
            emitter.send(clientId);
        }
    }

    public void sendSseEvent(String clientId, Boolean message) {
        SseEmitter emitter = this.clients.get(clientId);
        if (emitter != null) {
            try {
                emitter.send(message);
                emitter.complete();
                this.clients.remove(clientId);
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        }
    }

    public void disconnectClient(String clientId) {
        SseEmitter emitter = this.clients.get(clientId);
        if (emitter != null) {
            emitter.complete();
            this.clients.remove(clientId);
        }
    }
}