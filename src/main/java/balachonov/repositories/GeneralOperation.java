package balachonov.repositories;

import java.util.List;
import java.util.Optional;

public interface GeneralOperation<T, E, D> {
    Optional<E> create(D d);

    List<E> readAll();

    List<E> readAllWithRestriction(T t);

    Optional<E> readById(T t);

    Optional<E> update(D d);

    Optional<E> delete(D d);
}
