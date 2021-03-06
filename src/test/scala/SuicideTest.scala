object SuicideTest extends App {

  import Rules._
  import UtilMethods._
  import Implicits._

  assert(!isSuicideMove(Move(Color.Black, 2, 11, isValid=true), board))
  assert(isSuicideMove(Move(Color.Black, 1, 11, isValid=true), board1))
  assert(isSuicideMove(Move(Color.White, 3, 13, isValid=true), board2))
  assert(isSuicideMove(Move(Color.White, 0, 0, isValid=true), board4))
  assert(!isSuicideMove(Move(Color.White, 12, 12, isValid=true), board4))

  def board2 = Array(
    '.', 'X', '.', 'X', '.', 'X', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    'O', 'O', 'X', 'X', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    'O', 'O', 'X', 'O', 'X', '.', 'X', 'X', '.', 'X', 'X', '.', 'X', '.', '.', '.', '.', '.', '.',

    'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', '.', 'X', 'X', '.', 'X', 'X', '.', 'X', '.', '.',

    'X', 'X', 'O', 'X', '.', 'X', 'O', '.', 'X', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.',

    '.', '.', 'X', 'X', 'X', '.', 'X', '.', 'X', '.', 'X', '.', 'X', '.', '.', '.', '.', '.', '.',

    'X', 'X', '.', '.', 'X', 'X', 'X', 'X', '.', '.', '.', '.', 'X', 'X', '.', '.', '.', '.', '.',

    'X', 'O', 'O', 'O', 'X', 'O', 'X', 'X', 'X', '.', '.', '.', '.', '.', 'X', 'X', '.', '.', '.',

    'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', '.', 'X', '.', 'X', '.', '.', '.', '.', '.',

    'X', 'X', 'X', 'O', 'O', 'O', '.', 'O', 'X', 'X', '.', 'X', 'X', 'X', '.', 'X', '.', '.', '.',

    'X', 'O', 'O', 'O', '.', '.', '.', 'O', 'X', '.', 'X', '.', '.', '.', '.', '.', 'X', '.', '.',

    'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', '.', '.', 'X', 'X', '.', '.', '.', '.', '.', '.',

    'O', 'O', 'X', 'X', 'O', '.', '.', '.', 'O', 'X', '.', 'X', '.', '.', '.', '.', '.', '.', '.',

    'X', 'O', 'X', '.', 'X', 'O', 'O', '.', 'O', 'X', '.', 'X', '.', '.', '.', '.', '.', '.', '.',

    'X', 'X', '.', 'X', '.', 'X', 'O', '.', 'O', 'X', '.', 'X', '.', '.', '.', '.', 'X', '.', '.',

    '.', 'X', '.', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', '.', '.', '.', '.', '.', '.', '.',

    '.', 'X', 'X', '.', 'X', 'O', 'O', 'X', 'X', 'X', '.', '.', '.', '.', '.', 'X', '.', '.', '.',

    '.', '.', 'X', 'X', 'O', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', 'X', 'X', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'
  )

  def board1 =  Array(
    '.', '.', '.', 'O', 'O', 'O', 'X', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', 'O', 'X', 'X', 'X', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'O', 'X', 'X', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'X', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'O', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', 'O', '.', 'O', '.', '.', '.', '.', '.', '.', '.', 'O', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    'O', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.',

    '.', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', 'X', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'
  )

  def board =  Array(
    '.', '.', '.', 'O', 'O', 'O', 'X', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', 'O', 'X', 'X', 'X', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'O', 'X', 'X', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'X', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'O', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', 'O', '.', 'O', '.', '.', '.', '.', '.', '.', '.', 'O', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', 'O', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    'O', 'X', '.', 'O', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.',

    'X', 'O', 'O', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', 'X', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'
  )


  def board4 = Array(
    '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    'X', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', 'X', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', 'X', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',

    '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'
  )

}
