package nl.rdb.java_examples.filter_pattern;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class FilterBuilder<T> {

    private final List<EntityFilter<T>> filters = new LinkedList<>();
    private FilterType type = FilterType.ALL_MATCH;
    private Collection<T> toFilter;

    public FilterBuilder<T> toFilter(Collection<T> toFilter) {
        this.toFilter = toFilter;
        return this;
    }

    public FilterBuilder<T> setFilterType(FilterType type) {
        this.type = type;
        return this;
    }

    public FilterBuilder<T> add(EntityFilter<T> filter) {
        this.filters.add(filter);
        return this;
    }

    public Set<T> toSet() {
        FilterMethods<T> filterMethod = new FilterMethods<>(type, filters);
        return toFilter.stream()
                .filter(filterMethod::getFilterFn)
                .collect(Collectors.toSet());
    }

    public List<T> toList() {
        FilterMethods<T> filterMethod = new FilterMethods<>(type, filters);
        return toFilter.stream()
                .filter(filterMethod::getFilterFn)
                .collect(Collectors.toList());
    }

    private record FilterMethods<T>(FilterType type, List<EntityFilter<T>> filters) {

        public boolean getFilterFn(T value) {
            if (type == FilterType.ALL_MATCH) {
                return allValid(value);
            } else {
                return someValid(value);
            }
        }

        private boolean allValid(T value) {
            AtomicBoolean isValid = new AtomicBoolean(true);
            filters.forEach(filter -> {
                boolean check = filter.filter(value);
                if (!check) {
                    isValid.set(false);
                }
            });

            return isValid.get();
        }

        private boolean someValid(T value) {
            AtomicBoolean isValid = new AtomicBoolean(false);
            filters.forEach(filter -> {
                boolean check = filter.filter(value);
                if (check) {
                    isValid.set(true);
                }
            });

            return isValid.get();
        }
    }

    public enum FilterType {
        ALL_MATCH,
        SOME_MATCH
    }
}
