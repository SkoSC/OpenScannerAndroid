package com.skosc.oscan

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class OpenScannerBuilder<T> {

    var executor: Executor? = null
    var scanner: ImageScanner<T>? = null
    var filter: Filter<T>? = null

    fun executor(executor: Executor): OpenScannerBuilder<T> {
        this.executor = executor
        return this
    }

    fun scanner(scanner: ImageScanner<T>): OpenScannerBuilder<T> {
        this.scanner = scanner
        return this
    }

    fun filter(filter: Filter<T>): OpenScannerBuilder<T> {
        this.filter = filter
        return this
    }

    fun build(): OpenScanner<T> = OpenScanner(
        executor = this.executor ?: Executors.newSingleThreadExecutor(),
        scanner = this.scanner ?: error("Scanner is required to build OpenScanner"),
        filter = this.filter ?: Filter { true }
    )
}