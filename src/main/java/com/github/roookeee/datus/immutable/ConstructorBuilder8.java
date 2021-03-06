package com.github.roookeee.datus.immutable;

import com.github.roookeee.datus.api.Datus;
import com.github.roookeee.datus.functions.Fn8;
import com.github.roookeee.datus.functions.Fn9;

import java.util.function.Function;

public final class ConstructorBuilder8<In, A, B, C, D, E, F, G, H, Out>
        extends AbstractConstructorBuilder<In, ConstructorBuilder8<In, A, B, C, D, E, F, G, H, Out>>
        implements ConstructorParameter<In, A, ConstructorBuilder7<In, B, C, D, E, F, G, H, Out>> {
    private final Fn9<In, A, B, C, D, E, F, G, H, Out> constructor;

    /**
     * ***NOTE***: It is encouraged to use the {@link Datus} class instead of directly
     * instantiating any constructor builder objects by yourself as javas type inference cannot infer the generic types
     * of these objects. The {@link Datus} class alleviates this problem.
     *
     * @param constructor the constructor to generate a builder for
     */
    public ConstructorBuilder8(Fn8<A, B, C, D, E, F, G, H, Out> constructor) {
        this((in, a, b, c, d, e, f, g, h) -> constructor.apply(a, b, c, d, e, f, g, h));
    }

    ConstructorBuilder8(Fn9<In, A, B, C, D, E, F, G, H, Out> constructor) {
        this.constructor = constructor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConstructorBuilder7<In, B, C, D, E, F, G, H, Out> bind(Function<? super In, ? extends A> getter) {
        return new ConstructorBuilder7<>(applyGetter(getter));
    }

    @Override
    ConstructorBuilder8<In, A, B, C, D, E, F, G, H, Out> getSelf() {
        return this;
    }

    private Fn8<In, B, C, D, E, F, G, H, Out> applyGetter(Function<? super In, ? extends A> getter) {
        return (in, b, c, d, e, f, g, h) -> constructor.apply(in, getter.apply(in), b, c, d, e, f, g, h);
    }
}
