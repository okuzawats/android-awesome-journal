package com.okuzawats.awesome.domain.done

/**
 * ToDoのデータ操作のためのRepository
 */
interface ToDoRepository {
  /**
   * [id]に対応するToDoを完了状態に更新する。
   *
   * @param id 対象となるToDoのID
   */
  fun doneToDo(id: Long): Result<Unit>
}
