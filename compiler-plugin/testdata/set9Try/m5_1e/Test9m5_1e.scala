package cpstest

import cps.*
import cps.monads.{*,given}

import testUtil.*


object Test9m5_1e {

  var finallyWasRun=false

  def wrapped[A](a:A): CpsDirect[FreeMonad] ?=> A = a

  def simpleTry(x:String)(using CpsDirect[FreeMonad]): Int = {
    try
      wrapped(x).toInt
    finally
      finallyWasRun = true
  }

  def main(args:Array[String]): Unit = {
    val input = "not-a-number"
    val fr = reify[FreeMonad] {
      simpleTry(input)
    }
    val r = fr.tryEval
    if (r.isFailure && finallyWasRun) then
      println("Ok")
    else
      println("r=$r")
  }


}