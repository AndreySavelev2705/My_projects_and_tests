import java.util.concurrent.*;

public class CreateThreads {

    public static void createThrd(String argsString) {

        ScheduledExecutorService scheduledExecutorServiceOfRFF = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorServiceOfRFF.schedule(ThreadOfReadFromFile.createAndStart(
                "Поток чтения файла", argsString), 0, TimeUnit.SECONDS);

        ScheduledExecutorService scheduledExecutorServiceOfOutputOC = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorServiceOfOutputOC.scheduleWithFixedDelay(ThreadOfOutputOnConsole.createAndStart(
                "Поток вывода на косоль"), 60, 60, TimeUnit.SECONDS);
    }
}