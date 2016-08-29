// http://www.vasinov.com/blog/on-currying-and-partial-function-application/#toc-pfa
import MyModule._

object MyModule {

    def multiply(a: Int, b: Int): Int = {
        a * b
    }
    
    def x2(b: Int): Int = {
        multiply(2, b)
    }
    
    def partially[A, B, C](a: A, f: (A, B) => C): B => C = {
        (b: B) => 
            f(a, b)
    }
    
    
    def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
        (a: A) => partially(a, f)
    } 
    
    def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
        (a: A, b: B) => f(a)(b)
    }
    
    
    def compose[A,B,C](f: B => C, g: A => B): A => C = {
        (a: A) => f(g(a))
    }

}

partially(2, (a: Int, b: Int) => a * b)(4)


