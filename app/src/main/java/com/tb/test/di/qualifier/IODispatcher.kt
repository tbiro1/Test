package com.tb.test.di.qualifier

import javax.inject.Qualifier

/**
 * Qualifier for access IO Dispatcher
 */
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class IODispatcher
