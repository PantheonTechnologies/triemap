/*
 * (C) Copyright 2016 PANTHEON.tech, s.r.o. and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.pantheon.triemap;

import static java.util.Objects.requireNonNull;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * Abstract base class for key set views of a TrieMap.
 *
 * @author Robert Varga
 *
 * @param <K> the type of keys
 */
abstract class AbstractKeySet<K> extends AbstractSet<K> {
    private final TrieMap<K, ?> map;

    AbstractKeySet(final TrieMap<K, ?> map) {
        this.map = requireNonNull(map);
    }

    final TrieMap<K, ?> map() {
        return map;
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public final boolean add(final K e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public final boolean addAll(final Collection<? extends K> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("checkstyle:parameterName")
    public final boolean contains(final Object o) {
        return map.containsKey(o);
    }

    @Override
    public final boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public final int size() {
        return map.size();
    }

    @Override
    public final Spliterator<K> spliterator() {
        // TODO: this is backed by an Iterator, we should be able to do better
        return Spliterators.spliterator(immutableIterator(), Long.MAX_VALUE, spliteratorCharacteristics());
    }

    abstract int spliteratorCharacteristics();

    final Iterator<K> immutableIterator() {
        return new Iterator<>() {
            private final ImmutableIterator<K, ?> itr = map().immutableIterator();

            @Override
            public boolean hasNext() {
                return itr.hasNext();
            }

            @Override
            public K next() {
                return itr.next().getKey();
            }
        };
    }
}
