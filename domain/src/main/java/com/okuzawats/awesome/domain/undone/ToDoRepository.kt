package com.okuzawats.awesome.domain.undone

/**
 * ToDoのデータ操作のためのRepository
 */
interface ToDoRepository {
  /**
   * [id]に対応するToDoを未完了状態に更新する。
   *
   * @param id 対象となるToDoのID
   * @return 更新完了に成功した場合はisSuccess = true、失敗した場合はisSuccess = falseのResult型を返す。
   */
  suspend fun unDoneToDo(id: Long): Result<Unit>
}
