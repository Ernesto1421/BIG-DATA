1. 
def espar(num:Int): Boolean = {
    for (n <-  Range(2,num)) {
        if(num%2 == 0){return true}
        }; 
        return false}

2. 
def iseven(nu: Int ) = nu % 2 == 0
def isodd(nu: Int) = !iseven(nu)
   def ej(test:List[Int]): Boolean = {
       for (n <- test){
           print(n)
           if (iseven(n)){
             return true
           }
           if (isodd(n)){
               return false
           }
       }
   }
val Lista = List.range(-2,10)
ej(Lista)

3. val milist = List(1,3,3,4,6,7,3,7)
def E3(lista:List[Int]): Int = {
    val x = lista.map(e => if (e == 7) 14 else e)
    val TT = x.sum
    return TT
}
E3(milist)

4. 
def E4 (listap: List[Int], seccion: Int): Boolean= {
    var sup = 0
         var inf = 0
         var x = 0
         while (x < listap.size){
             if (x <= seccion-1){
                 sup= sup + listap(x)
                 println(sup)
              }
             else {
             inf = inf + listap(x)
             println(inf)
             }
             x = x+1
    
         }
         if (sup == inf) {
             return true
         }
         else{
             return false
         }
     }

5.
def palindromo (palabra: String): Boolean = {
    return (palabra == palabra.reverse)
}
val palabra = "OSO"
val palabra2 = "ANA"
val palabra3 = "oxxo"
