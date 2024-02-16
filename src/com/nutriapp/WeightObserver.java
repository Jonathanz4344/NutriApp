package com.nutriapp;

/*
 * This interface is responsible for updating the weight of a user.
 * responsible for updating weight when having observer to detect weight
 */
interface WeightObserver {
    void updateWeight(double weight);
}