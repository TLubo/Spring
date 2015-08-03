package pl.spring.demo.common;

import pl.spring.demo.to.IdAware;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class Sequence {

    public long nextValue(Collection<? extends IdAware> Ids) {
        long id = 1;
        for (IdAware nextId : Ids) {
            if (Long.compare(nextId.getId(), id) > 0) {
            	id = nextId.getId();
            }
        }
        id++;
        return id;
    }
}
