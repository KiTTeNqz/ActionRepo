package com.example.actionexecutordemo.actions;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс реализует выполнение метода rest api
 *
 * @author Vasiliy.Andricov
 */
@Builder(access = AccessLevel.PUBLIC)
@Slf4j
public class ActionExecutorBuilder<T, V> {

    @Singular("rules")
    private final List<RuleInterface<T>> rules;

    /**
     * Выполнение списка правил для метода в порядке указаном в order
     *
     * @return
     */
    public ActionExecutorBuilder<T, V> executeRules() {
        Optional.ofNullable(rules).ifPresent(item -> item.stream()
                .sorted((o1, o2) -> o1.getOrder() - o2.getOrder())
                .peek(t -> log.info("Выполнение правила {} : {}", t.getOrder(), t.getName()))
                .map(t -> Pair.of(t.getOrder(), t.execute()))
                .peek(t -> log.info("Результат выполнения правила {} : {}", t.getFirst(), t.getSecond()))
                .map(Pair::getSecond)
                .collect(Collectors.toList()));
        return this;
    }

    /**
     * Выполнение основного метода
     *
     * @param action
     * @return
     */
    public V executeFinalAction(RestActionInterface<V> action) throws IOException {
        log.info("Выполнение метода : {}", action.getName());
        return action.execute();
    }
}
