package streem_api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public abstract class Tasks {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class Task {
        private int id;

        private String title;

        private String status;
    }

    public static Stream<Task> getTaskStream() {
        return Stream.of(
                Task.builder()
                        .id(1)
                        .title("Первая")
                        .status("Открыта")
                        .build(),
                Task.builder()
                        .id(2)
                        .title("Вторая")
                        .status("Открыта")
                        .build(),
                Task.builder()
                        .id(3)
                        .title("Третья")
                        .status("В работе")
                        .build(),
                Task.builder()
                        .id(4)
                        .title("Четвертая")
                        .status("Закрыта")
                        .build(),
                Task.builder()
                        .id(5)
                        .title("Пятая")
                        .status("В работе")
                        .build(),
                Task.builder()
                        .id(6)
                        .title("Шестая")
                        .status("Закрыта")
                        .build()
        );
    }

}
