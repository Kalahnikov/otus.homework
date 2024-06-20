package streem_api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
                        .title("First")
                        .status("Open")
                        .build(),
                Task.builder()
                        .id(2)
                        .title("Second")
                        .status("Open")
                        .build(),
                Task.builder()
                        .id(3)
                        .title("Third")
                        .status("At work")
                        .build(),
                Task.builder()
                        .id(4)
                        .title("Fourth")
                        .status("Closed")
                        .build(),
                Task.builder()
                        .id(5)
                        .title("Fifth")
                        .status("At work")
                        .build(),
                Task.builder()
                        .id(6)
                        .title("Sixth")
                        .status("Closed")
                        .build()
        );
    }

}
