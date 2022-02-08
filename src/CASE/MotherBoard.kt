package CASE

class MotherBoard{
    private val k = monitor()
    private val hd = hardDisk()
    private val rc = ramCard()
    var usbPort:Boolean = false
    var audioJack:Boolean = false
    inner class CPU(){
        init {
            work()
        }
        private fun work(){
            var st = states.State(state)
            if (st){
                while (st){
                    st = states.State(state)
                    var s = k.display()
                    when(s){
                        1 -> {
                            usbPort = true

                        }
                        2 -> gpu().connect()
                        3 -> {
                            rc.connect()
                            var s = ramCard().fetch()
                            println(s)
                            println("Would you like to see the balance and capacity of the storage: ")
                            var y = readLine()
                            if (y.toString() == "yes"){
                                hd.capacityBalance()
                            }
                        }
                        4 -> {
                            hd.connect()
                            println("Enter a value of Int: ")
                            var x: Int = Integer.valueOf(readLine())
                            hd.store(x)

                        }
                        5 -> {
                            println("Do you wanna power off?")
                            var yesOrNo = readLine()
                            if (yesOrNo.toString() == "yes"){
                                state = states.POWEROFF
                                switch = switchOn.SWITCHOFF
                                return
                            }
                            else{
                                println("Ok")
                                continue
                            }

                        }
                        else -> println("Sorry can't do the function right now")
                    }
                }
            }
            else
                println("Sorry the pc won't work.")
        }
        fun eraseAll(){
            hd.erase()
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
        }

        override fun fetch():ArrayList<Int> {
            if (conEstablishment){
                return hd.fetch()
            }
            return hd.fetch()
        }
    }
}