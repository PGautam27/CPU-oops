package CASE

class MotherBoard{
    open var start:Boolean = false
    val k = monitor()
    private var usbPort:Boolean = false

    inner class CPU(){
        var canStart = start
        fun work(){
            if (canStart){
                var s = k.display()
                when(s){
                    1 -> usbPort = true
                    2 -> gpu().connect()
                    3 -> {
                        ramCard().connect()
                        var s = ramCard().fetch()
                        println(s.toString())
                    }
                    4 -> {
                        hardDisk().connect()
                    }
                    5 -> {
                        println("Do you wanna power off?")
                        return
                    }
                    else -> println("Sorry can't do the function right now")
                }

            }
        }
    }

    inner class gpu: pci{
        override fun connect() {
            println("connected")
        }
    }

    inner class ramCard:dimPort,sata{
        override fun connect() {
            println("Connected")
        }

        override fun fetch():ArrayList<Int> {
            return hardDisk().fetch()
        }
    }
}