package CASE

class MotherBoard{
    var start:Boolean = false
    val k = monitor()
    val hd = hardDisk()
    val rc = ramCard()
    private var usbPort:Boolean = false

    inner class CPU(){
        init {
            work()
        }
        private fun work(){
            if (start){
                while (start){
                    var s = k.display()
                    when(s){
                        1 -> usbPort = true
                        2 -> gpu().connect()
                        3 -> {
                            rc.connect()
                            var s = ramCard().fetch()
                            println(s)
                        }
                        4 -> {
                            hd.connect()
                            println("Enter a value of Int: ")
                            var x: Int = Integer.valueOf(readLine())
                            hd.store(x)
                        }
                        5 -> {
                            println("Do you wanna power off?")
                            start = false
                            smps(null)
                            return
                        }
                        else -> println("Sorry can't do the function right now")
                    }
                }
            }
            else
                println("Sorry the pc won't work.")
        }
    }

    inner class gpu: pci{
        private var conEstablishment:Boolean =false
        override fun connect() {
            conEstablishment = true
        }

    }

    inner class ramCard:dimPort,sata{
        private var conEstablishment:Boolean =false
        override fun connect() {
            conEstablishment = true
            println("Successful connection in ram")
        }

        override fun fetch():ArrayList<Int> {
            if (conEstablishment){
                return hd.fetch()
            }
            return hd.fetch()
        }
    }
}