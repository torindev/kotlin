package some_java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainJava {

    public static void main(String[] args) {
        List<RemoteMediaItem> list = RemoteMediaItem.getTestList();

        Map<String, List<RemoteMediaItem>> personsByAge = list
                .stream()
                .collect(Collectors.groupingBy(p -> p.getmCreator()));

        for (RemoteMediaItem item : list) {
            System.out.println("creator: " + item.getmCreator() + ", clip: " + item.getmUUID());
        }

        for (Map.Entry<String, List<RemoteMediaItem>> pair : personsByAge.entrySet()) {
            System.out.println(pair.getKey() + ", count = " + pair.getValue().size());
        }


    }
}

