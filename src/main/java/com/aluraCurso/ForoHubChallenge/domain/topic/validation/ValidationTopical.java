package com.aluraCurso.ForoHubChallenge.domain.topic.validation;
import com.aluraCurso.ForoHubChallenge.domain.topic.DataTopic;
import com.aluraCurso.ForoHubChallenge.domain.topic.UpdateTopic;

public interface ValidationTopical {
    void validate(DataTopic data);

    void validate(UpdateTopic data);
}
