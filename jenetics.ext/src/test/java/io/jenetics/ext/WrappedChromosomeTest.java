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
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.at)
 */
package io.jenetics.ext;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.testng.annotations.Test;

import io.jenetics.Chromosome;
import io.jenetics.DoubleChromosome;
import io.jenetics.DoubleGene;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.IntegerChromosome;
import io.jenetics.IntegerGene;
import io.jenetics.Mutator;
import io.jenetics.NumericGene;
import io.jenetics.engine.Codec;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.engine.EvolutionStream;
import io.jenetics.engine.Limits;
import io.jenetics.engine.Problem;
import io.jenetics.util.Factory;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.at">Franz Wilhelmstötter</a>
 */
public class WrappedChromosomeTest {

	static double fitness(final Genotype<WrappedGene<Number>> gene) {
		return 1;
	}

	@Test
	public void create() {
		final Genotype<WrappedGene<Number>> gt = Genotype.of(
			WrappedChromosome.of(DoubleChromosome.of(0.0, 10.0, 5)),
			//new WrappedChromosome<>(CharacterChromosome.of(4)),
			WrappedChromosome.of(IntegerChromosome.of(0, 10, 5))
		);

		final Engine<WrappedGene<Number>, Double> engine = Engine
			.builder(WrappedChromosomeTest::fitness, gt)
			.alterers(new Mutator<>())
			.build();

	}

	@Test
	public void foo() {
		//final Genotype<NumericGene<Number, NumericGene<?, ?>>>

		NumericGene<Double, DoubleGene> dg = DoubleGene.of(0, 1);
		NumericGene<Integer, IntegerGene> ig = IntegerGene.of(0, 1);

		NumericGene<? extends Number, ?> ag = ig;
		ag = dg;

		Genotype<? extends NumericGene<? extends Number, ?>> gt = null;

		Engine<? extends NumericGene<? extends Number, ?>, Double> engine = null;
		EvolutionStream<? extends NumericGene<? extends Number, ?>, Double> stream = engine.stream();

//		stream
//			.limit(Limits.bySteadyFitness(12))
//			.collect(EvolutionResult.toBestGenotype());


		//		final Genotype<NumericGene<? extends Number, ?>> genotype = of(
//			DoubleChromosome.of(0.0, 1.0),
//			IntegerChromosome.of(0, 19)
//		);
//
//		final Codec<Double, ? extends NumericGene<? extends Number, ?>> codec =
//			Codec.of(
//				genotype,
//				gt -> 0.0
//			);

		/*
		final Problem<double[], ? extends NumericGene<? extends Number, ?>, Double> problem = Problem.of(
			array -> 0.0,
			codec
		);

		final Engine<? extends NumericGene<? extends Number, ?>, Double> engine =
			Engine.builder(g -> 0.0, codec).build();
		*/
	}

//	@SafeVarargs
//	static //<NumericGene<? extends Number, ?>>
//	Genotype<
//		N extends NumericGene<? extends Number, N>
//	> of(
//		final Chromosome<N extends NumericGene<? extends Number, ?>> first,
//		final Chromosome<? extends NumericGene<? extends Number, ?>>... rest
//	) {
//		return Genotype.of(
//			(Chromosome)first,
//			(Chromosome[]) rest
//		);
//	}
//
//	public static <T> Codec<T, ? extends NumericGene<? extends Number, ?>> codec(
//		final Factory<Genotype<? extends NumericGene<? extends Number, ?>>> encoding,
//		final Function<Genotype<? extends NumericGene<? extends Number, ?>>, T> decoder
//	) {
//		return null;
//	}

	//static class NumberGene<>

}
