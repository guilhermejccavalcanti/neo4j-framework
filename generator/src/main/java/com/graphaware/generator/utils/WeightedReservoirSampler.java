package com.graphaware.generator.utils;

import java.util.Random;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Utility to allow for weighted reservoir sampling
 * using A-ES algorithm from:
 *
 * Weighted Random Sampling over Data Streams
 * by Pavlos S. Efraimidis
 * (Democritus University of Thrace)
 *
 * I needed only first element. The class could be extended to
 * mimick ReservoirSampler easilly though.
 *
 * TODO: merge this more closely to the network (ideally into common.util)
 */
public class WeightedReservoirSampler /*extends ReservoirSampler<T> ? */{
    private final Random random;

    /**
     * Create a new sampler with a certain reservoir size.
     */
    public WeightedReservoirSampler() {
        random = new Random();
    }


    /**
     * Returns an index of the weight at random, but weighted accordingly
     * @return result
     */
    public int randomIndexChoice(List<Integer> weights) {
        int result = 0, index;
        double maxKey = 0.0;
        double u, key;
        int weight;

        for (ListIterator<Integer> it = weights.listIterator(); it.hasNext(); ) {
            index = it.nextIndex();
            weight = it.next();
            u = random.nextDouble();
            key = Math.pow(u, (1.0/weight)); // Protect from zero division?

            if (key > maxKey) {
                maxKey = key;
                result = index;
            }
        }

        return result;
    }

    /**
     * Returns a randomly chosen index, omitting a given indices.
     * This is very specific override.
     * @param weights weights to sample from
     * @param omitIndices indices to omit from sampling
     * @return index chosen according to the weight supplied
     */
    public int randomIndexChoice(List<Integer> weights, Set<Integer> omitIndices) {
        int result = 0, index;
        double maxKey = 0.0;
        double u, key;
        int weight;

        for (ListIterator<Integer> it = weights.listIterator(); it.hasNext(); ) {
            index = it.nextIndex();
            weight = it.next();

            if (omitIndices.contains(index))
                continue;


            u = random.nextDouble();
            key = Math.pow(u, (1.0 / weight));

            if (key > maxKey) {
                maxKey = key;
                result = index;
            }
        }

        return result;
    }


    /**
     * Returns a randomly chosen index, omitting a given index.
     * This is very specific override used in the Simple graph
     * algorithm.
     * @param weights list of weights to sample from
     * @param omit list of indices to omit
     * @return randomly (weighted) chosen index
     */
    public int randomIndexChoice(List<Integer> weights, int omit) {
        int result = 0, index;
        double maxKey = 0.0;
        double u, key;
        int weight;

        for (ListIterator<Integer> it = weights.listIterator(); it.hasNext(); ) {
            index = it.nextIndex();
            weight = it.next();

            if (index == omit)
                continue;

            u = random.nextDouble();
            key = Math.pow(u, (1.0/weight));

            if (key > maxKey) {
                maxKey = key;
                result = index;
            }
        }

        return result;
    }
}
