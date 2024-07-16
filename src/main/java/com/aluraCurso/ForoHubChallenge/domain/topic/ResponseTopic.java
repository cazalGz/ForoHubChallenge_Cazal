package com.aluraCurso.ForoHubChallenge.domain.topic;

import java.time.LocalDateTime;

public record ResponseTopic(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        Long author,
        String course
) {
    public ResponseTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreation(), topic.getStatus().toString(), topic.getAuthor().getId(), topic.getCourse());
    }
}
