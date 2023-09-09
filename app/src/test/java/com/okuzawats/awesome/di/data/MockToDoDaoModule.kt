//package com.okuzawats.awesome.di.data
//
//import com.okuzawats.awesome.data.todo.ToDoDao
//import com.okuzawats.awesome.data.todo.mockToDoDao
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.components.SingletonComponent
//import dagger.hilt.testing.TestInstallIn
//
//@Module
//@TestInstallIn(
//  components = [SingletonComponent::class],
//  replaces = [ToDoDaoModule::class],
//)
//class MockToDoDaoModule {
//  @Provides
//  fun provideMockToDoDao(): ToDoDao = mockToDoDao
//}
