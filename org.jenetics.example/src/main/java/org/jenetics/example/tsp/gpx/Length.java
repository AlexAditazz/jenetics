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
package org.jenetics.example.tsp.gpx;

import static java.lang.String.format;

import java.io.Serializable;

/**
 * Represents a length with base unit of meters.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class Length extends Number implements Serializable {

	private static final long serialVersionUID = 1L;

	private final double _value;

	/**
	 * Create a new {@code Length} object with the given value in meters.
	 *
	 * @param value the value (in meters) of the new {@code Length} object
	 */
	private Length(final double value) {
		_value = value;
	}

	/**
	 * Return the value of the length in meter.
	 *
	 * @return the value of the length in meter
	 */
	@Override
	public double doubleValue() {
		return _value;
	}

	public double toKilometer() {
		return _value/1000.0;
	}

	@Override
	public int intValue() {
		return (int)doubleValue();
	}

	@Override
	public long longValue() {
		return (long)doubleValue();
	}

	@Override
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override
	public int hashCode() {
		return Double.hashCode(_value);
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof Length &&
			Double.compare(((Length)obj)._value, _value) == 0;
	}

	@Override
	public String toString() {
		return format("%s m", _value);
	}


	/* *************************************************************************
	 *  Static object creation methods
	 * ************************************************************************/

	public static Length ofMeters(final double meters) {
		return new Length(meters);
	}

	public static Length ofKilometers(final double km) {
		return new Length(km*1000);
	}

}