package CASE
internal var switch = switchOn.SWITCHOFF
internal var state = states.POWEROFF
internal var inputOutput = inputAndOutputPort.NONE
class Case(i:Int) {
    private val k = smps(i)
    init {
        casef()
    }
    fun casef(){
        if(!switchOn.switchState(switch)){
            return
        }
        print("Do you want to power on the CPU: ")
        val yesNO = readLine()
        var s = k.changeState(yesNO.toString())
        if (!s){
            return
        }
    }
    class smps(PowerValue: Int){
        private var powerSocket:Int = PowerValue
        var reset:Boolean = false
        val k:MotherBoard = MotherBoard()
        init {
            var s = breakLive()
            if (s==-1){
                println("Sorry the voltage $PowerValue is too high or too low")
            }
        }
        fun changeState(a:String):Boolean{
            return if (a=="yes"){
                state = states.POWERON
                k.CPU()
                true
            } else {
                println("Not powering on")
                state = states.POWEROFF
                false
            }
        }
        fun reset(){
            if (reset){
                k.CPU().eraseAll()
            }
        }
        private fun breakLive():Int{
            return if(powerSocket in 210..240){
                switch = switchOn.SWITCHON
                1
            } else{
                -1
            }
        }
    }
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
                                inputOutput = inputAndOutputPort.INPUT
                                println("Input received")
                            }
                            2 -> {
                                gpu().connect()
                                inputOutput = inputAndOutputPort.OUTPUT
                                println("IMAGE: -_- ^_^ ^_-")
                            }
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
    class hardDisk:sata{
        var connect:Boolean = false
        private var capacity:Int = 100
        private var balance:Int = capacity
        private var arrayList: ArrayList<Int> = ArrayList<Int>()
        override fun connect() {
            connect = true
        }
        fun store(a:Int){
            if (connect){
                if (a <=1000){
                    balance -= 2
                    arrayList.add(a)
                }
                else if (a in 1001..100000){
                    balance -=5
                    arrayList.add(a)
                }
                else {
                    balance -=10
                    arrayList.add(a)
                }

            }
        }
        fun erase(){
            arrayList = arrayListOf(0)
        }
        override fun capacityBalance() {
            println("The capacity is$capacity GB")
            println("The balance is $balance GB")
        }
        override fun fetch(): ArrayList<Int> {
            if (connect){
                return arrayList
            }
            return arrayListOf(0)
        }
    }
}
fun main() {
    print("Enter the voltage supplied for the socket: ")
    val voltage:Int = Integer.valueOf(readLine())
    val s = Case(voltage)
}


