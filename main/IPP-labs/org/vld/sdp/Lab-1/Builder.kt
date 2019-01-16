package org.vld.sdp.creational

/**
 * Car
 */
data class Car constructor(val make: String, val model: String, val year: Int) {

    /**
     * Car private constructor to be used from `Car.build {}` builder DSL initialization method
     */
    private constructor(builder: Builder): this(builder.make, builder.model, builder.year)

    companion object {
        /**
         * Builds a [Car.Builder] instance as defined in the [init] function and
         * then builds a [Car] instance using private [Car]'s constructor and
         * based on the initialized in the [init] function [Car.Builder]'s properties
         */
        fun build(init: Builder.() -> Unit): Car = Builder(init).build()
    }

    /**
     * Car Builder with private constructor
     */
    class Builder private constructor() {

        // variable Car Builder's properties to be initialized in the Car Builder's constructor init function
        var make: String = ""
        var model: String = ""
        var year: Int = 0

        /**
         * [Car.Builder] constructor for applying the initialization logic through
         * the [init] function to the [Car.Builder] instance
         */
        constructor(init: Builder.() -> Unit): this() {
            init()
        }

        // variable Car Builder's properties initialization functions
        // to be called within the Car Builder's constructor init function
        fun make(init: Builder.() -> String) = apply { make = init() }

        fun model(init: Builder.() -> String) = apply { model = init() }

        fun year(init: Builder.() -> Int) = apply { year = init() }

        /**
         * Calls [Car]'s constructor by passing the [Car.Builder] instance
         * with the initialized properties for [Car] instance initialization
         */
        fun build(): Car = Car(this)
    }
}
