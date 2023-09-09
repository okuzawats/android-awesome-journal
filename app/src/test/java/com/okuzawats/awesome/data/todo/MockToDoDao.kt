//package com.okuzawats.awesome.data.todo
//
//import io.mockk.every
//import io.mockk.mockk
//
//val mockToDoDao : ToDoDao = mockk<ToDoDao>(relaxUnitFun = true).also {
//  every {
//    it.getById(DefaultToDoRepositoryTest.ID_IN_SUCCESS_TODO)
//  } returns ToDoEntity(
//    id = DefaultToDoRepositoryTest.ID_IN_SUCCESS_TODO,
//    whatToDo = "whatToDo",
//    isDone = false,
//  )
//
//  every {
//    it.getById(DefaultToDoRepositoryTest.ID_IN_SUCCESS_DONE)
//  } returns ToDoEntity(
//    id = DefaultToDoRepositoryTest.ID_IN_SUCCESS_DONE,
//    whatToDo = "whatToDo",
//    isDone = true,
//  )
//
//  every {
//    it.getById(DefaultToDoRepositoryTest.ID_IN_FAILURE)
//  } throws Throwable("oops")
//}
