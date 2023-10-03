package exercise4.handler_ting;

import java.util.HashSet;

public class HandlerList {

    HashSet<Handler> handlers = new HashSet<>();

    public void registerHandler(Handler handler) {
        handlers.add(handler);
    }

    public void unregisterHandler(Handler handler) {
        handlers.remove(handler);
    }

    public void update(String color) {
        for (Handler handler : handlers) {
            handler.update(color);
        }
    }


}
