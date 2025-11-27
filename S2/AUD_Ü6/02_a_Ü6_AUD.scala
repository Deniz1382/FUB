//a hash table with chaining
//the hashCode function, which is available for all objects in Scala
//the size of the hash table can be selected
//at least two different compression functions

def smartcompress(size : Int): Int => Int =
        // modulo method for small tables
        if size <= 50 then
          (hash) => (hash % size + size) % size
        // multiplication method for large tables
        else 
           (hash: Int) => 
               val A = 0.6180339887
                val fractional = (hash * A) % 1
               (size * fractional).toInt 

class HashTable[K, V](size: Int, compressionfunction : Int => Int): //K and V are generic to be available for all objects
    val table = Array.fill(size)(List.empty[(K, V)]) // genrate an empty list 

    private def indexForKey(key: K): Int =
        val hash : Int = key.hashCode() // using hashCode to get int 
        compressionfunction(hash) //compress to get the index less than size

    def put(key: K, value : V) : Unit = 
        val index = indexForKey(key)
        table(index) = table(index).filterNot(_._1 == key) //delete last one if any
        table(index) = (key, value) :: table(index) //append


    def get (key : K): V =
        val index = indexForKey(key)
        val key_check = table(index).find(_._1 == key)
        key_check match
            case Some((_, v)) => v
            case None => throw new NoSuchElementException("element not found")

    def remove(key : K) : Unit =
        val index = indexForKey(key)
        val key_check = table(index).find(_._1 == key)
        key_check match
            case Some(_) => table(index) = table(index).filterNot(_._1 == key)
            case None => throw new NoSuchElementException("element not found")


@main def test(): Unit =
        val compress = smartcompress(10)
        val ht = new HashTable[Int, String](10, compress)
        ht.put(1, "cuckoo")
        println(ht.get(1))




