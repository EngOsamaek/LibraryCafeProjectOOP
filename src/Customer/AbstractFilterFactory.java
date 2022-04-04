package Customer;

import java.util.List;

public abstract interface   AbstractFilterFactory {
    abstract Criteria getCriteria(List<Criteria> criteriaList);
}
