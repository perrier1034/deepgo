import Implicits._
import Utils._

object TargetDistributionTest {

  //  /**
  //    * @param dst return value of Main.distributeTargetMoves()
  //    */
  //def apply(dst: Seq[(State, Seq[Move])]) = {
  //  val (states, moves) = dst.unzip
  //  zipEach(states, moves) { (curState, moveChunk: Seq[Move]) =>
  //    var answerState = curState
  //    var createdState = curState

  //    for (m <- moveChunk) {
  //      try {
  //        createdState = createdState nextStateBy m
  //        answerState = states nextOf answerState
  //        assert(createdState.board sameElements answerState.board)
  //      } catch { case e: IndexOutOfBoundsException => /* ignore */ }
  //    }
  //  }
  //}

}
