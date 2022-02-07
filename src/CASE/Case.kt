package CASE

class Case {

}
class monitor{
    fun display(): Int {
        var case: Case = Case()
        println("Choose any on of the option")
        println("1.Do you wanna use the USB port")
        println("2.Do you wanna see images")
        println("3.Do you wanna fetch data")
        println("4.Do you wanna store data")
        println("5.quit")
        var i: Int = Integer.valueOf(readLine())
        return i
    }
}
fun main() {
    val obj:smps = smps(240)
    obj.powerButton= false
    obj.changeState()
}

class smps(PowerValue: Int){
    var powerSocket:Int = PowerValue
    var powerButton:Boolean = false
    var reset:Boolean = false
    private var earth:Boolean = false
    private var live:Boolean = false
    private var neutral:Boolean = false
    val k:MotherBoard = MotherBoard()
    init {
        breakLive()
    }
    fun changeState(){
        k.start = powerButton && live && earth && neutral
    }
    fun reset(){
        if (reset){

        }
    }
    private fun breakLive(){
        if (powerSocket>210 || powerSocket<=240){
            live = true
            earth = true
            neutral = true
        }

    }
}
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
                        ramCard()
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

interface sata{
    fun fetch(): ArrayList<Int>
    fun connect()
}
interface dimPort{
    fun connect()
}
interface pci{
    fun connect()
}
class hardDisk:sata{
    var connect:Boolean = false
    private var capacity:Int = 1000
    private var balance:Int = 0
    private var arrayList: ArrayList<Int> = ArrayList()
    override fun connect() {
        connect = true
    }
    fun store(a:Int){
        if (connect){
            arrayList.add(a)
        }
    }
    override fun fetch(): ArrayList<Int> {
        if (connect){

            return arrayList
        }
        return arrayList
    }
}
