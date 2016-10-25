
// when we call a function we pass arguments
// allow us to pass argument by specifying name

package com.simple

object namedArgs {
  def main(args:Array[String]){
    printname(fname="sri",lname="govind")
  }
    def printname(fname:String,lname:String){
    print(fname+" "+lname)
  }
}
