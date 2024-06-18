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
                        .title("������")
                        .status("�������")
                        .build(),
                Task.builder()
                        .id(2)
                        .title("������")
                        .status("�������")
                        .build(),
                Task.builder()
                        .id(3)
                        .title("������")
                        .status("� ������")
                        .build(),
                Task.builder()
                        .id(4)
                        .title("���������")
                        .status("�������")
                        .build(),
                Task.builder()
                        .id(5)
                        .title("�����")
                        .status("� ������")
                        .build(),
                Task.builder()
                        .id(6)
                        .title("������")
                        .status("�������")
                        .build()
        );
    }

}
