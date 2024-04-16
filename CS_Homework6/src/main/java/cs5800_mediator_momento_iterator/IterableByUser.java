package cs5800_mediator_momento_iterator;

import java.util.Iterator;

public interface IterableByUser {
    Iterator iterator(User userToSearchWith);
}