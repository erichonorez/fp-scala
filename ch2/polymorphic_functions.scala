object PolymorphicFunctions {

def isSorted[A](elements: Array[A], ordered: (A, A) => Boolean): Boolean = {
   @annotation.tailrec
   def loop(n: Int): Boolean = {
       if (n >= elements.length - 1) true
       else if (!ordered(elements(n), elements(n + 1))) false
       else loop(n + 1)
   }

   loop(0)
}

}
