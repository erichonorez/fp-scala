// https://www.it.uu.se/edu/course/homepage/funpro/ht11/exercise-tail-recursion.html
import RecursiveFunctions._

object RecursiveFunctions {

    def factorial(n: Int): Int = {
        if (n <= 0) 1
        else n * factorial1(n - 1)
    }

    def tail_factorial(n: Int): Int = {
        def go(n: Int, acc: Int): Int = {
            if (n <= 0) acc
            else go(n - 1, acc * n)
        }
        go(n, 1)
    }

    def fibonacci(n: Int): Int = {
        if (n <= 2) n - 1
        else fib(n - 1) + fib (n - 2)
    }

    def loop_fibonacci(n: Int): Int = {

        var i = n
        var a = 0
        var b = 1

        while (i > 0) {

            var c = a + b;
            a = b
            b = c

            i = i - 1

        }

        a

    }

    def tail_fibonacci(n: Int): Int = {

        @annotation.tailrec
        def go(i: Int, a: Int, b: Int): Int = {
            if (i <= 0) a
            else go(i - 1, b, a + b)
        }

        go(n, 0, 1)

    }

    def loop_exp(x: Int, n: Int): Int = {
        var i = n;
        var a = 1

        while (i > 0) {
            a = a * x
            i = i - 1
        }

        a

    }

    def tail_exp(x: Int, n: Int): Int = {
        @annotation.tailrec
        def loop(n: Int, acc: Int): Int = {
            if (n <= 1) acc
            else loop(n - 1, acc * x)
        }
        loop(n, x)
    }

    def indexOf(elements: Array[String], el: String): Int = {
        @annotation.tailrec
        def loop(n: Int): Int = {
            if (n >= elements.length) -1
            else if (elements(n) == el) n
            else loop(n + 1)
        }
        loop(0)
    }
