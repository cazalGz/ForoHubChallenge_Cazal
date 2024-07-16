package com.aluraCurso.ForoHubChallenge.domain.topic;

import com.aluraCurso.ForoHubChallenge.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String message;
    private LocalDateTime creation;
    @Enumerated(EnumType.STRING)
    private TopicStatus status;
    @JoinColumn(name = "author_id")
    @ManyToOne
    private User author;
    private String course;

    public Topic(User user, DataTopic topic) {
        this.title = topic.title();
        this.message = topic.message();
        this.creation = LocalDateTime.now();
        this.status = TopicStatus.CREADO;
        this.author = user;
        this.course = topic.course();
    }

    public void delete() {
        this.status = TopicStatus.ELIMINADO;
    }

    public void update() {
        this.status = TopicStatus.MODIFICADO;
    }
}
