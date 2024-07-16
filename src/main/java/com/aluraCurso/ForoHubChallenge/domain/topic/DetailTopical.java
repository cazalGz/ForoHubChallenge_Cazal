package com.aluraCurso.ForoHubChallenge.domain.topic;

import java.time.LocalDateTime;

public record DetailTopical(
        String title,
        String message,
        LocalDateTime creationDate,
        TopicStatus status,
        Long author
) {
    public DetailTopical(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreation(), topic.getStatus(), topic.getAuthor().getId());
    }
}
