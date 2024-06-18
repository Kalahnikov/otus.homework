package streem_api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streem_api.Tasks.*;

public class StreamProcessor {

    public static List<Task> getListTasks(String statusTask) {
        Stream<Task> tasks = Tasks.getTaskStream();

        List<Task> filteredTasks;
        filteredTasks = tasks
                .filter(task -> task.getStatus() != null)
                .filter(task -> task.getStatus().equals(statusTask))
                .toList();
        return filteredTasks;
    }


    public static List<Task> getListTasksSorted() {
        Stream<Task> tasks = Tasks.getTaskStream();


        List<Task> sortedTasks;
        sortedTasks = tasks
                .sorted(Comparator.comparing(Task::getStatus).reversed())
                .collect(Collectors.toList());
        return sortedTasks;
    }

    public static boolean checkTask(int id) {
        Stream<Task> tasks = Tasks.getTaskStream();

        boolean checkIdTasks;
        checkIdTasks = tasks
                .anyMatch(task -> task.getId() == id);
        return checkIdTasks;
    }

    public static int countNumberTasks(String statusTask) {
        Stream<Task> tasks = Tasks.getTaskStream();

        int countTasks;
        countTasks = Math.toIntExact(tasks
                .filter(task -> task.getStatus() != null)
                .filter(task -> task.getStatus().equals(statusTask)).count());
        return countTasks;
    }
}
