package org.company.test.core.baseclass

abstract class BaseUseCase<Input, Output> {
    abstract operator fun invoke(input: Input): Output
}