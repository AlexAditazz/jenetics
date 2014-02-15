/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics;

import static org.jenetics.util.object.eq;
import static org.jenetics.util.object.hashCodeOf;

import org.jenetics.util.ISeq;

/**
 * Abstract chromosome for {@code BoundedGene}s.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version 1.6 &mdash; <em>$Date: 2014-02-15 $</em>
 * @since 1.6
 */
public abstract class BoundedChromosome<
	A extends Comparable<? super A>,
	G extends BoundedGene<A, G>
>
	extends AbstractChromosome<G>
{

	/**
	 * The minimum value of this {@code BoundedChromosome}.
	 */
	protected A _min;

	/**
	 * The maximum value of this {@code BoundedChromosome}.
	 */
	protected A _max;

	/**
	 * Create a new chromosome from the given genes array.
	 *
	 * @param genes the genes of the new chromosome.
	 * @throws IllegalArgumentException if the {@code genes.length()} is smaller
	 *         than one.
	 * @throws NullPointerException if the {@code genes} are {@code null}.
	 */
	protected BoundedChromosome(final ISeq<? extends G> genes) {
		super(genes);
		_min = genes.get(0)._min;
		_max = genes.get(0)._max;
	}

	/**
	 * Return the minimum value of this {@code BoundedChromosome}.
	 *
	 * @return the minimum value of this {@code BoundedChromosome}.
	 */
	public A getMin() {
		return _min;
	}

	/**
	 * Return the maximum value of this {@code BoundedChromosome}.
	 *
	 * @return the maximum value of this {@code BoundedChromosome}.
	 */
	public A getMax() {
		return _max;
	}

	@Override
	public int hashCode() {
		return hashCodeOf(getClass()).
			and(super.hashCode()).
			and(_min).
			and(_max).value();
	}

	@Override
	public boolean equals(final Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof BoundedChromosome<?, ?>)) {
			return false;
		}

		final BoundedChromosome<?, ?> nc = (BoundedChromosome<?, ?>)object;
		return eq(_min, nc._min) && eq(_max, nc._max) && super.equals(object);
	}

}
