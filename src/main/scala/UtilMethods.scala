import java.io.File

import scala.collection.mutable
import scala.util.Random

object UtilMethods {

  def zeros(size: Int): Array[Char] = Array.fill(size)('0')
  def ones(size: Int): Array[Char] = Array.fill(size)('1')
  def empties(size: Int): Array[Char] = Array.fill(size)(Color.Empty)

  def listSgfFiles(dir: String, limit: Option[Int]) = {
    val d = new File(dir)
    val dst =
      if (d.exists && d.isDirectory) {
        val a = d.listFiles
        limit match {
          case Some(x) if a.isEmpty =>
            println("There are not sgf files in sgf dir")
            Array[File]()
          case Some(x) if a.length > x => a.take(x)
          case _ => a
        }
      } else {
        d.mkdir()
        println("Created new directory `sgf`. Put files in it and then run again.")
        Array[File]()
      }
    dst.filter(_.getName endsWith "sgf")
  }

  def intArr2charArr(x: Array[Int]) = x.map{ a => if (a > 9) '9' else ('0'+a).toChar }
  def charArr2intArr(x: Array[Char]) = x.map{ _.asDigit }

  def zipEach[T, U](list1: Seq[T], list2: Seq[U])(f: Function2[T, U, Unit]) = {
    val iter1 = list1.iterator
    val iter2 = list2.iterator
    while (iter1.hasNext) f(iter1.next(), iter2.next())
  }

  def createRandomBoard: Array[Char] = {
    import Color._
    val rand = new Random
    def next = rand.nextInt(3)
    Array.range(0, 361).map{ i =>
      val n = next
      if (n == 0) Empty
      else if (n == 1) White
      else if (n == 2) Black
      else {
        throw new RuntimeException
      }
    }
  }

  // arg parsing
  type Arg = (String, String)
  type Args = mutable.Set[Arg]

  @scala.annotation.tailrec
  def parseArgs(remain: List[String], results: Args = mutable.Set()): Args =
    remain match {
      case pref :: value :: rem =>
        if (pref.startsWith("-")) results.add((pref, value))
        parseArgs(rem, results)
      case Nil => results
    }
  // arg parsing end

  def execCmd(cmd: String): String = scala.sys.process.Process(cmd).!!

  def checkBoardLegality(in: Array[Char]): Boolean = {
    val liberties = Rules.liberties(in)
    var i = 0
    while (i < Config.all) {
      val col = in(i)
      val lib = liberties(i)
      if (col != Color.Empty) {
        if (lib <= 0) {
          //in.printState(19, 19, None, None)
          return false
        }
      }
      i += 1
    }
    true
  }

  // pad the array around with the provided element
  def pad(in: Array[Char], row: Int, col: Int, padSize: Int, padElem: Char) = {
    assert(in.length == row * col)
    val allNum = row * col

    def zeros(n: Int) = Array.fill(n)(padElem)
    def chunk = zeros((col + padSize * 2) * padSize)

    // 1 (chunk + 2)
    var dst: Array[Char] = chunk ++ zeros(padSize)

    var i = 0
    while (i <= allNum - col * 2) {
      // slice one row
      val a = in.slice(i, i + col)
      val b = a ++ zeros(padSize * 2)
      dst = dst ++ b
      i += col
    }
    dst = dst ++ (in.slice(i, i + col) ++ (zeros(padSize) ++ chunk.clone()))
    dst
  }

  def clip(in: Array[Char], row: Int, col: Int, borderWidth: Int) = {
    assert(in.length == row * col)
    val dstRow = row - borderWidth * 2
    val dstCol = col - borderWidth * 2
    val dst = Array.fill(dstRow * dstCol)(' ')
    var i, j = 0
    while (i < dstRow) {
      j = 0
      while (j < dstCol) {
        dst(dstCol*i+ j) = in((i+borderWidth) * col + (j + borderWidth))
        j += 1
      }
      i += 1
    }
    dst
  }

  def clip(x: Array[Int], row: Int, col: Int, borderWidth: Int) = {
      assert(x.length == row * col)
      val dstRow = row - borderWidth * 2
      val dstCol = col - borderWidth * 2
      val dst = Array.fill(dstRow * dstCol)(0)
      var i, j = 0
      while (i < dstRow) {
        j = 0
        while (j < dstCol) {
          dst(dstCol*i+ j) = x((i+borderWidth) * col + (j + borderWidth))
          j += 1
        }
        i += 1
      }
      dst
    }

}
