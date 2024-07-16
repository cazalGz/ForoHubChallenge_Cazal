package com.aluraCurso.ForoHubChallenge.domain.topic.validation;
import com.aluraCurso.ForoHubChallenge.domain.topic.TopicDataUpdate;
import com.aluraCurso.ForoHubChallenge.domain.topic.UpdateTopic;
import com.aluraCurso.ForoHubChallenge.domain.user.User;

public interface UpdateValidation {
    void validate(TopicDataUpdate data, User user);

    void validate(UpdateTopic data, User user);
}
